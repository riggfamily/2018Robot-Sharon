/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6995.robot;

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
	public static final int DRIVEBASE_RIGHT_TALON_CAN_ID = 2;
	public static final int DRIVEBASE_LEFT_TALON_CAN_ID = 3;

	// Joysticks
	public static final int OI_JOYSTICK = 0;
	public static final int DRIVE_MOVE_AXIS = 1;
	public static final int DRIVE_ROTATE_AXIS = 0;
	
	// Encoders - Maybe use
	public static final boolean DRIVEBASE_ENCODER_LEFT = Preferences.getInstance().getBoolean("Use Left Encoder?", true);
	public static final boolean DRIVEBASE_ENCODER_RIGHT = Preferences.getInstance().getBoolean("Use Right Encoder?", false);
	
	// Preferences	
	public static final double AUTO_DISTANCE = Preferences.getInstance().getDouble("Auto Distance", -120); // Distance to drive in auto
	public static final double AUTO_TIME = Preferences.getInstance().getDouble("Auto Time", 10);;  // Seconds to drive in auto
	public static final double AUTO_SPEED = Preferences.getInstance().getDouble("Auto Speed", 0.5); // Speed to drive in auto
}
