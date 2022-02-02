package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rover.kata.Location;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rover.kata.Direction.*;
import static org.rover.kata.Direction.SOUTH;

public class LocationTest {

    private final int x = 1;
    private final int y = 2;
    private final Direction direction = Direction.EAST;
    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location(x, y, direction);
    }

    @Test
    public void whenInitializedThenXIsSet() {
        assertThat(location.x()).isEqualTo(x);
    }

    @Test
    public void whenInitializedThenYIsSet() {
        assertThat(location.y()).isEqualTo(y);
    }

    @Test
    public void whenInitializedThenDirectionIsSet() {
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenEastWhenForwardThenXIncrease() {
        location = new Location(x, y, EAST);

        location.forward();

        assertThat(location.x()).isEqualTo(x + 1);
    }

    @Test
    public void givenEastWhenBackwardThenXDecrease() {
        location = new Location(x, y, EAST);

        location.backward();

        assertThat(location.x()).isEqualTo(x - 1);
    }

    @Test
    public void givenNorthWhenForwardThenYIncrease() {
        location = new Location(x, y, NORTH);

        location.forward();

        assertThat(location.y()).isEqualTo(y + 1);
    }

    @Test
    public void givenNorthWhenBackwardThenYDecrease() {
        location = new Location(x, y, NORTH);

        location.backward();

        assertThat(location.y()).isEqualTo(y - 1);
    }

    @Test
    public void givenWestWhenForwardThenXDecrease() {
        location = new Location(x, y, WEST);

        location.forward();

        assertThat(location.x()).isEqualTo(x - 1);
    }

    @Test
    public void givenWestWhenBackwardThenXIncrease() {
        location = new Location(x, y, WEST);

        location.backward();

        assertThat(location.x()).isEqualTo(x + 1);
    }

    @Test
    public void givenSouthWhenForwardThenYDecrease() {
        location = new Location(x, y, SOUTH);

        location.forward();

        assertThat(location.y()).isEqualTo(y - 1);
    }

    @Test
    public void givenSouthWhenBackwardThenYIncrease() {
        location = new Location(x, y, SOUTH);

        location.backward();

        assertThat(location.y()).isEqualTo(y + 1);
    }
}
