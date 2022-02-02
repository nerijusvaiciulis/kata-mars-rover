package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    private final Direction direction = Direction.EAST;
    private final int x = 4;
    private final int y = 2;
    private final Location location = new Location(x, y, direction);
    private Rover rover;

    @BeforeEach
    void setUp() {
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
    void whenRoverIsInitializedThenLocationIsSet() {
        Rover rover = new Rover(x, y, direction);

        assertThat(rover.location()).isEqualTo(location);
    }

    @Test
    public void whenReceiveCommandFThenForward() {
        Location expected = location.copy();
        expected.forward();

        rover.receiveCommand("F");

        assertThat(location).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandBThenBackward() {
        Location expected = location.copy();
        expected.backward();

        rover.receiveCommand("B");

        assertThat(location).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandLThenLeft() {
        Location expected = location.copy();
        expected.left();

        rover.receiveCommand("L");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandRThenRight() {
        Location expected = location.copy();
        expected.right();

        rover.receiveCommand("R");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveMultipleCommandsThenExecuteAll() {
        Location expected = location.copy();
        expected.forward();
        expected.forward();

        rover.receiveCommand("FF");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenMoveInLeftCircleThenKeepSameCoordinatesAndDirection() {
        Location expected = location.copy();
        expected.forward();
        expected.left();
        expected.forward();
        expected.left();
        expected.forward();
        expected.left();
        expected.forward();
        expected.left();

        rover.receiveCommand("FLFLFLFL");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenMoveInRightCircleThenKeepSameCoordinatesAndDirection() {
        Location expected = location.copy();
        expected.forward();
        expected.right();
        expected.forward();
        expected.right();
        expected.forward();
        expected.right();
        expected.forward();
        expected.right();
        rover.receiveCommand("FRFRFRFR");

        assertThat(rover.location()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandThenReportLocation() {
        Location expected = location.copy();

        String report = rover.receiveCommand("");

        assertThat(report).isEqualTo(expected.report());
    }
}
