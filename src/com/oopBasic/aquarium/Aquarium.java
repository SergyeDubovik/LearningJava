package com.oopBasic.aquarium;

public class Aquarium {
    public static void main(String[] args) {

        LifeThing[] myAquarium = new LifeThing[]
                {new Fish("carp", "grey"), new Shellfish("rak", 6),
                        new GoldFish("regularGoldFish", "orange", "white"),
                        new LifeThing("frog")};
        for (int i = 0; i < myAquarium.length; i++) {
            System.out.println(myAquarium[i]);
        }
    }

    /*
        1 создать подобную иерархию объектов для детских игрушек,
        2 и еще одну для машин
     */
}
