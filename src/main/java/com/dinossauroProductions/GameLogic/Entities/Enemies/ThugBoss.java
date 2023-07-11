package com.dinossauroProductions.GameLogic.Entities.Enemies;

import com.dinossauroProductions.GameLogic.Entities.Weapon;

public class ThugBoss extends Enemy{

    public ThugBoss(){
        super();

        this.defesa = 4;
        this.life = 8;

        this.weapon = Weapon.SWORD;

    }

}
