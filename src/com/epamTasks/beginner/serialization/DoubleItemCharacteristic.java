package com.epamTasks.beginner.serialization;

import java.io.*;
import java.util.Objects;

public class DoubleItemCharacteristic extends ItemCharacteristic implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    protected double value;

    public DoubleItemCharacteristic(Long id, String name, String type, double value) {
        super(id, name, type);
        this.value = value;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeObject(id);
        out.writeLong(id != null ? id : -1L);
        out.writeObject(name);
        out.writeObject(type);
        out.writeDouble(value);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        this.id = (Long) in.readObject();
        long readId = in.readLong();
        this.id = (readId == -1L) ? null : readId;
        this.name = (String) in.readObject();
        this.type = (String) in.readObject();
        this.value = in.readDouble();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoubleItemCharacteristic that = (DoubleItemCharacteristic) o;
        return Double.compare(value, that.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

}
