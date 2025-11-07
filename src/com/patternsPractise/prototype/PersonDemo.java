package com.patternsPractise.prototype;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person("Vincent", 27);
        Person clone = person.clone();
        clone.setName("Johnny");
        clone.setAge(34);
        System.out.println(clone);
        System.out.println(person);
    }
}
