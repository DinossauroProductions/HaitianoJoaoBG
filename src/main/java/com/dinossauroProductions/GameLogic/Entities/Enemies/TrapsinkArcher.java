package com.dinossauroProductions.GameLogic.Entities.Enemies;

import com.dinossauroProductions.GameLogic.Entities.Weapon;

public class TrapsinkArcher extends Enemy{

    public TrapsinkArcher(){
        super();

        this.defesa = 3;
        this.life = 6;

        this.weapon = Weapon.BOW;

    }

    //TODO: implementar habilidade especial

}
