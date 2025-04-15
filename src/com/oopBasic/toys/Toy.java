package com.oopBasic.toys;

import java.util.Objects;

public class Toy {
    private String name;

    public Toy(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name = '" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
