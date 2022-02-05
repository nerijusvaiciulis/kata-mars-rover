package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rover.kata.Direction.*;

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
        Direction direction = EAST;
        location = new Location(x, y, direction);

        location.forward();

        assertThat(location.x()).isEqualTo(x + 1);
        assertThat(location.y()).isEqualTo(y);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenEastWhenBackwardThenXDecrease() {
        Direction direction = EAST;
        location = new Location(x, y, direction);

        location.backward();

        assertThat(location.x()).isEqualTo(x - 1);
        assertThat(location.y()).isEqualTo(y);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenNorthWhenForwardThenYIncrease() {
        Direction direction = NORTH;
        location = new Location(x, y, direction);

        location.forward();

        assertThat(location.y()).isEqualTo(y + 1);
        assertThat(location.x()).isEqualTo(x);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenNorthWhenBackwardThenYDecrease() {
        Direction direction = NORTH;
        location = new Location(x, y, direction);

        location.backward();

        assertThat(location.y()).isEqualTo(y - 1);
        assertThat(location.x()).isEqualTo(x);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenWestWhenForwardThenXDecrease() {
        Direction direction = WEST;
        location = new Location(x, y, direction);

        location.forward();

        assertThat(location.x()).isEqualTo(x - 1);
        assertThat(location.y()).isEqualTo(y);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenWestWhenBackwardThenXIncrease() {
        Direction direction = WEST;
        location = new Location(x, y, direction);

        location.backward();

        assertThat(location.x()).isEqualTo(x + 1);
        assertThat(location.y()).isEqualTo(y);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenSouthWhenForwardThenYDecrease() {
        Direction direction = SOUTH;
        location = new Location(x, y, direction);

        location.forward();

        assertThat(location.y()).isEqualTo(y - 1);
        assertThat(location.x()).isEqualTo(x);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void givenSouthWhenBackwardThenYIncrease() {
        Direction direction = SOUTH;
        location = new Location(x, y, direction);

        location.backward();

        assertThat(location.y()).isEqualTo(y + 1);
        assertThat(location.x()).isEqualTo(x);
        assertThat(location.direction()).isEqualTo(direction);
    }

    @Test
    public void whenReportThenReturnFormattedText() {
        assertThat(location.report()).isEqualTo("(1, 2) EAST");
    }
}
