package com.dinossauroProductions.Game.Map;

public enum RoomType {

    NORMAL(),
    LIT(),
    SURROUNDED_BY_TORCHES(),
    WITH_A_HOLE(),
    DARK(),
    BLOCKED_BY_BOULDERS();


    public static RoomType getRoomType(int call){

        switch(call){

            case 1:{
                return RoomType.NORMAL;
            }
            case 2:{
                return RoomType.LIT;
            }
            case 3:{
                return RoomType.SURROUNDED_BY_TORCHES;
            }
            case 4:{
                return RoomType.WITH_A_HOLE;
            }
            case 5:{
                return RoomType.DARK;
            }
            case 6:{
                return RoomType.BLOCKED_BY_BOULDERS;
            }
            default:
                return RoomType.NORMAL;
        }

    }

}
