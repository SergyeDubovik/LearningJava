package com.epamTasks.genericsPractise;

public class HouseDemo {
    public static void main(String[] args) {
        HouseForAnimal<Cat> catHouseForAnimal = new HouseForAnimal<>();
        HouseForAnimal<Dog> dogHouseForAnimal = new HouseForAnimal<>();

        Cat masha = new Cat("Masha");
        Cat barsik = new Cat("Barsik");
        catHouseForAnimal.enter(masha);
        catHouseForAnimal.enter(barsik);
        System.out.println(catHouseForAnimal);

        Dog butch = new Dog("Butch");
        dogHouseForAnimal.enter(butch);
        System.out.println(dogHouseForAnimal);
    }
}
