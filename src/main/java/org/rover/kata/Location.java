package org.rover.kata;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import static org.rover.kata.Direction.*;

@ToString
@EqualsAndHashCode
public final class Location {
    private Direction direction;
    private int x;
    private int y;

    public Location(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

    public void forward() {
        if (EAST == direction) {
            x += 1;
        } else if (NORTH == direction) {
            y += 1;
        } else if (WEST == direction) {
            x -= 1;
        } else if (SOUTH == direction) {
            y -= 1;
        }
    }

    public void backward() {
        if (EAST == direction) {
            x -= 1;
        } else if (NORTH == direction) {
            y -= 1;
        } else if (WEST == direction) {
            x += 1;
        } else if (SOUTH == direction) {
            y += 1;
        }
    }

    public void left() {
        direction = direction.left();
    }

    public void right() {
        direction = direction.right();
    }

    String report() {
        return String.format("(%d, %d) %s", x(), y(), direction());
    }

    public Location copy() {
        return new Location(x, y, direction);
    }
}
