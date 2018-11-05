package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveArcadeC extends Command {

    public DriveArcadeC() {
    	requires(Robot.drivebase);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double moveSpeed = -Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVE_MOVE_AXIS);
    	double leftRight = Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVE_LEFTRIGHT_AXIS);
    	double rotate = Robot.m_oi.joystick.getRawAxis(RobotMap.DRIVE_ROTATE_AXIS);
    	double throttle = Math.abs(Robot.m_oi.joystick.getThrottle());
    	Robot.drivebase.arcadeDrive(moveSpeed, leftRight, rotate, throttle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivebase.arcadeDrive(0, 0, 0, 0);
    }

    protected void interrupted() {
    	end();
    }
}
