package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveStraightC extends Command {
	
    public AutoDriveStraightC() {
        requires(Robot.drivebase);
    }

    protected void initialize() {
    	setTimeout(RobotPreferences.AutoTime());  // timeout set in preferences
    }

    protected void execute() {
     	Robot.drivebase.arcadeDrive(RobotPreferences.AutoSpeed(), 0, 0, 1); // drive straight
    }

    protected boolean isFinished() {
    	SmartDashboard.putNumber("TimeElapsed",timeSinceInitialized());
        return isTimedOut();
    }

    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0, 0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
