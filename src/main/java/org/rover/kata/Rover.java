package org.rover.kata;

import static org.rover.kata.Direction.*;

public final class Rover {
    private int x;
    private int y;
    private Direction direction;

    public Rover(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public String receiveCommand(String commands) {
        for (char command : commands.toCharArray()) {
            if (EAST == direction && 'F' == command) {
                x += 1;
            } else if (NORTH == direction && 'F' == command) {
                y += 1;
            } else if (EAST == direction && 'B' == command) {
                x -= 1;
            } else if (NORTH == direction && 'B' == command) {
                y -= 1;
            } else if (WEST == direction && 'F' == command) {
                x -= 1;
            } else if (WEST == direction && 'B' == command) {
                x += 1;
            } else if (SOUTH == direction && 'F' == command) {
                y -= 1;
            } else if (SOUTH == direction && 'B' == command) {
                y += 1;
            } else if ('L' == command) {
                direction = direction.left();
            } else if ('R' == command) {
                direction = direction.right();
            }
        }
        return String.format("(%d, %d) %s", x, y, direction);
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
}
