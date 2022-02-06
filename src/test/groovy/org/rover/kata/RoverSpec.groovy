package org.rover.kata


import spock.lang.Specification

import static org.rover.kata.Direction.NORTH

class RoverSpec extends Specification {
    private static final def START_COORDINATE_X = 0
    private static final def START_COORDINATE_Y = 0
    private static final Direction START_DIRECTION = Direction.EAST
    private static final def START_LOCATION = new Location(START_COORDINATE_X, START_COORDINATE_Y, START_DIRECTION)

    def "when rover is initialized then fields are set"() {
        when:
            def rover = createRover()
        then:
            verifyAll(rover, {
                x() == START_COORDINATE_X
                y() == START_COORDINATE_Y
                direction() == START_DIRECTION
                location() == START_LOCATION
            })
    }

    def "when receive commands '#commands' then rover in '#expectedLocation'"() {
        given:
            def rover = createRover()
        when:
            def movedRover = rover.receiveCommands(commands)
        then:
            movedRover.location() == expectedLocation
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
            def rover = createRover()
        when:
            def movedRover = rover.receiveCommands("")
        then:
            movedRover.report() == START_LOCATION.report()
    }

    def "rover immutable when 'rover.receiveCommand()'"() {
        given:
            def rover = createRover()
        when:
            rover.receiveCommands("F")
        then:
            rover == createRover()
    }

    def "when rover.withLocation() then return rover copy with new location"() {
        given:
            def expectedLocation = new Location(1, 2, NORTH)
        when:
            def rover = createRover().withLocation(expectedLocation)
        then:
            rover.location() == expectedLocation
    }

    Rover createRover() {
        return new Rover(START_LOCATION)
    }
}
