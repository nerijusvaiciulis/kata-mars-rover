package org.rover.kata;

public record Rover(Location location) {

    public Rover receiveCommands(String commands) {
        var movedRover = this;
        for (char command : commands.toCharArray()) {
            movedRover = movedRover.execute(command);
        }
        return movedRover;
    }

    private Rover execute(char command) {
        return switch (command) {
            case 'F' -> withLocation(location.forward());
            case 'B' -> withLocation(location.backward());
            case 'L' -> withLocation(location.left());
            case 'R' -> withLocation(location.right());
            default -> this;
        };
    }

    public int x() {
        return location.x();
    }

    public int y() {
        return location.y();
    }

    public Direction direction() {
        return location.direction();
    }

    public Location location() {
        return location;
    }

    public Rover withLocation(Location location) {
        return new Rover(location);
    }

    public String report() {
        return location.report();
    }
}
