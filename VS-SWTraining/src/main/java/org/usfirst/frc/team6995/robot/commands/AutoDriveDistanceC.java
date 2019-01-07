package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDriveDistanceC extends Command {

	public AutoDriveDistanceC() {
    	requires(Robot.drivebase);	
	}
	
    protected void initialize() {
    	Robot.drivebase.resetEncoder();
    	System.out.println("init autodistance");
    }

    protected void execute() {
    	Robot.drivebase.arcadeDrive(RobotPreferences.AutoSpeed(), 0, 0, 1); // drive straight 
    }

    protected boolean isFinished() {
    	SmartDashboard.putNumber("DistanceTraveled", 
    			Robot.drivebase.getDistanceTraveled());
        return (Math.abs(Robot.drivebase.getDistanceTraveled()) >= 
        		Math.abs(RobotPreferences.AutoDistance()));
    }

    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0, 0, 0);
    	Robot.drivebase.resetEncoder();
    }

    protected void interrupted() {
    	end();
    }
}
