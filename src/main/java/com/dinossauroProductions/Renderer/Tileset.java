package com.dinossauroProductions.Renderer;

import com.dinossauroProductions.Utility.Utils;

import java.awt.image.BufferedImage;

public class Tileset {

    private BufferedImage resource;

    public Tileset(String resourcePath){
        this.resource = Utils.getImageFromAsset(resourcePath);
    }

}
