/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6995.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team6995.robot.commands.*;

public class OI {
	public Joystick joystick = new Joystick(RobotMap.OI_JOYSTICK);
	
	Button JBGrabberArmClose = new JoystickButton(joystick, RobotMap.JB_GRABBER_ARM_CLOSE);
	Button JBGrabberArmOpen = new JoystickButton(joystick, RobotMap.JB_GRABBER_ARM_OPEN);
	Button JBGrabberWheelsCollect = new JoystickButton(joystick, RobotMap.JB_GRABBER_WHEELS_COLLECT);
	Button JBGrabberWheelsEject = new JoystickButton(joystick, RobotMap.JB_GRABBER_WHEELS_EJECT);
	Button JBLifterDown = new JoystickButton(joystick, RobotMap.JB_LIFTER_DOWN);
	Button JBLifterUp = new JoystickButton(joystick, RobotMap.JB_LIFTER_UP);
	
	public OI() {	
		JBGrabberArmClose.whileHeld(new GrabberArmCloseC());
		JBGrabberArmOpen.whileHeld(new GrabberArmOpenC());
		JBGrabberWheelsCollect.whileHeld(new GrabberWheelsCollectC());
		JBGrabberWheelsEject.whileHeld(new GrabberWheelsEjectC());
		JBLifterDown.whenPressed(new LifterC());  
		JBLifterUp.whenPressed(new LifterC());   
	}

}
