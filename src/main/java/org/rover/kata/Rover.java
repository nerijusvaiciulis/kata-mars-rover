package org.rover.kata;

import static org.rover.kata.Direction.*;

public final class Rover {
    private int x;
    private int y;
    private final Direction direction;

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
            x-= 1;
        } else if (WEST == direction && "B".equals(command)) {
            x+= 1;
        } else if (SOUTH == direction && "F".equals(command)) {
            y-= 1;
        } else if (SOUTH == direction && "B".equals(command)) {
            y+= 1;
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
