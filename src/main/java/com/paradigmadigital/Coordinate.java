package com.paradigmadigital;

import lombok.Value;

@Value
public class Coordinate {

  int x;
  int y;

  public static Coordinate of(int x, int y) {
    return new Coordinate(x, y);
  }
}
