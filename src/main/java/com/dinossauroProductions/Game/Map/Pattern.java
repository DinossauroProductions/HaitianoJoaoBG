package com.dinossauroProductions.Game.Map;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;

public class Pattern {



    private boolean[][] tiles;

    private HashSet<Direction> directions;


    public Pattern(BufferedImage reference){

        directions = new HashSet<>();

        tiles = new boolean[reference.getWidth()][reference.getHeight()];

        createMapPattern(reference);

    }

    public Pattern(boolean[][] tiles, HashSet<Direction> directions){
        this.tiles = tiles;
        this.directions = directions;
    }

    public static ArrayList<Pattern> loadPatterns(BufferedImage reference){
        ArrayList<Pattern> list = new ArrayList<>();

        int width = reference.getWidth() / 6;
        int height = reference.getHeight() / 6;

        for(int xx = 0; xx < width; xx++){
            for(int yy = 0; yy < height; yy++){
                list.add(new Pattern(reference.getSubimage(xx * 6, yy * 6, 6, 6)));
            }
        }

        return list;
    }

    private void createMapPattern(BufferedImage reference){

        for(int yy = 0; yy < reference.getHeight(); yy++){
            for(int xx = 0; xx < reference.getWidth(); xx++){

                int currentPixel = reference.getRGB(xx, yy);

                if(currentPixel == 0xFF262b44){
                    //chão
                    tiles[yy][xx] = false;
                }
                else if (currentPixel == 0xFF3a4466){
                    //chão e porta, não sei como vou interpretar a porta
                    tiles[yy][xx] = false;
                    createDoor(xx, yy);
                }
                else if(currentPixel == 0xFFFFFFFF){
                    //parede
                    tiles[yy][xx] = true;
                }
            }
        }

    }

    private void createDoor(int x, int y){
        if(x == 0){
            directions.add(Direction.WEST);
        }
        else if(x == 5){
            directions.add(Direction.EAST);
        }
        if(y == 0){
            directions.add(Direction.NORTH);
        }
        else if(y == 5){
            directions.add(Direction.SOUTH);
        }

    }

    public boolean[][] getTiles(){
        return tiles;
    }

    public static Pattern getStartingPattern(){
        boolean[][] startTiles = new boolean[6][6];
        startTiles[2][0] = true;
        startTiles[3][0] = true;
        startTiles[2][1] = true;
        startTiles[3][1] = true;
        HashSet<Direction> dirs = new HashSet<Direction>();
        dirs.add(Direction.NORTH);
        return new Pattern(startTiles, dirs);
    }

    @Override
    public String toString(){
        return getTilesAsString(tiles);
    }

    private String getTilesAsString(boolean[][] tiles){
        String sum = "";
        for(int xx = 0; xx < tiles.length; xx++){
            for(int yy = 0; yy < tiles.length; yy++){
                sum = sum.concat(tiles[xx][yy] ? "# " : "  ");
            }
            sum = sum.concat("\n");
        }
        return sum;
    }

}
