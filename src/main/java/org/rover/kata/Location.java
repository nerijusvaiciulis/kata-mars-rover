package org.rover.kata;

public record Location(Direction direction, Coordinates coordinates) {

    public Location forward() {
        return new Location(
                direction,
                coordinates.copyWithAddition(Direction.actionCoordinates.get(direction)));
    }

    public Location backward() {
        return new Location(
                direction,
                coordinates.copyWithAddition(Direction.reverseActionCoordinates.get(direction))
        );
    }

    public Location left() {
        return copyWith(direction.left());
    }

    public Location right() {
        return copyWith(direction.right());
    }

    String report() {
        return String.format("(%d, %d) %s", coordinates.x(), coordinates.y(), direction());
    }

    Location copy() {
        return new Location(direction, coordinates);
    }

    Location copyWith(Direction direction) {
        return new Location(direction, coordinates);
    }
}
