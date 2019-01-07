package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberWheelsCollectC extends Command {

    public GrabberWheelsCollectC() {
        requires(Robot.grabberWheels);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.grabberWheels.collect();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
