package org.rover.kata

import spock.lang.Shared
import spock.lang.Specification

class RoverSpec extends Specification
{
    @Shared private final def START_COORDINATE_X = 0
    @Shared private final def START_COORDINATE_Y = 0
    @Shared private final Direction START_DIRECTION = Direction.EAST
    @Shared final def START_LOCATION = new Location(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION)

    def "when rover is initialized then fields are set"() {
        expect:
            createRover().x() == START_COORDINATE_X
            createRover().y() == START_COORDINATE_Y
            createRover().direction() == START_DIRECTION
            createRover().location() == START_LOCATION
            new Rover(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION).location() == START_LOCATION
    }

    def "when receive commands '#commands' then rover in '#expectedLocation'"() {
        given:
            def rover = createRover()
        expect:
            rover.receiveCommand(commands)
            rover.location() == expectedLocation
        where:
            commands   || expectedLocation
            "F"        || START_LOCATION.forward()
            "B"        || START_LOCATION.backward()
            "L"        || START_LOCATION.left()
            "R"        || START_LOCATION.right()
            "FF"       || START_LOCATION.forward().forward()
            "FLFLFLFL" || START_LOCATION.forward().left().forward().left().forward().left().forward().left()
            "FRFRFRFR" || START_LOCATION.forward().right().forward().right().forward().right().forward().right()
    }

    def "when receive command then report location"() {
        given:
            def rover = new Rover(START_LOCATION)
        expect:
            rover.receiveCommand("") == START_LOCATION.report()
    }

    Rover createRover() {
        return new Rover(START_LOCATION)
    }
}