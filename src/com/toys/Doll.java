package com.toys;

import java.util.Objects;

public class Doll extends Toy {
    private String hairColor;

    public Doll(String name, String hairColor) {
        super(name);
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return "Doll {" +
                "hairColor = '" + hairColor + '\'' +
                ", name = '" + getName() + '\'' +
                '}';
    }
    public String getHairColor() {
        return hairColor;
    }
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doll doll = (Doll) o;
        return Objects.equals(hairColor, doll.hairColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hairColor);
    }
}
