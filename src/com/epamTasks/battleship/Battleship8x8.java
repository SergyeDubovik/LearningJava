package com.epamTasks.battleship;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int row = Character.getNumericValue(shot.charAt(1)) - 1;
        int column = shot.charAt(0) - 'A';
        int bitPosition = 63 - (row * 8 + column);
        long shotM = 1L << bitPosition;
        this.shots |= shotM;
        return (ships & shotM) != 0L;
    }

    public String state() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 8; row++) {
            for (int column = 0; column < 8; column++) {
                int bitPosition = 63 - (row * 8 + column);
                long m = 1L << bitPosition;
                boolean hasShip = (ships & m) != 0;
                boolean wasShot = (shots & m) != 0;
                char cell;
                if (hasShip && wasShot) {
                    cell = '☒';
                } else if (hasShip) {
                    cell = '☐';
                } else if (wasShot) {
                    cell = '×';
                } else {
                    cell = '.';
                }
                sb.append(cell);
            }
            if (row < 7) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
