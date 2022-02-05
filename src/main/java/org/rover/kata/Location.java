package org.rover.kata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@AllArgsConstructor
public final class Location {
    private final int x;
    private final int y;
    private final Direction direction;

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Direction direction() {
        return direction;
    }

    public Location forward() {
        return switch (direction) {
            case EAST -> new Location(x + 1, y, direction);
            case NORTH -> new Location(x, y + 1, direction);
            case WEST -> new Location(x - 1, y, direction);
            case SOUTH -> new Location(x, y - 1, direction);
        };
    }

    public Location backward() {
        return switch (direction) {
            case EAST -> new Location(x - 1, y, direction);
            case NORTH -> new Location(x, y - 1, direction);
            case WEST -> new Location(x + 1, y, direction);
            case SOUTH -> new Location(x, y + 1, direction);
        };
    }

    public Location left() {
        return new Location(x, y, direction.left());
    }

    public Location right() {
        return new Location(x, y, direction.right());
    }

    String report() {
        return String.format("(%d, %d) %s", x(), y(), direction());
    }
}
