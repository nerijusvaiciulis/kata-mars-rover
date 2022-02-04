package org.rover.kata;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collectors;

public enum Direction {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    int value;

    public static final Map<Direction, Coordinates> actionCoordinates = Map.of(
            NORTH, new Coordinates(0, 1),
            EAST, new Coordinates(1, 0),
            SOUTH, new Coordinates(0, -1),
            WEST, new Coordinates(-1, 0)
    );

    public static final Map<Direction, Coordinates> reverseActionCoordinates = Map.copyOf(actionCoordinates)
            .entrySet()
            .stream()
            .map(a -> new SimpleEntry<>(a.getKey(), a.getValue().copyWithMultiplication(-1, -1)))
            .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));

    Direction(int i) {
        this.value = i;
    }

    public Direction left() {
        int index = (value + 3) % 4;
        return Direction.values()[index];
    }

    public Direction right(){
        int index = (value + 1) % 4;
        return Direction.values()[index];
    }
}
