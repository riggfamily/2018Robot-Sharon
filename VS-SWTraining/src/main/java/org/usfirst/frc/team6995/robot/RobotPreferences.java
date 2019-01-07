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
public class RobotPreferences {

	// Distance to drive in auto
	public static double AutoDistance() {
		return Preferences.getInstance().getDouble("AUTO_DISTANCE", 50);
	}
	// Seconds to drive in auto
	public static double AutoTime() {
		return Preferences.getInstance().getDouble("AUTO_TIME", 5);
	}
    // Speed to drive in auto
	public static double AutoSpeed() {
		// Math.sigma returns -1, 0, or 1 depending on sign of autodistance
		return Preferences.getInstance().getDouble("AUTO_SPEED", 0.5) * Math.signum(AutoDistance());   
	}
	// Seconds to turn in auto
	public static double AutoTurnTime() {
		return Preferences.getInstance().getDouble("AUTO_TURN_TIME", 2); 
	}
    // Speed of cube collecting;
	public static double GrabberCollectSpeed() {
		return Preferences.getInstance().getDouble("GRABBER_COLLECT_SPEED", 1.0);
	}

	// Speed of cube ejecting;
	  public static double GrabberEjectSpeed() {
		return Preferences.getInstance().getDouble("GRABBER_EJECT_SPEED", 1.0);
	}

	public static int BrakingCycles() {
		return Preferences.getInstance().getInt("BRAKING_CYCLES", 10);  
	}

	public static int UnbrakingCycles() {
		return Preferences.getInstance().getInt("UNBRAKING_CYCLES", 10);  
	}
	
	public static double LifterSpeedUp() {
		return Preferences.getInstance().getDouble("LIFTER_SPEED_UP", 0.5);    
	}
	
	public static double LifterSpeedDown() {
		return Preferences.getInstance().getDouble("LIFTER_SPEED_DOWN", -0.1);    
	}
	// Encoder Preferences
	
	public static boolean UseDrivebaseEncoderLeft() {
		return Preferences.getInstance().getBoolean("USE_DRIVEBASE_ENCODER_LEFT", true);  
	}

	public static boolean UseDrivebaseEncoderRight() {
		return Preferences.getInstance().getBoolean("USE_DRIVEBASE_ENCODER_RIGHT", true);  
	}		
}
