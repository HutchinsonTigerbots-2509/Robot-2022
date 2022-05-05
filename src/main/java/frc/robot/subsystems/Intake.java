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
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogTriggerOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends SubsystemBase {

  // ***** Sets up the different motors, sensors, and the solenoid ***** //
  public WPI_VictorSPX Intake = new WPI_VictorSPX(Constants.kIntakeMotorID_1); 
  public WPI_TalonFX Conveyor = new WPI_TalonFX(Constants.kIntakeMotorID_0);
  public AnalogInput LightSensor = new AnalogInput(Constants.kLightSensor);
  public DoubleSolenoid IntakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

  /** Creates a new Intake. */
  public Intake() {

    //Sets the defult solenoid for the Intakes
    IntakeSolenoid.set(Value.kForward);
    LightSensor.resetAccumulator();
  }

  /** Sets the default solenoid in the auto */
  public void IntakeSetAuto() {
    IntakeSolenoid.set(Value.kReverse);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

/* When you set TalonFX motor controllers and VictorSRX motor controllers, you set them with the
  .set(controlMode, value). The control mode you will want for a constant running speed is ControlMode.PercentOutput.
*/

  /** Moves the Conveyor in to push the ball into the shooter */
  public void ConveyorIn(double speed) {
    Conveyor.set(ControlMode.PercentOutput, -speed);
    return;
  }

  /** Moves the Conveyor out to push the ball out incase of ball getting stuck */
  public void ConveyorOut(double speed) {
    Conveyor.set(ControlMode.PercentOutput, speed);
    return;
  }
  
  /** Stops the Conveyor */
  public void ConveyorStop() {
    Conveyor.set(ControlMode.PercentOutput, 0);
    return;
  }

  /** Moves the Intake so that the ball gets into the Conveyor */
  public void IntakeIn(){
    if (LightSensor.getVoltage() < .2) {
      Intake.set(ControlMode.PercentOutput,.8);
      Conveyor.set(ControlMode.PercentOutput, 0);
    } 
    if (LightSensor.getVoltage() >= .2) {
      Intake.set(ControlMode.PercentOutput,.8);
      Conveyor.set(ControlMode.PercentOutput, -.6);
    }
  }

  public void IntakeIn(double intakeSpeed){
      Intake.set(ControlMode.PercentOutput, intakeSpeed);
  }

  /** Moves the Intake out if ball is stuck */
  public void IntakeOut(double runnerSpeed){
    Intake.set(ControlMode.PercentOutput,runnerSpeed);
  }

  /** Turns off Intake */
  public void IntakeOff(){
    Intake.set(ControlMode.PercentOutput,0);
    return;
  }

  /** Toggles the Intake Solenoid to lift or drop*/
  public void ToggleIntakeSolenoid() {
    IntakeSolenoid.toggle();
    return;
  }
  
}
