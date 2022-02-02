package org.rover.kata;

public final class Rover {
    private final Location location;

    public Rover(int x, int y, Direction direction) {
        this.location = new Location(x, y, direction);
    }

    public Rover(Location location) {
        this.location = location;
    }

    public String receiveCommand(String commands) {
        for (char command : commands.toCharArray()) {
            execute(command);
        }
        return location.report();
    }

    private void execute(char command) {
        if ('F' == command) {
            location.forward();
        } else if ('B' == command) {
            location.backward();
        } else if ('L' == command) {
            location.left();
        } else if ('R' == command) {
            location.right();
        }
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
}
