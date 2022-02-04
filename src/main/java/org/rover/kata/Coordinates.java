package org.rover.kata;

public record Coordinates(int x, int y) {

    public Coordinates copyWithAddition(Coordinates coordinates) {
        return new Coordinates(x + coordinates.x(), y + coordinates.y());
    }

    public Coordinates copyWithAddition(int addToX, int addToY) {
        return new Coordinates(x + addToX, y + addToY);
    }

    public Coordinates copyWithMultiplication(int multiplyX, int multiplyY) {
        return new Coordinates(x * multiplyX, y * multiplyY);
    }
}
