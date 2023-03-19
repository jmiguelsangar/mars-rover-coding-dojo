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
    this.coordinate = new Coordinate(getCoordinate().getX(), getCoordinate().getY()+1);
  }
}
