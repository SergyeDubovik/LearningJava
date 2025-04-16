package com.autoShow;

public class MainShow {

    public static void main(String[] args) {
        Car[] cars = new Car[]
                {
                        new Sedan("audi", "A8", new DieselEngine(300, 200), "black"),
                        new Hatchback("audi", "A7", new ElectricEngine(320, 5000), "red"),
                        new Truck("iveco", "qwer", new Engine(400), 6),
                        new Car("jeep", "prado", new Engine(200))
                };
        for (Car car : cars) {
            System.out.println(car);
        }
        Car car1 = new Car("mclaren", "SLR", new PetrolEngine(800, 200));
        Car car2 = new Car("mercedes", "cl60", new DieselEngine(600, 201));
        car2.setEngine(new Engine(400));
        car1.equals(car2);
        System.out.println(car1.equals(car2));
    }


}
