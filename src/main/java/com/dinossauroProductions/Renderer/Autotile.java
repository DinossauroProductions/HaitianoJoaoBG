package com.dinossauroProductions.Renderer;

import com.dinossauroProductions.Utility.Utils;

import java.awt.image.BufferedImage;

public class Autotile {

    /*private static final int
            TOP_LEFT = 0,
            TOP_MIDDLE = 1,
            TOP_RIGHT = 2,
            MIDDLE_RIGHT = 3,
            BOTTOM_RIGHT = 4,
            BOTTOM_MIDDLE = 5,
            BOTTOM_LEFT = 6,
            MIDDLE_LEFT = 7;

     */

    //private int

    private record TileNeighbors(boolean[] neighbors){

    }

    public Autotile(String resourcePath){
        BufferedImage resource = new Sprite(resourcePath).get();
    }

    private void processTileSet(BufferedImage image){
        BufferedImage[] tiles = new BufferedImage[48];

    }


}
