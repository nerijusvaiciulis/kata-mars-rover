package org.rover.kata;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.With;

@EqualsAndHashCode
@AllArgsConstructor
@With
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
            case EAST -> withX(x + 1);
            case NORTH -> withY(y + 1);
            case WEST -> withX(x - 1);
            case SOUTH -> withY(y - 1);
        };
    }

    public Location backward() {
        return switch (direction) {
            case EAST -> withX(x - 1);
            case NORTH -> withY(y - 1);
            case WEST -> withX(x + 1);
            case SOUTH -> withY(y + 1);
        };
    }

    public Location left() {
        return withDirection(direction.left());
    }

    public Location right() {
        return withDirection(direction.right());
    }

    String report() {
        return String.format("(%d, %d) %s", x(), y(), direction());
    }
}
