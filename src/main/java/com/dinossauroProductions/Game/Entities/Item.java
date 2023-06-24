package com.dinossauroProductions.Game.Entities;

public enum Item {

    //Acessories

    SUN_MEDALLION("SunMedallion"),
    MYSTICAL_ARTIFACT("Mystical Artifact"),
    INVIGORATING_FRUIT("Invigorating Fruit"),
    ENERGETIC_ELIXIR("Energetic Elixir"),

    //Tools

    SHOVEL("Shovel"),
    DETAILED_MAP("Detailed Map"),
    ANCIENT_KEY("Ancient Key"),
    FIRST_AID_KIT("First Aid Kit"),
    LIT_TORCH("Lit Torch"),
    EXCAVATION_AXE("Excavation Axe")

    ;
    final String name;

    Item(String name) {
        this.name = name;
    }
}
