package com.paradigmadigital;

public class ControlCenter {

  private Rover rover;

  public ControlCenter(Rover rover) {
    this.rover = rover;
  }

  public Rover run(String commands) {
    for (String c : commands.split("")) {
      switch (c) {
        case "M":
          rover = rover.move();
          break;
        case "L":
          rover = rover.rotateLeft();
          break;
        case "R":
          rover = rover.rotateRight();
          break;
        default:
      }
    }
    return rover;
  }
}
