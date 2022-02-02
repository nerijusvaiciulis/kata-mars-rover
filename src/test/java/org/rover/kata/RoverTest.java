package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rover.kata.Direction.*;

public class RoverTest {

    private Rover rover;
    private Direction direction = Direction.EAST;
    private int x = 4;
    private int y = 2;

    @BeforeEach
    void setUp() {
        rover = new Rover(x, y, direction);
    }

    @Test
    public void whenRoverIsInitializedThenCoordinatesAreSet() {
        assertThat(rover.x()).isEqualTo(x);
        assertThat(rover.y()).isEqualTo(y);
    }

    @Test
    public void whenRoverIsInitializedThenDirectionIsSet() {
        assertThat(rover.direction()).isEqualTo(direction);
    }

    @Test
    public void whenReceiveCommandThenExecuteAction() {
        rover.receiveCommand("");
    }

    @Test
    public void givenDirectionEastWhenReceiveCommandFThenXIncrease() {
        rover.receiveCommand("F");
        assertThat(rover.x()).isEqualTo(x + 1);
    }

    @Test
    public void givenDirectionEastWhenReceiveCommandBThenXDecrease() {
        rover.receiveCommand("B");
        assertThat(rover.x()).isEqualTo(x - 1);
    }

    @Test
    public void givenDirectionNorthWhenReceiveCommandFThenYIncrease() {
        rover = new Rover(x, y, NORTH);

        rover.receiveCommand("F");

        assertThat(rover.y()).isEqualTo(y + 1);
    }

    @Test
    public void givenDirectionNorthWhenReceiveCommandBThenYDecrease() {
        rover = new Rover(x, y, NORTH);

        rover.receiveCommand("B");

        assertThat(rover.y()).isEqualTo(y - 1);
    }

    @Test
    public void givenDirectionWestWhenReceiveCommandFThenXDecrease() {
        rover = new Rover(x, y, WEST);

        rover.receiveCommand("F");

        assertThat(rover.x()).isEqualTo(x - 1);
    }

    @Test
    public void givenDirectionWestWhenReceiveCommandBThenXIncrease() {
        rover = new Rover(x, y, WEST);

        rover.receiveCommand("B");

        assertThat(rover.x()).isEqualTo(x + 1);
    }

    @Test
    public void givenDirectionSouthWhenReceiveCommandFThenYDecrease() {
        rover = new Rover(x, y, SOUTH);

        rover.receiveCommand("F");

        assertThat(rover.y()).isEqualTo(y - 1);
    }

    @Test
    public void givenDirectionSouthWhenReceiveCommandBThenYIncrease() {
        rover = new Rover(x, y, SOUTH);

        rover.receiveCommand("B");

        assertThat(rover.y()).isEqualTo(y + 1);
    }

    @Test
    public void whenReceiveCommandLThenDirectionLeft() {
        Direction expected = direction.left();

        rover.receiveCommand("L");

        assertThat(rover.direction()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveCommandRThenDirectionRight() {
        Direction expected = direction.right();

        rover.receiveCommand("R");

        assertThat(rover.direction()).isEqualTo(expected);
    }

    @Test
    public void whenReceiveMultipleCommandsThenExecuteAll() {
        rover.receiveCommand("FF");

        assertThat(rover.x()).isEqualTo(x + 2);
    }

    @Test
    public void whenMoveInLeftCircleThenKeepSameCoordinatesAndDirection() {
        rover.receiveCommand("FLFLFLFL");

        assertThat(rover.x()).as("x").isEqualTo(x);
        assertThat(rover.y()).as("y").isEqualTo(y);
        assertThat(rover.direction()).isEqualTo(direction);
    }

    @Test
    public void whenMoveInRightCircleThenKeepSameCoordinatesAndDirection() {
        rover.receiveCommand("FRFRFRFR");

        assertThat(rover.x()).as("x").isEqualTo(x);
        assertThat(rover.y()).as("y").isEqualTo(y);
        assertThat(rover.direction()).isEqualTo(direction);
    }

    @Test
    public void whenReceiveCommandThenReportCoordinatesAndDirection() {
        String report = rover.receiveCommand("F");

        assertThat(report).isEqualTo("(5, 2) EAST");
    }

    @Test
    public void whenReceiveDifferentCommandThenReportDifferentCoordinatesAndDirection() {
        String report = rover.receiveCommand("B");

        assertThat(report).isEqualTo("(3, 2) EAST");
    }
}
