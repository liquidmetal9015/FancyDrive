package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team2682.robot.commands.*;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon rightMotors;
	Talon leftMotors;
	RobotDrive chassis;
	Encoder nCodeR;
	Encoder nCodeL;
	
	
	WheelPackage right;
	WheelPackage left;
	
	
	public DriveTrain(){
		nCodeR = new Encoder(RobotMap.NCODER_1, RobotMap.NCODER_2, false, EncodingType.k4X);
		nCodeL = new Encoder(RobotMap.NCODEL_1, RobotMap.NCODEL_2, false, EncodingType.k4X);
		
		rightMotors = new Talon(RobotMap.RIGHT_MOTOR_PWM);
		leftMotors = new Talon(RobotMap.LEFT_MOTOR_PWM);
		
		right = new WheelPackage(rightMotors, nCodeR);
		left = new WheelPackage(leftMotors, nCodeL);
		
		chassis = new RobotDrive(left,right);
	}
	

	public RobotDrive getDrive(){
		return chassis;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive());
    }
    
    
    
}

