package org.usfirst.frc.team6995.robot.commands;

import org.usfirst.frc.team6995.robot.Robot;
import org.usfirst.frc.team6995.robot.RobotMap;
import org.usfirst.frc.team6995.robot.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LifterC extends Command {
	public enum BrakeState {
		eBrakeStateUnbraked,
		eBrakeStateUnbraking,
		eBrakeStateBraking,
		eBrakeStateBraked,	
	};
	public BrakeState brakeState = BrakeState.eBrakeStateUnbraked;
	private int brakingCycles;
	private int unbrakingCycles;


    public LifterC() {
		this.setInterruptible(false);  
		requires(Robot.lifter);
    }

    protected void initialize() {
    	Robot.lifter.setSpeed(0);
    }

    protected void execute() {
    	int riserDirection;
		boolean riserUp = Robot.m_oi.joystick.getRawButton(RobotMap.JB_LIFTER_UP);
		boolean riserDn = Robot.m_oi.joystick.getRawButton(RobotMap.JB_LIFTER_DOWN);
	
		// Determine direction of movement
		if (riserUp && !riserDn) {
			System.out.println("lifterUp");
			riserDirection = 1;
			
		} 
		else if (!riserUp && riserDn) {
			System.out.println("lifterDown");
			riserDirection = -1;
		}
		else {
			riserDirection = 0;
			System.out.println("LifterStop");
		}
		// Allow time for the brake to be removed or applied without causing mechanical damage
    	switch (brakeState) {
		case eBrakeStateBraked:
			System.out.println("Case: Braked");
    		if (riserDirection != 0) {
            	brakeState = BrakeState.eBrakeStateUnbraking;
            	unbrakingCycles = RobotPreferences.UnbrakingCycles();  // Initialize our delay time
            	Robot.lifter.setBrake(false); // Remove brake
            	System.out.println("Unbraking");
            	
    		} else {
    			Robot.lifter.setBrake(true);  
				Robot.lifter.setSpeed(0); 
				System.out.println("set break/stop motor");
    		}
    		break;
		case eBrakeStateBraking:
			System.out.println("Case: Braking");
    		if (riserDirection != 0) {
    			brakeState = BrakeState.eBrakeStateUnbraked;
    		} else {
    			if (brakingCycles > 0) {
					brakingCycles -= 1;
				} else if (brakingCycles <= 0) {
					brakeState = BrakeState.eBrakeStateBraked;
				}
    		}
    		break;
    	case eBrakeStateUnbraked:
			System.out.println("Case: UnBraked");
			// Transition in to Unbraked state & apply power
		   if (riserDirection == 0) {
	    		// Transition to Braking
	    		brakeState = BrakeState.eBrakeStateBraking;
	        	brakingCycles = RobotPreferences.BrakingCycles(); 
	    		System.out.println("Braking");
	    		
	    	} else if (riserDirection > 0) {
	    		Robot.lifter.setSpeed(RobotPreferences.LifterSpeedUp());
		    	System.out.println("Going UP");
		        	
			} else if (riserDirection < 0) {
	    		Robot.lifter.setSpeed(RobotPreferences.LifterSpeedDown());
				System.out.println("Going Down");		
			} else /* going down normal rate */ {
	        	Robot.lifter.setSpeed(0);
		    	System.out.println("Going Down w/Gravity");
			}
     		break;
		case eBrakeStateUnbraking:
			System.out.println("Case: UnBraking");
    		if (riserDirection != 0) {
    			if (unbrakingCycles > 0) unbrakingCycles -= 1;
    			
    			if (unbrakingCycles <= 0) {
    				brakeState = BrakeState.eBrakeStateUnbraked;
    			}   	
    		} else {
    			brakeState = BrakeState.eBrakeStateBraking;
	        	brakingCycles = RobotPreferences.BrakingCycles();    		
    		}    		
		default:
			System.out.println("Case: Default-Do nothing");
    		// Do Nothing
    	}
    }

    protected boolean isFinished() {
        return false;  // should this be true?
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
