package com.paradigmadigital.rover;

import com.paradigmadigital.Coordinate;
import com.paradigmadigital.Orientation;
import com.paradigmadigital.Plateau;

public class RoverPositionedNorth extends Rover {

  public static final Orientation ORIENTATION = Orientation.NORTH;

  public RoverPositionedNorth(Plateau plateau, Coordinate coordinate) {
    super(plateau, coordinate, ORIENTATION);
  }

  public Rover move() {
    Coordinate coordinate = getCoordinate();

    if (coordinate.getY() < this.getPlateau().getMaxY()) {
      return new RoverPositionedNorth(getPlateau(), Coordinate.of(coordinate.getX(), coordinate.getY() + 1));
    }

    return this;
  }

  public Rover turnLeft() {
    return new RoverPositionedWest(getPlateau(), getCoordinate());
  }

  public Rover turnRight() {
    return new RoverPositionedEast(getPlateau(), getCoordinate());
  }
}
