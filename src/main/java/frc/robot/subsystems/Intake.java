// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  // ***** Sets up the different motors, sensors, and the solenoid ***** //
  public WPI_VictorSPX Intake = new WPI_VictorSPX(Constants.kIntakeMotorID_1); 
  public WPI_TalonFX Conveyor = new WPI_TalonFX(Constants.kIntakeMotorID_0);
  public AnalogInput LightSensor = new AnalogInput(Constants.kLightSensor);
  public DoubleSolenoid IntakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  /** Creates a new Intake. */
  public Intake() {

    //Sets the defult solenoid for the Intakes
    IntakeSolenoid.set(Value.kForward);
  }

  public void IntakeSetAuto() {
    //Sets the default solenoid in the auto
    IntakeSolenoid.set(Value.kReverse);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

/* When you set TalonFX motor controllers and VictorSRX motor controllers, you set them with the
  .set(controlMode, value). The control mode you will want for a constant running speed is ControlMode.PercentOutput.
*/
  public void ConveyorIn(double speed) {

    //Moves the Conveyor in to push the ball into the shooter
    Conveyor.set(ControlMode.PercentOutput, -speed);
    return;
  }

  public void ConveyorOut(double speed) {

    //Moves the Conveyor out to push the ball out incase of ball getting stuck
    Conveyor.set(ControlMode.PercentOutput, speed);
    return;
  }
  
  public void ConveyorStop() {

    //Stops the Conveyor
    Conveyor.set(ControlMode.PercentOutput, 0);
    return;
  }

  public void IntakeIn(double intakeSpeed){

    //Makes the intake to pull the balls into the system
    if (LightSensor.getVoltage() < 0.5) {
      Intake.set(ControlMode.PercentOutput,intakeSpeed);
    } 
    else {
      Intake.set(ControlMode.PercentOutput,intakeSpeed);
      ConveyorIn(0.5);
    }
    return;
  }

  public void IntakeOut(double runnerSpeed){

    //Moves the Intake out if ball is stuck
    Intake.set(ControlMode.PercentOutput,runnerSpeed);
  }

  public void IntakeOff(){

    //Turns off intake
    Intake.set(ControlMode.PercentOutput,0);
    return;
  }

  public void ToggleIntakeSolenoid() {

    //Toggles the Intake Solenoid
    IntakeSolenoid.toggle();
    return;
  }

}
