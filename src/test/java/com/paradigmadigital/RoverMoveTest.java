package com.paradigmadigital;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RoverMoveTest {

  @Test
  void shouldMoveNorth() {
    Plateau plateau = new Plateau(5,5);
    Coordinate coordinate = new Coordinate(0,0);
    Orientation orientation = Orientation.NORTH;
    Rover rover = new Rover(plateau, coordinate, orientation);
    Coordinate expected = new Coordinate(0, 1);

    rover.move();

    assertThat(rover.getCoordinate()).isEqualTo(expected);
  }
}
