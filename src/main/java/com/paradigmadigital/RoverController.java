package com.paradigmadigital;

public class RoverController {

  private Rover rover;

  public RoverController(Rover rover) {
    this.rover = rover;
  }

  public Rover run(String commands) {

    try {
      for (String c : commands.split("")) {
        switch (c) {
          case "M":
            rover = rover.move();
            break;
          case "L":
            rover = rover.turnLeft();
            break;
          case "R":
            rover = rover.turnRight();
            break;
          default:
        }
      }
    } catch (ObstacleDetectedException e) {
      System.out.println(e.getMessage());
    }

    return rover;
  }
}
