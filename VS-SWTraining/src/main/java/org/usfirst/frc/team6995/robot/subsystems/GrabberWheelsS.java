package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team6995.robot.commands.*;

/**
 *
 */
public class GrabberWheelsS extends Subsystem {

    private static Spark grabberWheelsLeft = null;
    private static Spark grabberWheelsRight = null;
    private static DifferentialDrive differentialDrive= null;
    
    public GrabberWheelsS() {
    	grabberWheelsLeft = new Spark(RobotMap.GRABBER_LEFT_CAN_ID);
    	grabberWheelsRight = new Spark(RobotMap.GRABBER_RIGHT_CAN_ID);
    		
		differentialDrive = new DifferentialDrive(grabberWheelsLeft, grabberWheelsRight);
		differentialDrive.setSafetyEnabled(false);	// ??	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GrabberWheelsStopC());
    }
    
    public void collect() {
    	differentialDrive.arcadeDrive((RobotMap.GRABBER_COLLECT_SPEED), 0);

    }
    
    public void eject() {
        differentialDrive.arcadeDrive((RobotMap.GRABBER_EJECT_SPEED), 0);
        
    }

    public void stop() {
        differentialDrive.arcadeDrive(0,0);
    }
}

