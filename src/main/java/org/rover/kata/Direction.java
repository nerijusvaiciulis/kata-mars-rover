package org.rover.kata;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction left() {
        int index = (ordinal() + 3) % 4;
        return Direction.values()[index];
    }

    public Direction right(){
        int index = (ordinal() + 1) % 4;
        return Direction.values()[index];
    }
}
