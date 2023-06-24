package com.dinossauroProductions.Game.Entities.PlayableChars;

import com.dinossauroProductions.Game.Entities.Item;

public class Sallah extends PlayableChar{

    public Sallah(){
        super();

        this.items.add(Item.SHOVEL);

        this.defenseModifier = 1;

    }

    //TODO: habilidade de +1 de força em teste de habilidade e empurra objetos?
}
