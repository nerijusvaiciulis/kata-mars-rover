package org.rover.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rover.kata.Direction.*;

class DirectionTest {
    @Test
    public void whenEastLeftThenNorth() {
        assertThat(EAST.left()).isEqualTo(NORTH);
    }

    @Test
    public void whenNorthLeftThenWest() {
        assertThat(NORTH.left()).isEqualTo(WEST);
    }

    @Test
    public void whenWestLeftThenSouth() {
        assertThat(WEST.left()).isEqualTo(SOUTH);
    }

    @Test
    public void whenSouthLeftThenEast() {
        assertThat(SOUTH.left()).isEqualTo(EAST);
    }

    @Test
    public void whenNorthRightThenEast() {
        assertThat(NORTH.right()).isEqualTo(EAST);
    }

    @Test
    public void whenWestRightThenNorth() {
        assertThat(WEST.right()).isEqualTo(NORTH);
    }

    @Test
    public void whenSouthRightThenWest() {
        assertThat(SOUTH.right()).isEqualTo(WEST);
    }

    @Test
    public void whenEastRightThenSouth() {
        assertThat(EAST.right()).isEqualTo(SOUTH);
    }
}