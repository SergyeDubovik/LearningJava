package com.epamTasks.beginner.serialization;

import java.io.*;

public class OrderSerializer {
    public static void main(String[] args) {

    }
    /**
     * Serializes Order to a given OutputStream
     */
    public static void serializeOrder(Order order, OutputStream sink) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(sink);
        oos.writeObject(order);
        oos.flush();
    }


    /**
     * Deserializes Order from a given InputStream
     */
    public static Order deserializeOrder(InputStream sink) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(sink);
        return (Order) ois.readObject();
    }
}
