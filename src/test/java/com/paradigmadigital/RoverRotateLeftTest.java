package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoverRotateLeftTest {

  public static Stream<Arguments> provideDataForRotateLeft() {
    return Stream.of(
        Arguments.of(Orientation.NORTH, Orientation.WEST),
        Arguments.of(Orientation.WEST, Orientation.SOUTH),
        Arguments.of(Orientation.SOUTH, Orientation.EAST),
        Arguments.of(Orientation.EAST, Orientation.NORTH)
    );
  }

  @ParameterizedTest
  @MethodSource("provideDataForRotateLeft")
  void testRotateLeft(Orientation initial, Orientation expected) {
    Plateau plateau = new Plateau(5, 5);
    Coordinate coordinate = Coordinate.of(0, 0);
    Rover rover = new Rover(plateau, coordinate, initial);

    Rover actual = rover.rotateLeft();

    assertThat(actual.getOrientation()).isEqualTo(expected);
  }
}
