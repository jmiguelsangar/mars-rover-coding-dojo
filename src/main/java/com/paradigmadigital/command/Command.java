package com.paradigmadigital.command;

import com.paradigmadigital.Rover;

public interface Command {

  Rover execute(Rover rover);
}
