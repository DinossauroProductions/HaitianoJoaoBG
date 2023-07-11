package com.dinossauroProductions.GameLogic.Entities.Enemies;

import com.dinossauroProductions.GameLogic.Entities.Weapon;

public class Skeleton extends Enemy{

    public Skeleton(){
        super();

        this.defesa = 2;
        this.life = 4;

        this.weapon = Weapon.SWORD;

    }

}
