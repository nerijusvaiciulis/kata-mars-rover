package org.rover.kata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public final class Location {
    private int x;
    private int y;
    private Direction direction;

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
