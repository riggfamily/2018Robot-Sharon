package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutonomousC extends CommandGroup {

    public AutonomousC() {  	
        addSequential(new AutoDriveStraightC());
        addParallel(new GrabberWheelsEjectC());
        addSequential(new AutoDriveTurnLeftC());
        
    }
}