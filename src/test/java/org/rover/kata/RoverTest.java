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
        verify("F", START_LOCATION.forward());
    }

    @Test
    public void whenReceiveCommandBThenBackward() {
        verify("B", START_LOCATION.backward());
    }

    @Test
    public void whenReceiveCommandLThenLeft() {
        verify("L", START_LOCATION.left());
    }

    @Test
    public void whenReceiveCommandRThenRight() {
        verify("R", START_LOCATION.right());
    }

    @Test
    public void whenReceiveMultipleCommandsThenExecuteAll() {
        verify("FF", START_LOCATION.forward().forward());
    }

    @Test
    public void whenMoveInLeftCircleThenKeepSameCoordinatesAndDirection() {
        verify("FLFLFLFL", START_LOCATION.forward().left().forward().left().forward().left().forward().left());
    }

    @Test
    public void whenMoveInRightCircleThenKeepSameCoordinatesAndDirection() {
        verify("FRFRFRFR", START_LOCATION.forward().right().forward().right().forward().right().forward().right());
    }

    @Test
    public void whenReceiveCommandThenReportLocation() {
        var report = rover.receiveCommand("");

        assertThat(report).isEqualTo(START_LOCATION.report());
    }

    private void verify(String commands, Location expectedLocation) {
        rover.receiveCommand(commands);

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }
}
