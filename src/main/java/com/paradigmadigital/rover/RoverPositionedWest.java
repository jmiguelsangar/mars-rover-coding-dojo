package com.paradigmadigital.rover;

import com.paradigmadigital.Coordinate;
import com.paradigmadigital.Orientation;
import com.paradigmadigital.Plateau;

public class RoverPositionedWest extends Rover {

  public static final Orientation ORIENTATION = Orientation.WEST;

  public RoverPositionedWest(Plateau plateau, Coordinate coordinate) {
    super(plateau, coordinate, ORIENTATION);
  }

  public Rover move() {
    Coordinate coordinate = getCoordinate();

    if (coordinate.getX() > 0) {
      return new RoverPositionedWest(getPlateau(), Coordinate.of(coordinate.getX() - 1, coordinate.getY()));
    }

    return this;
  }

  public Rover rotateLeft() {
    return new RoverPositionedSouth(getPlateau(), getCoordinate());
  }

  public Rover rotateRight() {
    return new RoverPositionedNorth(getPlateau(), getCoordinate());
  }
}
