package org.rover.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rover.kata.Direction.*;

public class LocationTest {

    private static final Coordinates coordinates = new Coordinates(1, 2);
    private static final Direction direction = Direction.EAST;

    @Test
    public void whenInitializedThenCoordinatesIsSet() {
        assertThat(createLocation().coordinates()).isEqualTo(coordinates);
    }

    @Test
    public void whenInitializedThenDirectionIsSet() {
        assertThat(createLocation().direction()).isEqualTo(direction);
    }

    @Test
    public void givenMovingToDirectionThenChangesCoordinates() {
        verify(createLocation().copyWith(SOUTH).backward(), coordinates.copyWithAddition(0, 1));
        verify(createLocation().copyWith(SOUTH).forward(), coordinates.copyWithAddition(0, -1));
        verify(createLocation().copyWith(WEST).backward(), coordinates.copyWithAddition(1, 0));
        verify(createLocation().copyWith(WEST).forward(), coordinates.copyWithAddition(-1, 0));
        verify(createLocation().copyWith(NORTH).backward(), coordinates.copyWithAddition(0, -1));
        verify(createLocation().copyWith(NORTH).forward(), coordinates.copyWithAddition(0, 1));
        verify(createLocation().backward(), coordinates.copyWithAddition(-1, 0));
        verify(createLocation().forward(), coordinates.copyWithAddition(1, 0));
    }

    @Test
    public void whenReportThenReturnFormattedText() {
        assertThat(createLocation().report()).isEqualTo("(1, 2) EAST");
    }

    private static void verify(Location location, Coordinates coordinates) {
        assertThat(location.coordinates()).isEqualTo(coordinates);
    }

    private static Location createLocation() {
        return new Location(EAST, coordinates);
    }
}
