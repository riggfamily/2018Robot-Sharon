package org.usfirst.frc.team6995.robot.subsystems;

import org.usfirst.frc.team6995.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberArmS extends Subsystem {

    private static DoubleSolenoid grabberCylinder;
    
    public GrabberArmS() {
    	grabberCylinder = new DoubleSolenoid(1, 0, 1);  // robotmap definitions?
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void close() {
    	grabberCylinder.set(Value.kReverse);

    }
    
    public void open() {
    	grabberCylinder.set(Value.kForward);
    }
}

