package com.dinossauroProductions.Main;

import com.dinossauroProductions.Game.Map.MapManager;

public class Main {

    public static MapManager manager;

    private static Game game;

    public static void main(String[] args){

        game = new Game();
        game.start();

        manager = new MapManager(10);

    }
}
