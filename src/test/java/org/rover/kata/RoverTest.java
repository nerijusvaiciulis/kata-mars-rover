package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {
    private final Direction direction = Direction.EAST;
    private final int x = 4;
    private final int y = 2;
    private Location location;
    private Location expectedLocation;
    private Rover rover;

    @BeforeEach
    void setUp() {
        location = new Location(x, y, direction);
        expectedLocation = new Location(x, y, direction);

        rover = new Rover(location);
    }

    @Test
    public void
    whenRoverIsInitializedThenCoordinatesAreSet() {
        assertThat(rover.x()).isEqualTo(x);
        assertThat(rover.y()).isEqualTo(y);
    }

    @Test
    public void whenRoverIsInitializedThenDirectionIsSet() {
        assertThat(rover.direction()).isEqualTo(direction);
    }

    @Test
    public void whenRoverIsInitializedThenLocationIsSet() {
        var rover = new Rover(x, y, direction);

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    @Test
    public void whenReceiveCommandFThenForward() {
        expectedLocation.forward();

        rover.receiveCommand("F");

        assertThat(location).isEqualTo(expectedLocation);
    }

    @Test
    public void whenReceiveCommandBThenBackward() {
        expectedLocation.backward();

        rover.receiveCommand("B");

        assertThat(location).isEqualTo(expectedLocation);
    }

    @Test
    public void whenReceiveCommandLThenLeft() {
        expectedLocation.left();

        rover.receiveCommand("L");

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    @Test
    public void whenReceiveCommandRThenRight() {
        expectedLocation.right();

        rover.receiveCommand("R");

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    @Test
    public void whenReceiveMultipleCommandsThenExecuteAll() {
        expectedLocation.forward();
        expectedLocation.forward();

        rover.receiveCommand("FF");

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    @Test
    public void whenMoveInLeftCircleThenKeepSameCoordinatesAndDirection() {
        expectedLocation.forward();
        expectedLocation.left();
        expectedLocation.forward();
        expectedLocation.left();
        expectedLocation.forward();
        expectedLocation.left();
        expectedLocation.forward();
        expectedLocation.left();

        rover.receiveCommand("FLFLFLFL");

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    @Test
    public void whenMoveInRightCircleThenKeepSameCoordinatesAndDirection() {
        expectedLocation.forward();
        expectedLocation.right();
        expectedLocation.forward();
        expectedLocation.right();
        expectedLocation.forward();
        expectedLocation.right();
        expectedLocation.forward();
        expectedLocation.right();
        rover.receiveCommand("FRFRFRFR");

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    @Test
    public void whenReceiveCommandThenReportLocation() {
        String expected = location.report();

        String report = rover.receiveCommand("");

        assertThat(report).isEqualTo(expected);
    }
}
