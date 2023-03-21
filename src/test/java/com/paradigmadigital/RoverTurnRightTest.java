package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import com.paradigmadigital.rover.Rover;
import com.paradigmadigital.rover.RoverPositionedEast;
import com.paradigmadigital.rover.RoverPositionedNorth;
import com.paradigmadigital.rover.RoverPositionedSouth;
import com.paradigmadigital.rover.RoverPositionedWest;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoverTurnRightTest {

  private static final Plateau plateau = new Plateau(5, 5);
  private static final Coordinate coordinate = Coordinate.of(0, 0);

  public static Stream<Arguments> provideDataForTurnRight() {
    return Stream.of(
        Arguments.of(new RoverPositionedNorth(plateau, coordinate), Orientation.EAST),
        Arguments.of(new RoverPositionedWest(plateau, coordinate), Orientation.NORTH),
        Arguments.of(new RoverPositionedSouth(plateau, coordinate), Orientation.WEST),
        Arguments.of(new RoverPositionedEast(plateau, coordinate), Orientation.SOUTH)
    );
  }

  @ParameterizedTest
  @MethodSource("provideDataForTurnRight")
  void testTurnRight(Rover rover, Orientation expected) {

    Rover actual = rover.turnRight();

    assertThat(actual.getOrientation()).isEqualTo(expected);
  }

}
