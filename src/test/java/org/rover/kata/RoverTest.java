package org.rover.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {
    private final int START_COORDINATE_X = 4;
    private final int START_COORDINATE_Y = 2;
    private final Direction START_DIRECTION = Direction.EAST;
    private final Location START_LOCATION = new Location(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION);

    @Test
    public void
    whenRoverIsInitializedThenFieldsAreSet() {
        assertThat(createRover().x()).isEqualTo(START_COORDINATE_X);
        assertThat(createRover().y()).isEqualTo(START_COORDINATE_Y);
        assertThat(createRover().direction()).isEqualTo(START_DIRECTION);
        assertThat(createRover().location()).isEqualTo(START_LOCATION);
        assertThat(new Rover(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION).location()).isEqualTo(START_LOCATION);
    }

    @Test
    public void whenReceiveCommandsThenInExpectedLocation() {
        verify("F", START_LOCATION.forward());
        verify("B", START_LOCATION.backward());
        verify("L", START_LOCATION.left());
        verify("R", START_LOCATION.right());
        verify("FF", START_LOCATION.forward().forward());
        verify("FLFLFLFL", START_LOCATION.forward().left().forward().left().forward().left().forward().left());
        verify("FRFRFRFR", START_LOCATION.forward().right().forward().right().forward().right().forward().right());
    }

    @Test
    public void whenReceiveCommandThenReportLocation() {
        var report = createRover().receiveCommand("");

        assertThat(report).isEqualTo(START_LOCATION.report());
    }

    private void verify(String commands, Location expectedLocation) {
        var rover = createRover();

        rover.receiveCommand(commands);

        assertThat(rover.location()).isEqualTo(expectedLocation);
    }

    private Rover createRover() {
        return new Rover(START_LOCATION);
    }
}
