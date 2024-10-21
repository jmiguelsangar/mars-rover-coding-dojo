package com.paradigmadigital;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RoverMoveTest {
    public static final int MIN_X = 0;
    public static final int MIN_Y = 0;
    public static final int MID_X = 3;
    public static final int MID_Y = 3;
    public static final int MAX_X = 5;
    public static final int MAX_Y = 5;
    private static Plateau plateau;
        
    public static Stream<Arguments> dataForTest() {
        
        return Stream.of(
            Arguments.of(new Coordinate(MIN_X,MIN_Y), Orientation.NORTH, new Coordinate(MIN_X, MIN_Y + 1)),
            Arguments.of(new Coordinate(MID_X,MID_Y), Orientation.NORTH, new Coordinate(MID_X, MID_Y + 1)),
            Arguments.of(new Coordinate(MAX_X,MAX_Y), Orientation.NORTH, new Coordinate(MAX_X, MAX_Y)),

            Arguments.of(new Coordinate(MIN_X,MIN_Y), Orientation.WEST, new Coordinate(MIN_X, MIN_Y)),
            Arguments.of(new Coordinate(MID_X,MID_Y), Orientation.WEST, new Coordinate(MID_X - 1, MID_Y)),
            Arguments.of(new Coordinate(MAX_X,MAX_Y), Orientation.WEST, new Coordinate(MAX_X - 1, MAX_Y)),

            Arguments.of(new Coordinate(MIN_X,MIN_Y), Orientation.EAST, new Coordinate(MIN_X + 1, MIN_Y)),
            Arguments.of(new Coordinate(MID_X,MID_Y), Orientation.EAST, new Coordinate(MID_X + 1, MID_Y)),
            Arguments.of(new Coordinate(MAX_X,MAX_Y), Orientation.EAST, new Coordinate(MAX_X, MAX_Y)),

            Arguments.of(new Coordinate(MIN_X,MIN_Y), Orientation.SOUTH, new Coordinate(MIN_X, MIN_Y)),
            Arguments.of(new Coordinate(MID_X,MID_Y), Orientation.SOUTH, new Coordinate(MID_X, MID_Y - 1)),
            Arguments.of(new Coordinate(MAX_X,MAX_Y), Orientation.SOUTH, new Coordinate(MAX_X, MAX_Y - 1))
            
        );
    }

    @BeforeAll
    static void beforeAll() {
        plateau = new Plateau(MAX_X,MAX_Y);
    }

    @Test
    void roverShouldMoveNorth() {        
        Coordinate coordinate = new Coordinate(0,0);
        Orientation orientation = Orientation.NORTH;
        Rover rover = new Rover(plateau, coordinate, orientation);
        Coordinate expected = new Coordinate(0,1);

        rover.move();

        assertEquals(expected, rover.getCoordinate());
    } 

    @ParameterizedTest
    @MethodSource("dataForTest")
    void roverShouldMoveTo(Coordinate coordinate, Orientation orientation, Coordinate expected) {
        Rover rover = new Rover(plateau, coordinate, orientation);

        rover.move();
        
        assertEquals(expected, rover.getCoordinate());
    }
}
