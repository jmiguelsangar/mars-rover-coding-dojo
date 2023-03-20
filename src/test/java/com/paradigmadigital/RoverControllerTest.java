package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RoverControllerTest {

  private static Plateau plateau;

  private static Plateau plateauWithObstacles;

  @BeforeAll
  static void beforeAll() {
    plateau = new Plateau(5, 5);

    plateauWithObstacles = new Plateau(5, 5);
    plateauWithObstacles.addObstacle(Coordinate.of(1, 1));
    plateauWithObstacles.addObstacle(Coordinate.of(2, 3));
    plateauWithObstacles.addObstacle(Coordinate.of(4, 2));
  }

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
        ),
        Arguments.of(
            new Rover(plateauWithObstacles, Coordinate.of(0, 0), Orientation.NORTH),
            "MRMMRMMM",
            new Rover(plateauWithObstacles, Coordinate.of(0, 1), Orientation.EAST)
        ),
        Arguments.of(
            new Rover(plateauWithObstacles, Coordinate.of(0, 0), Orientation.EAST),
            "MMMLMMMLMMM",
            new Rover(plateauWithObstacles, Coordinate.of(3, 3), Orientation.WEST)
        ),
        Arguments.of(
            new Rover(plateauWithObstacles, Coordinate.of(0, 0), Orientation.NORTH),
            "MMMMMMRMMRMLMRMLMRMLMR",
            new Rover(plateauWithObstacles, Coordinate.of(4, 3), Orientation.SOUTH)
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideCommands")
  void executeCommandsTest(Rover initial, String commands, Rover expected) {
    RoverController roverController = new RoverController(initial);

    Rover actual = roverController.run(commands);

    assertThat(actual).isEqualTo(expected);
  }
}
