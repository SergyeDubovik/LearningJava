package com.autoShow;

import java.util.Objects;

public class Car {
    public String brand;
    public String model;
    private Engine engine;
    public Car(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(engine.getHorsePower(), car.engine.getHorsePower());
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine.getHorsePower());
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}

/*
    1 добавить иерархию двигателей (дизель, электро, внутр. сгорания)
    2 в описании двигателя должны фигурировать лошадиные силы
    3 все машины должны содержать двигатели
    4 написать equals and hashCode для машин так, чтоб он сравнивал их по лошадиным силам их двигателя

    пример: седан с эл.двиг на 200 л/сил должен быть равен хетчбэку на дизельном двигателе с 200 л/сил, но при этом
    грузовик с двс на 400 л/сил не должен быть равен грузовику с тем же двс, но на 401
 */