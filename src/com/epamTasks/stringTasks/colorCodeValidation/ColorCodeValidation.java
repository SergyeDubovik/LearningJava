package com.epamTasks.stringTasks.colorCodeValidation;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color == null) {
            return false;
        }
        return color.toUpperCase().matches("^#[0-9A-F]{3}([0-9A-F]{3})?$");
    }
}
