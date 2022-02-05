package org.rover.kata

import spock.lang.Specification

import static org.rover.kata.Direction.EAST
import static org.rover.kata.Direction.NORTH
import static org.rover.kata.Direction.SOUTH
import static org.rover.kata.Direction.WEST

class DirectionSpec extends Specification {
    def "turning left from '#value' results in '#expected'"() {
        expect:
            value.left() === expected
        where:
            value || expected
            NORTH || WEST
            WEST  || SOUTH
            SOUTH || EAST
            EAST  || NORTH
    }

    def "turing right from '#value' results in '#expected'"() {
        expect:
            value.right() === expected
        where:
            value || expected
            NORTH || EAST
            WEST  || NORTH
            SOUTH || WEST
            EAST  || SOUTH
    }
}