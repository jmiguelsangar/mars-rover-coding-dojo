package com.paradigmadigital;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rover {

  private final Plateau plateau;
  private Coordinate coordinate;
  private Orientation orientation;

  public void move() {
    switch (orientation) {
      case NORTH:
        if (getCoordinate().getY() < plateau.getMaxY()) {
          setNewCoordinate(Coordinate.of(getCoordinate().getX(), getCoordinate().getY() + 1));
        }
        break;
      case SOUTH:
        if (getCoordinate().getY() > 0) {
          setNewCoordinate(Coordinate.of(getCoordinate().getX(), getCoordinate().getY() - 1));
        }
        break;
      case EAST:
        if (getCoordinate().getX() < plateau.getMaxX()) {
          setNewCoordinate(Coordinate.of(getCoordinate().getX() + 1, getCoordinate().getY()));
        }
        break;
      case WEST:
        if (getCoordinate().getX() > 0) {
          setNewCoordinate(Coordinate.of(getCoordinate().getX() - 1, getCoordinate().getY()));
        }
        break;
    }
  }

  public void turnLeft() {
    switch (orientation) {
      case NORTH:
        this.orientation = Orientation.WEST;
        break;
      case SOUTH:
        this.orientation = Orientation.EAST;
        break;
      case EAST:
        this.orientation = Orientation.NORTH;
        break;
      case WEST:
        this.orientation = Orientation.SOUTH;
        break;
    }
  }

  public void turnRight() {
    switch (orientation) {
      case NORTH:
        this.orientation = Orientation.EAST;
        break;
      case EAST:
        this.orientation = Orientation.SOUTH;
        break;
      case SOUTH:
        this.orientation = Orientation.WEST;
        break;
      case WEST:
        this.orientation = Orientation.NORTH;
        break;
    }
  }

  private void setNewCoordinate(Coordinate nextCoordinate) {
    if (plateau.hasObstacleAt(nextCoordinate)) {
      throw new ObstacleDetectedException("An obstacle has been detected at the " + coordinate);
    }
    this.coordinate = nextCoordinate;
  }
}
