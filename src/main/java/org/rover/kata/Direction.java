package org.rover.kata;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction left() {
        var index = (ordinal() + 3) % 4;
        return Direction.values()[index];
    }

    public Direction right(){
        var index = (ordinal() + 1) % 4;
        return Direction.values()[index];
    }
}
