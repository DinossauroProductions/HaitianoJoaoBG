package com.dinossauroProductions.Game.Entities.PlayableChars;

import com.dinossauroProductions.Game.Entities.Weapon;
import com.dinossauroProductions.Utility.Utils;

public class IndianaJones extends PlayableChar {

    public IndianaJones(){
        super();
        this.weapon = Weapon.WHIP;
    }

    @Override
    public void activateTrap(){

        if(Utils.d6() < 3){
            this.receiveDamage(1);
        }
        //TODO: implementar sistema de armadilha para todos os players

    }
    //TODO: implementar habilidade de corpo a corpo +1
}
