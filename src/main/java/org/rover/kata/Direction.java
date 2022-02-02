package org.rover.kata;

public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    int value;

    Direction(int i) {
        this.value = i;
    }

    public Direction left() {
        int index = (value + 3) % 4;
        return Direction.values()[index];
    }

    public Direction right(){
        int index = (value + 1) % 4;
        return Direction.values()[index];
    }
}
