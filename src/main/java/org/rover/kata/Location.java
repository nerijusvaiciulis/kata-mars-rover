package org.rover.kata;

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

    public Location withX(int newX) {
        return new Location(newX, y, direction);
    }

    public Location withY(int newY) {
        return new Location(x, newY, direction);
    }

    public Location withDirection(Direction newDirection) {
        return new Location(x, y, newDirection);
    }
}
