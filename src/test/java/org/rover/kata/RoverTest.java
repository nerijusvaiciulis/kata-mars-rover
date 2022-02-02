package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
