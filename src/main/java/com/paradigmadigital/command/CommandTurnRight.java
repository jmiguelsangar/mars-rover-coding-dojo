package com.paradigmadigital.command;

import com.paradigmadigital.Rover;

public class CommandTurnRight implements Command {

  @Override
  public Rover execute(Rover rover) {
    return rover.rotateRight();
  }
}
