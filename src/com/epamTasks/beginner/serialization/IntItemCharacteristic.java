package com.epamTasks.beginner.serialization;

import java.io.*;
import java.util.Objects;

public class IntItemCharacteristic extends ItemCharacteristic implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    protected int value;

    public IntItemCharacteristic(Long id, String name, String type, int value) {
        super(id, name, type);
        this.value = value;
    }

    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeLong(id != null ? id : -1L);
//        out.writeObject(id);
        out.writeObject(name);
        out.writeObject(type);
        out.writeInt(value);
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        long readId = in.readLong();
        this.id = (readId == -1L) ? null : readId;
//        this.id = (Long) in.readObject();
        this.name = (String) in.readObject();
        this.type = (String) in.readObject();
        this.value = in.readInt();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IntItemCharacteristic that = (IntItemCharacteristic) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

}
