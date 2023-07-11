package com.dinossauroProductions.GameLogic.Map;

import com.dinossauroProductions.Renderer.Sprite;
import com.dinossauroProductions.Utility.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MapManager {

    record WallTile(short x, short y){}

    enum Direction {

        NORTH,
        SOUTH,
        WEST,
        EAST;

        public static Direction[] toArray(HashSet<Direction> arg){
            Direction[] returns = new Direction[arg.size()];
            Iterator<Direction> iterator = arg.iterator();
            int i = 0;
            while(iterator.hasNext()){
                returns[i] = iterator.next();
                i++;
            }
            return returns;
        }

    }



    private Room[] linearPath;
    private int mapSize;

    public Sprite mapReference;

    private ArrayList<Pattern> patterns;

    public MapManager(int mapSize){

        Sprite unillateralMapReference;

        //carrega a imagem de referência para que possa ser interpretada e carregar os diferentes mapas que são possíveis
        mapReference = new Sprite("/maps.png");

        //carrega a imagem de referência para que possa ser interpretada e carregar os diferentes mapas que são possíveis
        unillateralMapReference = new Sprite("/mapsUnilateral.png");


        patterns = new ArrayList<>(Pattern.loadPatterns(mapReference.get()));
        patterns.addAll(Pattern.loadPatterns(unillateralMapReference.get()));

        this.mapSize = mapSize;

        linearPath = new Room[mapSize+1];

        for(int i = 0; i < linearPath.length; i++){

            linearPath[i] = new Room(RoomType.getRoomType(Utils.d6()), getRandomPattern());
            //System.out.println(linearPath[i]);
            //System.out.println("-----------------------------------------------");
        }

    }

    private void generateMap(int length){
        //gerar o mapa com limite de length lugares.

        if(length < 1)
            throw new IllegalArgumentException();

        int counter = 0;

        ArrayList<Pattern> patterns = new ArrayList<>();

        // Gerar os rooms principais
        do {
            Pattern currentPattern = getRandomPattern(length - counter);
            counter += currentPattern.directions().length - 1;
            patterns.add(currentPattern);
        } while (counter < length);

        //Gerar os rooms secundários
        while(true){
            //TODO: criar patterns unidirecionais e implementar o sistema de mapas até o final.
        }
    }

    private Pattern getRandomPattern(int maxConnections){
        if(maxConnections < 2){
            throw new IllegalArgumentException();
        }
        while(true){
            Pattern currentPattern = getRandomPattern();
            if(!(currentPattern.directions().length > maxConnections)){
                return currentPattern;
            }

        }
    }

    private Pattern getRandomPattern(){
        return patterns.get(Utils.randomCall(0, patterns.size()-1));
    }

}
