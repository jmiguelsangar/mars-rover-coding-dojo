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
            new RoverPositionedNorth(plateau, Coordinate.of(1, 2)),
            "LMLMLMLMM",
            new RoverPositionedNorth(plateau, Coordinate.of(1, 3))
        ),
        Arguments.of(
            new RoverPositionedEast(plateau, Coordinate.of(3, 3)),
            "MMRMMRMRRM",
            new RoverPositionedEast(plateau, Coordinate.of(5, 1))
        ),
        Arguments.of(
            new RoverPositionedNorth(plateauWithObstacles, Coordinate.of(0, 0)),
            "MRMMRMMM",
            new RoverPositionedEast(plateauWithObstacles, Coordinate.of(0, 1))
        ),
        Arguments.of(
            new RoverPositionedEast(plateauWithObstacles, Coordinate.of(0, 0)),
            "MMMLMMMLMMM",
            new RoverPositionedWest(plateauWithObstacles, Coordinate.of(3, 3))
        ),
        Arguments.of(
            new RoverPositionedNorth(plateauWithObstacles, Coordinate.of(0, 0)),
            "MMMMMMRMMRMLMRMLMRMLMR",
            new RoverPositionedSouth(plateauWithObstacles, Coordinate.of(4, 3))
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
