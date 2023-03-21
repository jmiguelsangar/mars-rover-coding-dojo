package com.paradigmadigital;

import com.paradigmadigital.command.CommandFactory;
import com.paradigmadigital.rover.Rover;

public class RoverController {

  private Rover rover;

  public RoverController(Rover rover) {
    this.rover = rover;
  }

  public Rover run(String commands) {
    CommandFactory commandFactory = new CommandFactory();
    try {
      for (String s : commands.split("")) {
        rover = commandFactory.execute(rover, s);
      }
    } catch (ObstacleDetectedException e) {
      System.out.println(e.getMessage());
    }

    return rover;
  }
}
