package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {
    private final int START_COORDINATE_X = 4;
    private final int START_COORDINATE_Y = 2;
    private final Direction START_DIRECTION = Direction.EAST;
    private final Location START_LOCATION = new Location(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION);
    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover(START_LOCATION);
    }

    @Test
    public void
    whenRoverIsInitializedThenCoordinatesAreSet() {
        assertThat(rover.x()).isEqualTo(START_COORDINATE_X);
        assertThat(rover.y()).isEqualTo(START_COORDINATE_Y);
    }

    @Test
    public void whenRoverIsInitializedThenDirectionIsSet() {
        assertThat(rover.direction()).isEqualTo(START_DIRECTION);
    }

    @Test
    public void whenRoverIsInitializedThenLocationIsSet() {
        var rover = new Rover(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION);

        assertThat(rover.location()).isEqualTo(START_LOCATION);
    }

    @Test
    public void whenReceiveCommandFThenForward() {
        Location expected = START_LOCATION.forward();

        rover.receiveCommand("F");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandBThenBackward() {
        Location expected = START_LOCATION.backward();

        rover.receiveCommand("B");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandLThenLeft() {
        Location expected = START_LOCATION.left();

        rover.receiveCommand("L");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandRThenRight() {
        Location expected = START_LOCATION.right();

        rover.receiveCommand("R");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveMultipleCommandsThenExecuteAll() {
        Location expected = START_LOCATION.forward().forward();

        rover.receiveCommand("FF");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenMoveInLeftCircleThenKeepSameCoordinatesAndDirection() {
        Location expected = START_LOCATION.forward().left().forward().left().forward().left().forward().left();

        rover.receiveCommand("FLFLFLFL");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenMoveInRightCircleThenKeepSameCoordinatesAndDirection() {
        Location expected = START_LOCATION.forward().right().forward().right().forward().right().forward().right();

        rover.receiveCommand("FRFRFRFR");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandThenReportLocation() {
        String expected = START_LOCATION.report();

        String report = rover.receiveCommand("");

        assertThat(report).isEqualTo(expected);
    }
}
