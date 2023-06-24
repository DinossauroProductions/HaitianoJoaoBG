package com.dinossauroProductions.Game.Entities.Enemies;

import com.dinossauroProductions.Game.Entities.Weapon;
import com.dinossauroProductions.Utility.Utils;

public class TempleGuardian extends Enemy{

    public TempleGuardian(){
        super();
        this.life = 8;
        this.defesa = 4;
        this.weapon = Weapon.SWORD;

        if(Utils.randomCall(1, 2) == 1){
            this.attackModifier = 1;
        }
        else{
            this.defenseModifier = 1;
        }
    }

}
