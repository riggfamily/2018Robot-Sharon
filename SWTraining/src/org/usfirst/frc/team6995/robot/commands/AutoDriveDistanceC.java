package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoDriveDistanceC extends Command {

	double autospeed;
	
	public AutoDriveDistanceC() {
    	requires(Robot.drivebase);
		autospeed = RobotMap.AUTO_SPEED * Math.signum(RobotMap.AUTO_DISTANCE);  
		// Math.sigma returns -1, 0, or 1 depending on sign of autodistance
	}
	
    protected void initialize() {
    	Robot.drivebase.resetEncoder();
    	System.out.println("init autodistance");
    }

    protected void execute() {
    	SmartDashboard.putNumber("Speed in AutoDistance", (autospeed));
    	Robot.drivebase.arcadeDrive((autospeed), 0, 0); // drive straight 
    }

    protected boolean isFinished() {
    	SmartDashboard.putNumber("DistanceTraveled", 
    			Robot.drivebase.getDistanceTraveled());
        return (Math.abs(Robot.drivebase.getDistanceTraveled()) >= 
        		Math.abs(RobotMap.AUTO_DISTANCE));
    }

    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0, 0);
    	Robot.drivebase.resetEncoder();
    }

    protected void interrupted() {
    	end();
    }
}
