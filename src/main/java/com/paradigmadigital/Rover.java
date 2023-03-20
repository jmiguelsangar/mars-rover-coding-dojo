package com.paradigmadigital;

import lombok.Value;

@Value
public class Rover {

  Plateau plateau;
  Coordinate coordinate;
  Orientation orientation;

  public Rover move() {
    Coordinate newCoordinate = this.getCoordinate();

    switch (orientation) {
      case NORTH:
        if (getCoordinate().getY() < plateau.getMaxY()) {
          newCoordinate = getValidCoodinate(Coordinate.of(getCoordinate().getX(), getCoordinate().getY() + 1));
        }
        break;
      case SOUTH:
        if (getCoordinate().getY() > 0) {
          newCoordinate = getValidCoodinate(Coordinate.of(getCoordinate().getX(), getCoordinate().getY() - 1));
        }
        break;
      case EAST:
        if (getCoordinate().getX() < plateau.getMaxX()) {
          newCoordinate = getValidCoodinate(Coordinate.of(getCoordinate().getX() + 1, getCoordinate().getY()));
        }
        break;
      case WEST:
        if (getCoordinate().getX() > 0) {
          newCoordinate = getValidCoodinate(Coordinate.of(getCoordinate().getX() - 1, getCoordinate().getY()));
        }
        break;
    }

    return new Rover(getPlateau(), newCoordinate, getOrientation());
  }

  public Rover turnLeft() {
    Orientation newOrientation = getOrientation();

    switch (orientation) {
      case NORTH:
        newOrientation = Orientation.WEST;
        break;
      case SOUTH:
        newOrientation = Orientation.EAST;
        break;
      case EAST:
        newOrientation = Orientation.NORTH;
        break;
      case WEST:
        newOrientation = Orientation.SOUTH;
        break;
    }

    return new Rover(getPlateau(), getCoordinate(), newOrientation);
  }

  public Rover turnRight() {
    Orientation newOrientation = getOrientation();

    switch (orientation) {
      case NORTH:
        newOrientation = Orientation.EAST;
        break;
      case EAST:
        newOrientation = Orientation.SOUTH;
        break;
      case SOUTH:
        newOrientation = Orientation.WEST;
        break;
      case WEST:
        newOrientation = Orientation.NORTH;
        break;
    }

    return new Rover(getPlateau(), getCoordinate(), newOrientation);
  }

  private Coordinate getValidCoodinate(Coordinate nextCoordinate) {
    if (plateau.hasObstacleAt(nextCoordinate)) {
      throw new ObstacleDetectedException("An obstacle has been detected at the " + coordinate);
    }

    return nextCoordinate;
  }
}
