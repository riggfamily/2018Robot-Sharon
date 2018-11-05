/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6995.robot;

import org.usfirst.frc.team6995.robot.commands.GrabberArmCloseC;
import org.usfirst.frc.team6995.robot.commands.GrabberArmOpenC;
import org.usfirst.frc.team6995.robot.commands.GrabberWheelsCollectC;
import org.usfirst.frc.team6995.robot.commands.GrabberWheelsEjectC;

import edu.wpi.first.wpilibj.Preferences;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public boolean useencoder = true;
	// Talons
	public static final int DRIVEBASE_RIGHT_TALON_CAN_ID = 3;
	public static final int DRIVEBASE_RIGHTB_TALON_CAN_ID = 5;
	public static final int DRIVEBASE_LEFT_TALON_CAN_ID = 2;
	public static final int DRIVEBASE_LEFTB_TALON_CAN_ID = 4;
	
	// Sparks
	public static final int LIFTER_CAN_ID = 5;
	public static final int GRABBER_LEFT_CAN_ID = 7;
	public static final int GRABBER_RIGHT_CAN_ID = 8;  // this may be wrong since the wheels didn't move
	
	// Pneumatics
	public static final int GRABBER_ARM_PCM_ID = 1;
	public static final int LIFTER_BRAKE_PCM_ID = 0;
	public static final int LIFTER_BRAKE_PORT = 7;

	// Joysticks
	public static final int OI_JOYSTICK = 0;
	public static final int DRIVE_MOVE_AXIS = 1;
	public static final int DRIVE_LEFTRIGHT_AXIS = 0;
	public static final int DRIVE_ROTATE_AXIS = 2;
	// Joystick Buttons
	public static final int JB_GRABBER_ARM_CLOSE = 1;
	public static final int JB_GRABBER_ARM_OPEN = 2;
	public static final int JB_GRABBER_WHEELS_COLLECT = 4;
	public static final int JB_GRABBER_WHEELS_EJECT = 6;
	public static final int JB_LIFTER_DOWN = 11;
	public static final int JB_LIFTER_UP = 12;
	
	// Preferences	
	public static final double AUTO_DISTANCE =
			Preferences.getInstance().getDouble("AUTO_DISTANCE", -50);     // Distance to drive in auto
	public static final double AUTO_TIME = 
			Preferences.getInstance().getDouble("AUTO_TIME", 10);         // Seconds to drive in auto
	public static final double AUTO_SPEED = 
			Preferences.getInstance().getDouble("AUTO_SPEED", 0.5);       // Speed to drive in auto
	public static final double AUTO_TURN_TIME = 
			Preferences.getInstance().getDouble("AUTO_TURN_TIME", 5);       // Seconds to turn in auto
	public static final double GRABBER_COLLECT_SPEED = 
			Preferences.getInstance().getDouble("GRABBER_COLLECT_SPEED", 0.5);       // Speed of cube collecting;
	public static final double GRABBER_EJECT_SPEED = 
			Preferences.getInstance().getDouble("GRABBER_EJECT_SPEED", 0.5);       // Speed of cube ejecting;
	public static final int BRAKING_CYCLES = 
			Preferences.getInstance().getInt("BRAKING_CYCLES", 10);  
	public static final int UNBRAKING_CYCLES = 
			Preferences.getInstance().getInt("UNBRAKING_CYCLES", 10);  
	public static final double LIFTER_SPEED_UP = 
			Preferences.getInstance().getDouble("LIFTER_SPEED_UP", 0.75);  
	public static final double LIFTER_SPEED_DOWN =
			Preferences.getInstance().getDouble("LIFTER_SPEED_DOWN", -0.1);  

	// Encoder Preferences
	public static final boolean USE_DRIVEBASE_ENCODER_LEFT = 
			Preferences.getInstance().getBoolean("USE_DRIVEBASE_ENCODER_LEFT", true);
	public static final boolean USE_DRIVEBASE_ENCODER_RIGHT = 
			Preferences.getInstance().getBoolean("USE_DRIVEBASE_ENCODER_RIGHT", true);





		
		
}
