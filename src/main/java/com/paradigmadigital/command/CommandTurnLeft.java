package com.paradigmadigital.command;

import com.paradigmadigital.Rover;

public class CommandTurnLeft implements Command {

  @Override
  public Rover execute(Rover rover) {
    return rover.rotateLeft();
  }
}
