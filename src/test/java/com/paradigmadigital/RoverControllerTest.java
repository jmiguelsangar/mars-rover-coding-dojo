package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoverControllerTest {

  private static final Plateau plateau = new Plateau(5, 5);

  public static Stream<Arguments> provideCommands() {
    return Stream.of(
        Arguments.of(
            new Rover(plateau, Coordinate.of(1, 2), Orientation.NORTH),
            "LMLMLMLMM",
            new Rover(plateau, Coordinate.of(1, 3), Orientation.NORTH)
        ),
        Arguments.of(
            new Rover(plateau, Coordinate.of(3, 3), Orientation.EAST),
            "MMRMMRMRRM",
            new Rover(plateau, Coordinate.of(5, 1), Orientation.EAST)
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideCommands")
  void executeCommandsTest(Rover initial, String commands, Rover expected) {
    RoverController roverController = new RoverController(initial);

    roverController.run(commands);

    assertThat(initial.getCoordinate()).isEqualTo(expected.getCoordinate());
    assertThat(initial.getOrientation()).isEqualTo(expected.getOrientation());
  }
}
