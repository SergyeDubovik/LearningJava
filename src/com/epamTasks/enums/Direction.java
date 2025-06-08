package com.epamTasks.enums;

/*
    ofDegrees - Return a Direction instance by input degrees or empty Optional if there is none.
    closestToDegrees - Return the closest Direction instance to input degrees.
    opposite - Return a Direction instance that is opposite to this.
    differenceDegreesTo - Return the difference in degrees between this and input Direction instance.
 */

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private int degrees;

    public static Direction ofDegrees(int degrees) {
        int range = ((degrees % 360) + 360) % 360;
        for (Direction direction : values()) {
            if (direction.degrees == range) {
                return direction;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int range = ((degrees % 360) + 360) % 360;
        Direction closest = null;
        int minDiff = Integer.MAX_VALUE;
        for (Direction direction : values()) {
            int diff = Math.abs(direction.degrees - range);
            if (diff > 180) {
                diff = 360 - diff;
            }
            if (diff < minDiff) {
                minDiff = diff;
                closest = direction;
            }
        }
        return closest;
    }

    public Direction opposite() {
        int oppositeDegrees = (this.degrees + 180) % 360;
        return closestToDegrees(oppositeDegrees);
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(this.degrees - direction.degrees);
        return Math.min(difference, 360 - difference);
    }
}
