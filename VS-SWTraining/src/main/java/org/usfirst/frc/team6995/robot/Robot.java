/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6995.robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6995.robot.commands.*;
import org.usfirst.frc.team6995.robot.subsystems.*;


/** Sharon's Robot Code in Visual Code - Testing branches
 */
public class Robot extends TimedRobot {

// Subsystems
	public static DrivebaseS drivebase;
    public static GrabberArmS grabberArm;
    public static GrabberWheelsS grabberWheels;
	public static LifterS lifter;

// Output/Input 
	public static OI m_oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();  

	@Override
	public void robotInit() {
		drivebase = new DrivebaseS();
		grabberArm = new GrabberArmS();
		grabberWheels = new GrabberWheelsS();
		lifter = new LifterS();
		
		m_oi = new OI();
		
		m_chooser.addDefault("Auto by Time", new AutoDriveTimeC());
		m_chooser.addObject("Auto by Distance", new AutoDriveDistanceC());
		m_chooser.addObject("Autonomous MultiCommand", new AutonomousC());
		
		SmartDashboard.putData("Auto mode", m_chooser);
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		m_autonomousCommand = (Command) m_chooser.getSelected();
	
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		System.out.println("Tele Init autotime " + Preferences.getInstance().getDouble("autotime", 10));
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}
}
