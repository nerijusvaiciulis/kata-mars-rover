package org.rover.kata

import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThat
import static org.rover.kata.Direction.EAST
import static org.rover.kata.Direction.NORTH
import static org.rover.kata.Direction.SOUTH
import static org.rover.kata.Direction.WEST

class LocationSpec extends Specification {
    private static final int START_COORDINATE_X = 1
    private static final int START_COORDINATE_Y = 2
    private static final Direction START_DIRECTION = EAST

    def "when initialized then coordinates and direction are set"() {
        given:
            def location = createLocation()
        expect:
            verifyAll(location, {
                x() == START_COORDINATE_X
                y() == START_COORDINATE_Y
                direction() == START_DIRECTION
            })
    }

    def "location immutable when 'location.#method ()'"() {
        given:
            def location = createLocation()
        when:
            location."$method"()
        then:
            location == createLocation()
        where:
            method << ["forward", "backward", "left", "right"]
    }

    def "when location.withX() then return location copy with new x"() {
        given:
            int expected = 111
        when:
            def location = createLocation().withX(expected)
        then:
            verifyAll(location, {
                x() == expected
                y() == START_COORDINATE_Y
                direction() == START_DIRECTION
            })
    }

    def "when location.withY() then return location copy with new y"() {
        given:
            int expected = 222
        when:
            def location = createLocation().withY(expected)
        then:
            verifyAll(location, {
                x() == START_COORDINATE_X
                y() == expected
                direction() == START_DIRECTION
            })
    }

    def "when location.withDirection() then return location copy new direction"() {
        given:
            int expected = 222
        when:
            def location = createLocation().withY(expected)
        then:
            verifyAll(location, {
                x() == START_COORDINATE_X
                y() == expected
                direction() == START_DIRECTION
            })
    }

    def "when moving to direction then coordinate change"() {
        expect:
            createLocation(EAST).forward() == createLocation(EAST).withX(START_COORDINATE_X + 1)
            createLocation(WEST).forward() == createLocation(WEST).withX(START_COORDINATE_X - 1)
            createLocation(NORTH).forward() == createLocation(NORTH).withY(START_COORDINATE_Y + 1)
            createLocation(SOUTH).forward() == createLocation(SOUTH).withY(START_COORDINATE_Y - 1)

            createLocation(EAST).backward() == createLocation(EAST).withX(START_COORDINATE_X - 1)
            createLocation(WEST).backward() == createLocation(WEST).withX(START_COORDINATE_X + 1)
            createLocation(NORTH).backward() == createLocation(NORTH).withY(START_COORDINATE_Y - 1)
            createLocation(SOUTH).backward() == createLocation(SOUTH).withY(START_COORDINATE_Y + 1)
    }

    def "when turn then direction change"() {
        assertThat(createLocation().left()).isEqualTo(createLocation().withDirection(START_DIRECTION.left()))
        assertThat(createLocation().right()).isEqualTo(createLocation().withDirection(START_DIRECTION.right()))
    }

    private Location createLocation() {
        return new Location(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION)
    }

    private Location createLocation(Direction direction) {
        return new Location(START_COORDINATE_X, START_COORDINATE_Y, direction)
    }
}

