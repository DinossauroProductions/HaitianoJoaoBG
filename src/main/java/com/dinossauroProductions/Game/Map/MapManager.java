package com.dinossauroProductions.Game.Map;

import com.dinossauroProductions.Utility.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class MapManager {

    record WallTile(short x, short y){}

    enum Direction {

        NORTH,
        SOUTH,
        WEST,
        EAST;

    }



    private Room[] linearPath;
    private int mapSize;

    private ArrayList<Pattern> patterns;

    public MapManager(int mapSize){

        BufferedImage mapReference, unillateralMapReference;

        //carrega a imagem de referência para que possa ser interpretada e carregar os diferentes mapas que são possíveis
        mapReference = Utils.getImageFromAsset("/maps.png");

        //carrega a imagem de referência para que possa ser interpretada e carregar os diferentes mapas que são possíveis
        unillateralMapReference = Utils.getImageFromAsset("/mapsUnilateral.png");


        patterns = new ArrayList<>(Pattern.loadPatterns(mapReference));
        patterns.addAll(Pattern.loadPatterns(unillateralMapReference));

        this.mapSize = mapSize;

        linearPath = new Room[mapSize+1];

        for(int i = 0; i < linearPath.length; i++){

            linearPath[i] = new Room(RoomType.getRoomType(Utils.d6()), getRandomPattern());
            System.out.println(linearPath[i]);
            System.out.println("-----------------------------------------------");
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
