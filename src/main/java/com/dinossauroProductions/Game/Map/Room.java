package com.dinossauroProductions.Game.Map;

import java.util.ArrayList;

public class Room {

    private Pattern roomPattern;
    private RoomType type;

    public Room(RoomType type, Pattern pattern){

        this.type = type;

        roomPattern = pattern;

    }

    @Override
    public String toString(){
        return roomPattern.toString();
    }


}
