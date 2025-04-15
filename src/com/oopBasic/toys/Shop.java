package com.oopBasic.toys;

public class Shop {
    public static void main(String[] args) {
        Toy[] toys = new Toy[]
                {
                        new Car("volkswagen", "bus"),
                        new Constructor("lego", "tower"),
                        new Doll("barbie", "blond"),
                        new ConstructionCar("mercedes", "mixerTruck", "blue", 25),
                        new Toy("ball")
                };
        for (int i = 0; i < toys.length; i++) {
            System.out.println(toys[i]);
        }
        Toy toy1 = new Toy("Ball");
        Toy toy2 = new Toy("Cube");
        toy1.equals(toy2);

        Doll doll1 = new Doll("barbie", "blond");
        doll1.equals(toy1);
        Doll doll2 = new Doll("barbie", "blond");
        doll1.equals(doll2);
    }

}
