package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.commands.DriveArcadeC;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DrivebaseS extends Subsystem {

	private WPI_TalonSRX driveLeft = null;
	private WPI_TalonSRX driveRight = null;
	private DifferentialDrive differentialDrive = null;
	
	public DrivebaseS() {
	
		driveLeft = new WPI_TalonSRX(RobotMap.DRIVEBASE_LEFT_TALON_CAN_ID);
		driveRight = new WPI_TalonSRX(RobotMap.DRIVEBASE_RIGHT_TALON_CAN_ID);
		differentialDrive = new DifferentialDrive(driveLeft, driveRight);
		
		driveLeft.setNeutralMode(NeutralMode.Brake);
		driveRight.setNeutralMode(NeutralMode.Brake);
		
		driveLeft.setSafetyEnabled(false);
		driveRight.setSafetyEnabled(false);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveArcadeC());
    }
    
    public void arcadeDrive(double moveSpeed,double rotateSpeed) {
    //	differentialDrive.arcadeDrive((moveSpeed*Robot.throttle), (rotateSpeed*Robot.throttle));
    	SmartDashboard.putNumber("Throttle in arcadeDrive", (Robot.throttle));
    	differentialDrive.arcadeDrive((moveSpeed), (rotateSpeed));
    }    
    
    
	public double getEncoderCount() {
		double encoderLeftCount = driveLeft.getSensorCollection().getQuadraturePosition();
		double encoderRightCount = driveRight.getSensorCollection().getQuadraturePosition(); 
		
		SmartDashboard.putNumber("Left Encoder Count", encoderLeftCount);
		SmartDashboard.putNumber("Right Encoder Count", encoderRightCount);
		
		if(Math.abs(encoderLeftCount - encoderRightCount) < 5) {
			return ((encoderLeftCount + encoderRightCount)/2);
		}
		else if (RobotMap.DRIVEBASE_ENCODER_LEFT) {
			return encoderLeftCount;
		}
		return encoderRightCount;
	}
    
	public double getDistanceTraveled() {
		SmartDashboard.putNumber("getDistanceTraveled Encoder Count", getEncoderCount());
    	return (getEncoderCount() / (4096/(6*Math.PI)));  // 6pi inches per 4096 counts - How did we figure this out?
    }
    
    public void resetEncoder() {
    	driveLeft.getSensorCollection().setQuadraturePosition(0, 500); // encoder on Talon
    	// driveEncoders.reset();  // encoder on roboRIO
    }
}