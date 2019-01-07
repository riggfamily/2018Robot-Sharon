package org.usfirst.frc.team6995.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

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