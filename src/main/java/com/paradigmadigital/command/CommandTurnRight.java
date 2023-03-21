package com.paradigmadigital.command;

import com.paradigmadigital.rover.Rover;

public class CommandTurnRight implements Command {

  @Override
  public Rover execute(Rover rover) {
    return rover.turnRight();
  }
}
