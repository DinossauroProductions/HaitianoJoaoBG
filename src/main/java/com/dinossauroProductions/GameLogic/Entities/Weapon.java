package com.dinossauroProductions.GameLogic.Entities;

public enum Weapon {

    //TODO: implementar munição, inimigos não tem, e jogadores sim

    WHIP(1, 2),
    //shortRange
    SWORD(2, 0),
    //no range
    BOW(3, 3),
    //mediumRange
    REVOLVER(4, 2),
    //shortRange
    RIFLE(5, 4),
    //longRange
    MACHINEGUN(3, 3)
    //mediumRange
    ;

    /*
    * shortRange = 2
    * mediumRange = 3
    * longRange = 4
    */

    final int value, range;

    Weapon(int damage, int range) {
        this.value = damage;
        this.range = range;
    }

    public boolean isRanged (){
        return range >= 2;
    }

}
