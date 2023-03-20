package com.paradigmadigital;

public class ControlCenter {

  private final Rover rover;

  public ControlCenter(Rover rover) {
    this.rover = rover;
  }

  public void run(String commands) {
    for (String c : commands.split("")) {
      switch (c) {
        case "M":
          rover.move();
          break;
        case "L":
          rover.rotateLeft();
          break;
        case "R":
          rover.rotateRight();
          break;
        default:
      }
    }

  }
}
