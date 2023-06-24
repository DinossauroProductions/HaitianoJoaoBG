package com.dinossauroProductions.Game.Entities.Enemies;

import com.dinossauroProductions.Game.Entities.Weapon;

public class TrapsinkArcher extends Enemy{

    public TrapsinkArcher(){
        super();

        this.defesa = 3;
        this.life = 6;

        this.weapon = Weapon.BOW;

    }

    //TODO: implementar habilidade especial

}
