package org.rover.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.rover.kata.Direction.*;

public class LocationTest {
    private static final int START_COORDINATE_X = 1;
    private static final int START_COORDINATE_Y = 2;
    private static final Direction START_DIRECTION = Direction.EAST;

    private static Location createLocation() {
        return new Location(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION);
    }

    @Test
    public void whenInitializedThenXIsSet() {
        assertThat(createLocation().x()).isEqualTo(START_COORDINATE_X);
    }

    @Test
    public void whenInitializedThenYIsSet() {
        assertThat(createLocation().y()).isEqualTo(START_COORDINATE_Y);
    }

    @Test
    public void whenInitializedThenDirectionIsSet() {
        assertThat(createLocation().direction()).isEqualTo(START_DIRECTION);
    }

    @Test
    public void whenActionThenLocationImmutable() {
        Location location = createLocation();

        location.forward();
        assertThat(location).isEqualTo(createLocation());

        location.backward();
        assertThat(location).isEqualTo(createLocation());

        location.left();
        assertThat(location).isEqualTo(createLocation());

        location.right();
        assertThat(location).isEqualTo(createLocation());
    }

    @Test
    public void givenLocationWhenWithXThenReturnNewLocationWithOnlyXChanged() {
        int expected = 111;
        Location location = createLocation().withX(expected);

        assertThat(location.x()).isEqualTo(expected);
        assertThat(location.y()).isEqualTo(START_COORDINATE_Y);
        assertThat(location.direction()).isEqualTo(START_DIRECTION);
    }

    @Test
    public void givenLocationWhenWithYThenReturnNewLocationWithOnlyYChanged() {
        int expected = 111;
        Location location = createLocation().withY(expected);

        assertThat(location.x()).isEqualTo(START_COORDINATE_X);
        assertThat(location.y()).isEqualTo(expected);
        assertThat(location.direction()).isEqualTo(START_DIRECTION);
    }

    @Test
    public void givenLocationWhenWithDirectionThenReturnNewLocationWithOnlyDirectionChanged() {
        Direction expected = SOUTH;
        Location location = createLocation().withDirection(expected);

        assertThat(location.x()).isEqualTo(START_COORDINATE_X);
        assertThat(location.y()).isEqualTo(START_COORDINATE_Y);
        assertThat(location.direction()).isEqualTo(expected);
    }

    @Test
    public void whenMovingToDirectionThenCoordinateChange() {
        assertThat(createLocation(EAST).forward()).isEqualTo(createLocation(EAST).withX(START_COORDINATE_X + 1));
        assertThat(createLocation(WEST).forward()).isEqualTo(createLocation(WEST).withX(START_COORDINATE_X - 1));
        assertThat(createLocation(NORTH).forward()).isEqualTo(createLocation(NORTH).withY(START_COORDINATE_Y + 1));
        assertThat(createLocation(SOUTH).forward()).isEqualTo(createLocation(SOUTH).withY(START_COORDINATE_Y - 1));

        assertThat(createLocation(EAST).backward()).isEqualTo(createLocation(EAST).withX(START_COORDINATE_X - 1));
        assertThat(createLocation(WEST).backward()).isEqualTo(createLocation(WEST).withX(START_COORDINATE_X + 1));
        assertThat(createLocation(NORTH).backward()).isEqualTo(createLocation(NORTH).withY(START_COORDINATE_Y - 1));
        assertThat(createLocation(SOUTH).backward()).isEqualTo(createLocation(SOUTH).withY(START_COORDINATE_Y + 1));
    }

    @Test
    public void whenTurnThenDirectionChange() {
        assertThat(createLocation().left()).isEqualTo(createLocation().withDirection(START_DIRECTION.left()));
        assertThat(createLocation().right()).isEqualTo(createLocation().withDirection(START_DIRECTION.right()));
    }

    @Test
    public void whenReportThenReturnFormattedText() {
        assertThat(createLocation().report()).isEqualTo("(1, 2) EAST");
    }

    private Location createLocation(Direction direction) {
        return createLocation().withDirection(direction);
    }
}
