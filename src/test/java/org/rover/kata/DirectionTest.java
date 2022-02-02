package org.rover.kata;

import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    public void whenDirectionNorthThenNorth() {
        Direction north = Direction.NORTH;
    }

    @Test
    public void whenDirectionSouthThenSouth() {
        Direction south = Direction.SOUTH;
    }

    @Test
    public void whenDirectionWestThenWest() {
        Direction west = Direction.WEST;
    }
}