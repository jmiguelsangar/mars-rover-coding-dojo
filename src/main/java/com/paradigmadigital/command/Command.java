package com.paradigmadigital.command;

import com.paradigmadigital.rover.Rover;

public interface Command {

  Rover execute(Rover rover);
}
