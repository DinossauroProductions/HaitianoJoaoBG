package com.dinossauroProductions.Game.Entities;

public class Entity {

    protected Weapon weapon;
    protected int attackModifier, defenseModifier;
    protected int life;
    public Entity(){

        attackModifier = 0;
        defenseModifier = 0;
    }

    public void receiveDamage(int damage){

        this.life -= damage;

    }

}
