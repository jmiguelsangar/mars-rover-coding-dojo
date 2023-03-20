package com.paradigmadigital.rover;

import com.paradigmadigital.Coordinate;
import com.paradigmadigital.Orientation;
import com.paradigmadigital.Plateau;

public class RoverPositionedEast extends Rover {

  public static final Orientation ORIENTATION = Orientation.EAST;

  public RoverPositionedEast(Plateau plateau, Coordinate coordinate) {
    super(plateau, coordinate, ORIENTATION);
  }

  public Rover move() {
    Coordinate coordinate = getCoordinate();

    if (coordinate.getX() < this.getPlateau().getMaxX()) {
      return new RoverPositionedEast(getPlateau(), Coordinate.of(coordinate.getX() + 1, coordinate.getY()));
    }

    return this;
  }

  public Rover rotateLeft() {
    return new RoverPositionedNorth(getPlateau(), getCoordinate());
  }

  public Rover rotateRight() {
    return new RoverPositionedSouth(getPlateau(), getCoordinate());
  }
}
