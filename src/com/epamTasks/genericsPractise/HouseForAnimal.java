package com.epamTasks.genericsPractise;

import java.util.ArrayList;
import java.util.List;

public class HouseForAnimal<T> {
    private final List<T> residents = new ArrayList<>();
    public void enter(T resident) {
        residents.add(resident);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T resident : residents) {
            sb.append(resident.toString()).append("\n");
        }
        return sb.toString();
    }
}
