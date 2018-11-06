package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveTimeC extends Command {
	double autospeed;
	
    public AutoDriveTimeC() {
        requires(Robot.drivebase);
        autospeed = RobotMap.AUTO_SPEED * Math.signum(RobotMap.AUTO_DISTANCE); // Math.sigma returns -1, 0, or 1 depending on sign of autodistance
    }

    protected void initialize() {
    	setTimeout(RobotMap.AUTO_TIME);  // timeout set in preferences
    	SmartDashboard.putNumber("Speed in AutoTime", (autospeed));
    }

    protected void execute() {
     	Robot.drivebase.arcadeDrive((autospeed), 0, 0, 1); // drive straight
    }

    protected boolean isFinished() {
    	SmartDashboard.putNumber("TimeElapsed",timeSinceInitialized());
        return isTimedOut();
    }

    protected void end() {
    //	Robot.drivebase.arcadeDrive(0, 0, 0, 0);  // this didn't seem to change anything
    }

    protected void interrupted() {
    	end();
    }
}
