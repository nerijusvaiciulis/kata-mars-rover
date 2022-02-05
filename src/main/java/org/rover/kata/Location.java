package org.rover.kata;

import lombok.With;
// In IntelliJ methods withX withY withDirection as error. They but they work as expected.
// Intellij lombok plugin need update to notice, that @With works with record also
@With
public record Location(int x, int y, Direction direction) {

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
