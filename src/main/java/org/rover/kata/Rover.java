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


    public void receiveCommand(String command) {
        if (EAST == direction && "F".equals(command)) {
            x += 1;
        } else if (NORTH == direction && "F".equals(command)) {
            y += 1;
        } else if (EAST == direction && "B".equals(command)) {
            x -= 1;
        } else if (NORTH == direction && "B".equals(command)) {
            y -= 1;
        } else if (WEST == direction && "F".equals(command)) {
            x -= 1;
        } else if (WEST == direction && "B".equals(command)) {
            x += 1;
        } else if (SOUTH == direction && "F".equals(command)) {
            y -= 1;
        } else if (SOUTH == direction && "B".equals(command)) {
            y += 1;
        } else if (EAST == direction && "L".equals(command)) {
            direction = NORTH;
        } else if (NORTH == direction && "L".equals(command)) {
            direction = WEST;
        } else if (WEST == direction && "L".equals(command)) {
            direction = SOUTH;
        } else if (SOUTH == direction && "L".equals(command)) {
            direction = EAST;
        } else if (SOUTH == direction && "R".equals(command)) {
            direction = WEST;
        } else if (WEST == direction && "R".equals(command)) {
            direction = NORTH;
        } else if (NORTH == direction && "R".equals(command)) {
            direction = EAST;
        } else if (EAST == direction && "R".equals(command)) {
            direction = SOUTH;
        }
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
