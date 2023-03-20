package com.paradigmadigital.rover;

import com.paradigmadigital.Coordinate;
import com.paradigmadigital.Orientation;
import com.paradigmadigital.Plateau;

public class RoverPositionedSouth extends Rover {

  public static final Orientation ORIENTATION = Orientation.SOUTH;

  public RoverPositionedSouth(Plateau plateau, Coordinate coordinate) {
    super(plateau, coordinate, ORIENTATION);
  }

  public Rover move() {
    Coordinate coordinate = getCoordinate();

    if (coordinate.getY() > 0) {
      return new RoverPositionedSouth(getPlateau(), Coordinate.of(coordinate.getX(), coordinate.getY() - 1));
    }

    return this;
  }

  public Rover rotateLeft() {
    return new RoverPositionedEast(getPlateau(), getCoordinate());
  }

  public Rover rotateRight() {
    return new RoverPositionedWest(getPlateau(), getCoordinate());
  }
}
