package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import com.paradigmadigital.rover.Rover;
import com.paradigmadigital.rover.RoverPositionedEast;
import com.paradigmadigital.rover.RoverPositionedNorth;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ControlCenterTest {

  private static final Plateau plateau = new Plateau(5, 5);

  public static Stream<Arguments> provideCommands() {
    return Stream.of(
        Arguments.of(
            new RoverPositionedNorth(plateau, Coordinate.of(1, 2)),
            "LMLMLMLMM",
            new RoverPositionedNorth(plateau, Coordinate.of(1, 3))),
        Arguments.of(
            new RoverPositionedEast(plateau, Coordinate.of(3, 3)),
            "MMRMMRMRRM",
            new RoverPositionedEast(plateau, Coordinate.of(5, 1)))
    );
  }

  @ParameterizedTest
  @MethodSource("provideCommands")
  void executeCommandsTest(Rover initial, String commands, Rover expected) {
    ControlCenter controlCenter = new ControlCenter(initial);

    Rover actual = controlCenter.run(commands);

    assertThat(actual.getCoordinate()).isEqualTo(expected.getCoordinate());
    assertThat(actual.getOrientation()).isEqualTo(expected.getOrientation());
  }
}
