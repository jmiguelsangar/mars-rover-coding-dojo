package com.paradigmadigital;

public class RoverController {

  private final Rover rover;

  public RoverController(Rover rover) {
    this.rover = rover;
  }

  public void run(String commands) {

    try {
      for (String c : commands.split("")) {
        switch (c) {
          case "M":
            rover.move();
            break;
          case "L":
            rover.turnLeft();
            break;
          case "R":
            rover.turnRight();
            break;
          default:
        }
      }
    } catch (ObstacleDetectedException e) {
      System.out.println(e.getMessage());
    }
  }
}
