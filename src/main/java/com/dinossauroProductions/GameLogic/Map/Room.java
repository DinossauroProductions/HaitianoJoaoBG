package com.dinossauroProductions.GameLogic.Map;

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
