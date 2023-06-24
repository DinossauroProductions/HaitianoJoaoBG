package com.dinossauroProductions.Game.Map;

import com.dinossauroProductions.Utility.Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class MapManager {

    private Room[] linearPath;
    private int mapSize;

    private ArrayList<Pattern> patterns;

    private static BufferedImage mapReference;

    public MapManager(int mapSize){

        if(mapReference == null){
            //carrega a imagem de referência para que possa ser interpretada e carregar os diferentes mapas que são possíveis
            mapReference = getImageAsset("/maps.png");
        }

        patterns = new ArrayList<>();
        patterns.add(Pattern.getStartingPattern());
        patterns = Pattern.loadPatterns(mapReference);

        this.mapSize = mapSize;

        linearPath = new Room[mapSize+1];

        for(int i = 0; i < linearPath.length; i++){

            linearPath[i] = new Room(RoomType.getRoomType(Utils.d6()), getRandomPattern());
            System.out.println(linearPath[i]);
            System.out.println("-----------------------------------------------");
        }

    }

    private Pattern getRandomPattern(){
        return patterns.get(Utils.randomCall(0, patterns.size()-1));
    }

    public BufferedImage getImageAsset(String path) {

        try {

            return ImageIO.read(getClass().getResource(path));

        } catch (IOException e) {

            System.out.println("Imagem de path "+path+" não foi encontrada.");
            e.printStackTrace();
            return null;
        }

    }



}
