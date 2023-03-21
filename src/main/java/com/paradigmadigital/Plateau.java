package com.paradigmadigital;

import java.util.ArrayList;
import java.util.List;
import lombok.Value;

@Value
public class Plateau {

  int maxX;
  int maxY;
  List<Coordinate> obstacles = new ArrayList<>();

  public void addObstacle(Coordinate obstacle) {
    this.obstacles.add(obstacle);
  }

  public boolean hasObstacleAt(Coordinate nextCoordinate) {
    return obstacles.contains(nextCoordinate);
  }
}
