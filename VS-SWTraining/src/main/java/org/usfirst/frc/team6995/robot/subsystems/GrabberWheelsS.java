package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.RobotPreferences;

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
    	grabberWheelsLeft = new Spark(RobotMap.GRABBER_LEFT_PWM_ID);
    	grabberWheelsRight = new Spark(RobotMap.GRABBER_RIGHT_PWM_ID);
    		
		differentialDrive = new DifferentialDrive(grabberWheelsLeft, grabberWheelsRight);
		differentialDrive.setSafetyEnabled(false);	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new GrabberWheelsStopC());
    }
    
    public void collect() {
        grabberWheelsLeft.set(-RobotPreferences.GrabberCollectSpeed());
        grabberWheelsRight.set(RobotPreferences.GrabberCollectSpeed());
    }
    
    public void eject() {
        grabberWheelsLeft.set(RobotPreferences.GrabberEjectSpeed());
        grabberWheelsRight.set(-RobotPreferences.GrabberEjectSpeed());
    }

    public void stop() {
        grabberWheelsLeft.set(0);
        grabberWheelsRight.set(0);
    }
}

