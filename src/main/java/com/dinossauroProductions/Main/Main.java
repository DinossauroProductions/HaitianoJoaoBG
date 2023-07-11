package com.dinossauroProductions.Main;

import com.dinossauroProductions.GameLogic.Map.MapManager;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main {

    public static MapManager manager;

    public static Game game;

    public static ArrayList<BufferedImage> spritesTest = new ArrayList<>();

    public static void main(String[] args){





        manager = new MapManager(10);

        game = new Game();
        game.start();

    }
}
