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
    public void givenDirectionEastWhenReceiveCommandLThenDirectionNorth() {
        rover = new Rover(x, y, EAST);

        rover.receiveCommand("L");

        assertThat(rover.direction()).isEqualTo(NORTH);
    }

    @Test
    public void givenDirectionNorthWhenReceiveCommandLThenDirectionWest() {
        rover = new Rover(x, y, NORTH);

        rover.receiveCommand("L");

        assertThat(rover.direction()).isEqualTo(WEST);
    }

    @Test
    public void givenDirectionWestWhenReceiveCommandLThenDirectionSouth() {
        rover = new Rover(x, y, WEST);

        rover.receiveCommand("L");

        assertThat(rover.direction()).isEqualTo(SOUTH);
    }

    @Test
    public void givenDirectionSouthWhenReceiveCommandLThenDirectionEast() {
        rover = new Rover(x, y, SOUTH);

        rover.receiveCommand("L");

        assertThat(rover.direction()).isEqualTo(EAST);
    }

    @Test
    public void givenDirectionSouthWhenReceiveCommandRThenDirectionWest() {
        rover = new Rover(x, y, SOUTH);

        rover.receiveCommand("R");

        assertThat(rover.direction()).isEqualTo(WEST);
    }

    @Test
    public void givenDirectionWestWhenReceiveCommandRThenDirectionNorth() {
        rover = new Rover(x, y, WEST);

        rover.receiveCommand("R");

        assertThat(rover.direction()).isEqualTo(NORTH);
    }

    @Test
    public void givenDirectionNorthReceiveCommandRThenDirectionEast() {
        rover = new Rover(x, y, NORTH);

        rover.receiveCommand("R");

        assertThat(rover.direction()).isEqualTo(EAST);
    }

    @Test
    public void givenDirectionEastReceiveCommandRThenDirectionSouth() {
        rover = new Rover(x, y, EAST);

        rover.receiveCommand("R");

        assertThat(rover.direction()).isEqualTo(SOUTH);
    }
}
