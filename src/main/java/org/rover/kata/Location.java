package org.rover.kata;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class Location {
    private Direction direction;
    private int x;
    private int y;

    public Location(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Direction direction() {
        return direction;
    }

    public void forward() {
        switch (direction) {
            case EAST -> x += 1;
            case NORTH -> y += 1;
            case WEST -> x -= 1;
            case SOUTH -> y -= 1;
        }
    }

    public void backward() {
        switch (direction) {
            case EAST -> x -= 1;
            case NORTH -> y -= 1;
            case WEST -> x += 1;
            case SOUTH -> y += 1;
        }
    }

    public void left() {
        direction = direction.left();
    }

    public void right() {
        direction = direction.right();
    }

    String report() {
        return String.format("(%d, %d) %s", x(), y(), direction());
    }

    public Location copy() {
        return new Location(x, y, direction);
    }
}
