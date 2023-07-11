package com.dinossauroProductions.GameLogic.Entities.PlayableChars;

import com.dinossauroProductions.GameLogic.Entities.Entity;
import com.dinossauroProductions.GameLogic.Entities.Item;
import com.dinossauroProductions.Utility.Utils;

import java.util.ArrayList;

public class PlayableChar extends Entity {

    // o ataque corpo a corpo sem arma do player causa 1d6 de dano.

    protected int energy, ammo;

    protected ArrayList<Item> items;

    //TODO: sistema de combate
    //TODO: modificadores de defesa

    public PlayableChar(){
        items = new ArrayList<>();

        life = 6;
        energy = 10;
        ammo = 0;
    }

    public void activateTrap(){

        if(Utils.d6() < 4){
            this.receiveDamage(1);
        }
        //TODO: implementar sistema de armadilha para todos os players

    }

    public void beHealed(int healAmount){

        this.life += healAmount;
        //TODO: remover efeitos negativos (stun, veneno, etc)

    }


    public ArrayList<Item> getItems(){
        return items;
    }

}
