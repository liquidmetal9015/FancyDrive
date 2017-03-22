package org.usfirst.frc.team2682.robot.subsystems;

import org.usfirst.frc.team2682.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon rightMotors;
	Talon leftMotors;
	Joystick defaultStick;
	RobotDrive chassis;
	Encoder nCodeR;
	Encoder nCodeL;
	
	nCodeR = new Encoder(RobotMap.NCODER_1, RobotMap.NCODER_2, false, EncodingType.k4X);
	nCodeL = new Encoder(RobotMap.NCODEL_1, RobotMap.NCODEL_2, false, EncodingType.k4X);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

