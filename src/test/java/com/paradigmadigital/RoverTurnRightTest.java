package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoverTurnRightTest {

  public static Stream<Arguments> provideDataForTurnRight() {
    return Stream.of(
        Arguments.of(Orientation.NORTH, Orientation.EAST),
        Arguments.of(Orientation.WEST, Orientation.NORTH),
        Arguments.of(Orientation.SOUTH, Orientation.WEST),
        Arguments.of(Orientation.EAST, Orientation.SOUTH)
    );
  }

  @ParameterizedTest
  @MethodSource("provideDataForTurnRight")
  void testTurnRight(Orientation initial, Orientation expected) {
    Plateau plateau = new Plateau(5, 5);
    Coordinate coordinate = Coordinate.of(0, 0);
    Rover rover = new Rover(plateau, coordinate, initial);

    rover.turnRight();

    assertThat(rover.getOrientation()).isEqualTo(expected);
  }

}
