/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6995.robot;


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
	
	// Sparks PWM
	public static final int LIFTER_PWM_ID = 5;
	public static final int GRABBER_LEFT_PWM_ID = 7;
	public static final int GRABBER_RIGHT_PWM_ID = 8;
	
	// Pneumatics
	public static final int GRABBER_ARM_PCM_ID = 1;
	public static final int LIFTER_BRAKE_PCM_ID = 1;  // changed from 0
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
}
