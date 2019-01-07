package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberArmCloseC extends Command {

    public GrabberArmCloseC() {
        requires(Robot.grabberArm);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.grabberArm.close();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
