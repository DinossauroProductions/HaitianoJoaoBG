package com.dinossauroProductions.GameLogic.Entities.Enemies;

import com.dinossauroProductions.GameLogic.Entities.Weapon;
import com.dinossauroProductions.Utility.Utils;

public class NaziGuard extends Enemy{

    public NaziGuard(){
        super();

        this.defesa = 3;
        this.life = 6;

        int call = Utils.randomCall(1, 3);

        if(call == 1){
            this.weapon = Weapon.REVOLVER;
        }
        else if(call == 2){
            this.weapon = Weapon.RIFLE;
        }
        else{
            this.weapon = Weapon.MACHINEGUN;
        }

    }

}
