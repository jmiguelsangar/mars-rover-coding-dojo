package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import com.paradigmadigital.rover.Rover;
import com.paradigmadigital.rover.RoverPositionedEast;
import com.paradigmadigital.rover.RoverPositionedNorth;
import com.paradigmadigital.rover.RoverPositionedSouth;
import com.paradigmadigital.rover.RoverPositionedWest;
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
        Arguments.of(new RoverPositionedNorth(plateau, Coordinate.of(MIN_X, MIN_Y)), Coordinate.of(MIN_X, MIN_Y + 1)),
        Arguments.of(new RoverPositionedNorth(plateau, Coordinate.of(MID_X, MID_Y)), Coordinate.of(MID_X, MID_Y + 1)),
        Arguments.of(new RoverPositionedNorth(plateau, Coordinate.of(MAX_X, MAX_Y)), Coordinate.of(MAX_X, MAX_Y)),

        Arguments.of(new RoverPositionedWest(plateau, Coordinate.of(MIN_X, MIN_Y)), Coordinate.of(MIN_X, MIN_Y)),
        Arguments.of(new RoverPositionedWest(plateau, Coordinate.of(MID_X, MID_Y)), Coordinate.of(MID_X - 1, MID_Y)),
        Arguments.of(new RoverPositionedWest(plateau, Coordinate.of(MAX_X, MAX_Y)), Coordinate.of(4, MAX_Y)),

        Arguments.of(new RoverPositionedSouth(plateau, Coordinate.of(MIN_X, MIN_Y)), Coordinate.of(MIN_X, MIN_Y)),
        Arguments.of(new RoverPositionedSouth(plateau, Coordinate.of(MID_X, MID_Y)), Coordinate.of(MID_X, MID_Y - 1)),
        Arguments.of(new RoverPositionedSouth(plateau, Coordinate.of(MAX_X, MAX_Y)), Coordinate.of(MAX_X, MAX_Y - 1)),

        Arguments.of(new RoverPositionedEast(plateau, Coordinate.of(MIN_X, MIN_Y)), Coordinate.of(MIN_X + 1, MIN_Y)),
        Arguments.of(new RoverPositionedEast(plateau, Coordinate.of(MID_X, MID_Y)), Coordinate.of(MID_X + 1, MID_Y)),
        Arguments.of(new RoverPositionedEast(plateau, Coordinate.of(MAX_X, MAX_Y)), Coordinate.of(MAX_X, MAX_Y))
    );
  }

  @BeforeAll
  static void beforeAll() {
    plateau = new Plateau(MAX_X, MAX_Y);
  }

  @ParameterizedTest
  @MethodSource("dataForTest")
  void roverShouldMoveTo(Rover rover, Coordinate expected) {

    Rover actual = rover.move();

    assertThat(actual.getCoordinate()).isEqualTo(expected);
  }
}
