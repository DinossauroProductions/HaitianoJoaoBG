package com.dinossauroProductions.Game.Entities.PlayableChars;

import com.dinossauroProductions.Game.Entities.Item;
import com.dinossauroProductions.Utility.Utils;

public class MarcusBrody extends PlayableChar{

    public MarcusBrody(){
        super();

        items.add(Item.DETAILED_MAP);

    }

    @Override
    public void activateTrap(){

        if(Utils.d6() < 3){
            this.receiveDamage(1);
        }
        //TODO: implementar sistema de armadilha para todos os players

    }

    //TODO: implementar sistema de resolver enigmas com +1 de teste

}
