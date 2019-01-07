package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberWheelsEjectC extends Command {

    public GrabberWheelsEjectC() {
        requires(Robot.grabberWheels);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.grabberWheels.eject();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
