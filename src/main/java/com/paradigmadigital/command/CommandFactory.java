package com.paradigmadigital.command;

import com.paradigmadigital.Rover;
import java.util.Map;

public class CommandFactory {

  private Map<String, Command> commands;

  public CommandFactory() {
    this.initCommands();
  }

  private void initCommands() {
    this.commands = Map.of(
        "M", new CommandMove(),
        "L", new CommandTurnLeft(),
        "R", new CommandTurnRight()
    );
  }

  public Rover execute(Rover rover, String c) {
    Command command = commands.get(c);
    return command.execute(rover);
  }
}
