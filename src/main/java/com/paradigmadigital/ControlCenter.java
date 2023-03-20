package com.paradigmadigital;

import com.paradigmadigital.command.CommandFactory;
import com.paradigmadigital.rover.Rover;
import java.util.Arrays;

public class ControlCenter {

  private Rover rover;

  public ControlCenter(Rover rover) {
    this.rover = rover;
  }

  public Rover run(String commands) {
    CommandFactory commandFactory = new CommandFactory();
    Arrays.stream(commands.split("")).forEach(s -> rover = commandFactory.execute(rover, s));

    return rover;
  }
}
