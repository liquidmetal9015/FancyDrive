package org.usfirst.frc.team2682.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
/**
 *
 */
public class WheelPackage extends Subsystem implements PIDOutput, SpeedController {

	SpeedController motor;
	Encoder nCoder;

	PIDController control;

	double deadZone = 0.05;
	
	double maxSpeed;

	double outputValue;

	public WheelPackage(SpeedController a, Encoder b){
		motor = a;
		nCoder = b;
		nCoder.setPIDSourceType(PIDSourceType.kRate);
		control = new PIDController(0.0001,0,0,nCoder,this);
		control.setOutputRange(-1, 1);

		outputValue = 0;

	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}


	public double get(){
		return motor.get();
	}

	public void set(double in){
		if(control.isEnabled()){
			if(Math.abs(in) > deadZone){
				control.setSetpoint(in*maxSpeed);
			} else {
				control.setSetpoint(0);
			}
		} else {
			motor.set(in);
		}

	}

	public void stopMotor(){
		if(control.isEnabled()){
			control.setSetpoint(0);
		} else {
			motor.stopMotor();
		}
	}

	public void setInverted(boolean invert){
		motor.setInverted(invert);
		if(invert){
			nCoder.setReverseDirection(true);
		} else {
			nCoder.setReverseDirection(false);
		}
	}


	public void pidWrite(double input){
		outputValue += input;	
		motor.set(outputValue);

	}

	public void disable(){
		motor.disable();
	}

	public boolean getInverted(){
		return motor.getInverted();
	}
	
	public void setPIDEnabled(boolean enable){
		if(enable){
			control.enable();
		} else {
			control.disable();
		}
	}


}

