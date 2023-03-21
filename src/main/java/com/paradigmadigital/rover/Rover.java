package com.paradigmadigital.rover;

import com.paradigmadigital.Coordinate;
import com.paradigmadigital.ObstacleDetectedException;
import com.paradigmadigital.Orientation;
import com.paradigmadigital.Plateau;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class Rover {

  private final Plateau plateau;
  private final Coordinate coordinate;
  private final Orientation orientation;

  protected Rover(Plateau plateau, Coordinate coordinate, Orientation orientation) {
    if (plateau.hasObstacleAt(coordinate)) {
      throw new ObstacleDetectedException("An obstacle has been detected at the " + coordinate);
    }
    this.plateau = plateau;
    this.coordinate = coordinate;
    this.orientation = orientation;
  }

  public abstract Rover move();

  public abstract Rover turnLeft();

  public abstract Rover turnRight();

  public Plateau getPlateau() {
    return plateau;
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }

  public Orientation getOrientation() {
    return orientation;
  }
}
