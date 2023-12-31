package com.dinossauroProductions.GameLogic.Map;

import com.dinossauroProductions.Main.Main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public record Pattern(List<MapManager.WallTile> walls, MapManager.Direction[] directions){

    public static List<Pattern> loadPatterns(BufferedImage referenceImage) {

        ArrayList<Pattern> patterns = new ArrayList<>();

        int width = referenceImage.getWidth() / 6,
            height = referenceImage.getHeight() / 6;

        for(int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                patterns.add(loadPattern(referenceImage.getSubimage((xx * 6) , (yy * 6), 6, 6)));
            }
        }

        return patterns;

    }

    public static Pattern loadPattern(BufferedImage referenceCutImage){

        Main.spritesTest.add(referenceCutImage);

        ArrayList<MapManager.WallTile> walls = new ArrayList<>();
        HashSet<MapManager.Direction> directions = new HashSet<>();

        for(short xx = 0; xx < referenceCutImage.getWidth(); xx++){
            for(short yy = 0; yy < referenceCutImage.getHeight(); yy++){



                int pixelAtual = referenceCutImage.getRGB(xx, yy);

                switch (pixelAtual) {
                    case 0xFFFFFFFF ->
                        //parede

                            walls.add(new MapManager.WallTile(xx, yy));
                    case 0xFF3a4466 -> {
                        //porta
                        //System.out.println("a, " + xx + " e " + yy);
                        if (xx == 0) {
                            directions.add(MapManager.Direction.WEST);
                        }
                        if (xx == 5) {
                            directions.add(MapManager.Direction.EAST);
                        }
                        if (yy == 0) {
                            directions.add(MapManager.Direction.NORTH);
                        }
                        if (yy == 5) {
                            directions.add(MapManager.Direction.SOUTH);

                        }
                    }

                }
                //System.out.println((xx*6 + yy)+ " " + directions);
            }
        }

        return new Pattern(walls, ( MapManager.Direction.toArray(directions)));

    }

}


