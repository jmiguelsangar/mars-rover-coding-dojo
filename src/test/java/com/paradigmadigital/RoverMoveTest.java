package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
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
        Arguments.of(Coordinate.of(MIN_X, MIN_Y), Orientation.NORTH, Coordinate.of(MIN_X, MIN_Y + 1)),
        Arguments.of(Coordinate.of(MID_X, MID_Y), Orientation.NORTH, Coordinate.of(MID_X, MID_Y + 1)),
        Arguments.of(Coordinate.of(MAX_X, MAX_Y), Orientation.NORTH, Coordinate.of(MAX_X, MAX_Y)),

        Arguments.of(Coordinate.of(MIN_X, MIN_Y), Orientation.WEST, Coordinate.of(MIN_X, MIN_Y)),
        Arguments.of(Coordinate.of(MID_X, MID_Y), Orientation.WEST, Coordinate.of(MID_X - 1, MID_Y)),
        Arguments.of(Coordinate.of(MAX_X, MAX_Y), Orientation.WEST, Coordinate.of(4, MAX_Y)),

        Arguments.of(Coordinate.of(MIN_X, MIN_Y), Orientation.SOUTH, Coordinate.of(MIN_X, MIN_Y)),
        Arguments.of(Coordinate.of(MID_X, MID_Y), Orientation.SOUTH, Coordinate.of(MID_X, MID_Y - 1)),
        Arguments.of(Coordinate.of(MAX_X, MAX_Y), Orientation.SOUTH, Coordinate.of(MAX_X, MAX_Y - 1)),

        Arguments.of(Coordinate.of(MIN_X, MIN_Y), Orientation.EAST, Coordinate.of(MIN_X + 1, MIN_Y)),
        Arguments.of(Coordinate.of(MID_X, MID_Y), Orientation.EAST, Coordinate.of(MID_X + 1, MID_Y)),
        Arguments.of(Coordinate.of(MAX_X, MAX_Y), Orientation.EAST, Coordinate.of(MAX_X, MAX_Y))
    );
  }

  @BeforeAll
  static void beforeAll() {
    plateau = new Plateau(MAX_X, MAX_Y);
  }

  @ParameterizedTest
  @MethodSource("dataForTest")
  void roverShouldMoveTo(Coordinate initial, Orientation orientation, Coordinate expected) {
    Rover rover = new Rover(plateau, initial, orientation);

    rover.move();

    assertThat(rover.getCoordinate()).isEqualTo(expected);
  }
}
