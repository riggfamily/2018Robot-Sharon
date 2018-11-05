package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveTurnLeftC extends Command {
	double autospeed;
	
    public AutoDriveTurnLeftC() {
        requires(Robot.drivebase);
        autospeed = RobotMap.AUTO_SPEED * Math.signum(RobotMap.AUTO_DISTANCE); // Math.sigma returns -1, 0, or 1 depending on sign of autodistance
    }

    protected void initialize() {
    	setTimeout(RobotMap.AUTO_TURN_TIME);  // timeout set in preferences
    }

    protected void execute() {
     	Robot.drivebase.arcadeDrive((autospeed), -1, 0, 1); // drive left
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
