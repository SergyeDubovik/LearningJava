package com.oopBasic.toys;

public class Constructor extends Toy {
    private String variety;
    public Constructor(String name, String variety) {
        super(name);
        this.variety = variety;
    }

    @Override
    public String toString() {
        return "Constructor {" +
                "variety = '" + variety + '\'' +
                ", name = '" + getName() + '\'' +
                '}';
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
