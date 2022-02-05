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

        Location actualLocation = location.forward();

        assertThat(actualLocation.x()).isEqualTo(x + 1);
        assertThat(actualLocation.y()).isEqualTo(y);
        assertThat(actualLocation.direction()).isEqualTo(direction);
    }

    @Test
    public void givenEastWhenBackwardThenXDecrease() {
        Direction direction = EAST;
        location = new Location(x, y, direction);

        Location backward = location.backward();

        assertThat(backward.x()).isEqualTo(x - 1);
        assertThat(backward.y()).isEqualTo(y);
        assertThat(backward.direction()).isEqualTo(direction);
    }

    @Test
    public void givenNorthWhenForwardThenYIncrease() {
        Direction direction = NORTH;
        location = new Location(x, y, direction);

        Location actualLocation = location.forward();

        assertThat(actualLocation.y()).isEqualTo(y + 1);
        assertThat(actualLocation.x()).isEqualTo(x);
        assertThat(actualLocation.direction()).isEqualTo(direction);
    }

    @Test
    public void givenNorthWhenBackwardThenYDecrease() {
        Direction direction = NORTH;
        location = new Location(x, y, direction);

        Location backward = location.backward();

        assertThat(backward.y()).isEqualTo(y - 1);
        assertThat(backward.x()).isEqualTo(x);
        assertThat(backward.direction()).isEqualTo(direction);
    }

    @Test
    public void givenWestWhenForwardThenXDecrease() {
        Direction direction = WEST;
        location = new Location(x, y, direction);

        Location actualLocation = location.forward();

        assertThat(actualLocation.x()).isEqualTo(x - 1);
        assertThat(actualLocation.y()).isEqualTo(y);
        assertThat(actualLocation.direction()).isEqualTo(direction);
    }

    @Test
    public void givenWestWhenBackwardThenXIncrease() {
        Direction direction = WEST;
        location = new Location(x, y, direction);

        Location backward = location.backward();

        assertThat(backward.x()).isEqualTo(x + 1);
        assertThat(backward.y()).isEqualTo(y);
        assertThat(backward.direction()).isEqualTo(direction);
    }

    @Test
    public void givenSouthWhenForwardThenYDecrease() {
        Direction direction = SOUTH;
        location = new Location(x, y, direction);

        Location actualLocation = location.forward();

        assertThat(actualLocation.y()).isEqualTo(y - 1);
        assertThat(actualLocation.x()).isEqualTo(x);
        assertThat(actualLocation.direction()).isEqualTo(direction);
    }

    @Test
    public void givenSouthWhenBackwardThenYIncrease() {
        Direction direction = SOUTH;
        location = new Location(x, y, direction);

        Location backward = location.backward();

        assertThat(backward.y()).isEqualTo(y + 1);
        assertThat(backward.x()).isEqualTo(x);
        assertThat(backward.direction()).isEqualTo(direction);
    }

    @Test
    public void whenReportThenReturnFormattedText() {
        assertThat(location.report()).isEqualTo("(1, 2) EAST");
    }

    @Test
    public void whenForwardThenOriginalLocationNotChanged() {
        Location expected = new Location(location.x(), location.y(), location.direction());

        location.forward();

        assertThat(location).isEqualTo(expected);
    }

    @Test
    public void whenBackwardThenOriginalLocationNotChanged() {
        Location expected = new Location(location.x(), location.y(), location.direction());

        location.backward();

        assertThat(location).isEqualTo(expected);
    }

    @Test
    public void whenLeftThenOriginalLocationNotChanged() {
        Location expected = new Location(location.x(), location.y(), location.direction());

        location.left();

        assertThat(location).isEqualTo(expected);
    }

    @Test
    public void whenLeftThenDirectionLeft() {
        Location left = location.left();

        assertThat(left.direction()).isEqualTo(direction.left());
    }

    @Test
    public void whenRightThenOriginalLocationNotChanged() {
        Location expected = new Location(location.x(), location.y(), location.direction());

        location.right();

        assertThat(location).isEqualTo(expected);
    }

    @Test
    public void whenRightThenDirectionRight() {
        Location right = location.right();

        assertThat(right.direction()).isEqualTo(direction.right());
    }
}
