package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.RobotPreferences;
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
	private WPI_TalonSRX driveLeftBack = null;
	private WPI_TalonSRX driveRight = null;
	private WPI_TalonSRX driveRightBack = null;
	private DifferentialDrive differentialDrive = null;
	
	public DrivebaseS() {
		driveLeft = new WPI_TalonSRX(RobotMap.DRIVEBASE_LEFT_TALON_CAN_ID);
		driveLeftBack = new WPI_TalonSRX(RobotMap.DRIVEBASE_LEFTB_TALON_CAN_ID);
		driveRight = new WPI_TalonSRX(RobotMap.DRIVEBASE_RIGHT_TALON_CAN_ID);
		driveRightBack = new WPI_TalonSRX(RobotMap.DRIVEBASE_RIGHTB_TALON_CAN_ID);
		
		driveLeftBack.follow(driveLeft);
		driveRightBack.follow(driveRight);
		
		driveLeft.setNeutralMode(NeutralMode.Brake);
		driveLeftBack.setNeutralMode(NeutralMode.Brake);
		driveRight.setNeutralMode(NeutralMode.Brake);
		driveRightBack.setNeutralMode(NeutralMode.Brake);
		
		driveLeft.setSafetyEnabled(false);
		driveLeftBack.setSafetyEnabled(false);
		driveRight.setSafetyEnabled(false);
		driveRightBack.setSafetyEnabled(false);
		
		differentialDrive = new DifferentialDrive(driveLeft, driveRight);
		differentialDrive.setSafetyEnabled(false);		
	}

    public void initDefaultCommand() {
        setDefaultCommand(new DriveArcadeC());
    }
    
    public void arcadeDrive(double moveSpeed,double leftRight, double rotate, double throttle) {
    	double rotateSpeed;
    	
    	//Combines both the X axis of the joystick and the rotation of the joystick.
    	if (Math.abs(leftRight) > Math.abs(rotate)) {
			rotateSpeed = leftRight;
		}
    	else if (Math.abs(leftRight) < Math.abs(rotate)) {
			rotateSpeed = rotate;
		}
    	else {
    		rotateSpeed = leftRight;
    	}

    	differentialDrive.arcadeDrive((moveSpeed*throttle), (rotateSpeed*throttle));
    }    
    
    
	public double getEncoderCount() {
		double encoderLeftCount = driveLeft.getSensorCollection().getQuadraturePosition();
		double encoderRightCount = driveRight.getSensorCollection().getQuadraturePosition(); 
		
//		System.out.println("getEncoderCount: L-" + encoderLeftCount + " R-" + encoderRightCount);
		SmartDashboard.putNumber("Left Encoder Count", encoderLeftCount);
		SmartDashboard.putNumber("Right Encoder Count", encoderRightCount);
		
		if((Math.abs(encoderLeftCount) - Math.abs(encoderRightCount)) < 5) {
	//		System.out.println("Use both Encoder Count" + (Math.abs(encoderLeftCount) + Math.abs(encoderRightCount)/2));
			return ((Math.abs(encoderLeftCount) - Math.abs(encoderRightCount))/2);
		}
		else if (RobotPreferences.UseDrivebaseEncoderLeft()) {
	//		System.out.println("Use Left Encoder Count" + encoderLeftCount);
			return encoderLeftCount;
		}
//		System.out.println("Use Right Encoder Count" + encoderRightCount);
		return encoderRightCount;
	}
    
	public double getDistanceTraveled() {
		SmartDashboard.putNumber("getDistanceTraveled Encoder Count", getEncoderCount());
    	return (getEncoderCount() / (4096/(6*Math.PI)));  // 6pi inches per 4096 counts     }
    
    public void resetEncoder() {
    	double encoderLeftCount;
		double encoderRightCount;
					
    	driveLeft.getSensorCollection().setQuadraturePosition(0, 1000); // encoder on Talon
    	driveRight.getSensorCollection().setQuadraturePosition(0, 1000); // encoder on Talon
    	
    	encoderLeftCount = driveLeft.getSensorCollection().getQuadraturePosition();
		encoderRightCount = driveRight.getSensorCollection().getQuadraturePosition(); 
		System.out.println("resetEncoder: L-" + encoderLeftCount + " R-" + encoderRightCount);
    	SmartDashboard.putNumber("Reset Left Encoder Count", encoderLeftCount);
		SmartDashboard.putNumber("Reset Right Encoder Count", encoderRightCount);
    }
}