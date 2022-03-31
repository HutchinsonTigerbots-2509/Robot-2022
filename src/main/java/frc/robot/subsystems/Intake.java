// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //public VictorSPX lift = new VictorSPX(Constants.kIntakeMotorID);
  //public VictorSPX lift_0 = new VictorSPX(Constants.kIntakeMotorID_0);
  public WPI_VictorSPX Intake = new WPI_VictorSPX(Constants.kIntakeMotorID_1); /* For the intake, you were not using VictorSP motor controllers, you are using SPX
                                                              motor controllers. They use the CAN network and the com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX library.
                                                              This is how you set them up. - S. Collins */
  public WPI_TalonFX Conveyor = new WPI_TalonFX(Constants.kIntakeMotorID_0);

  public AnalogInput LightSensor = new AnalogInput(Constants.kLightSensor);

  public DoubleSolenoid IntakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  public double TimesRan = 0;
  
  
  //public WPI_TalonFX lift_1 = new WPI_TalonFX(Constants.kRearLeftID);

  //public Joystick stick = new Joystick(0); // TODO change this

  /** Creates a new Intake. */
  public Intake() {
    IntakeSolenoid.set(Value.kForward);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

/* When you set TalonFX motor controllers and VictorSRX motor controllers, you set them with the
  .set(controlMode, value). The control mode you will want for a constant running speed is ControlMode.PercentOutput.
*/
  public void ConveyorIn(double speed) {
    //lift.set(0.5);
    Conveyor.set(ControlMode.PercentOutput, -speed);
    //lift_1.set(ControlMode.PercentOutput, 0.5); 
    return;
  }

  public void ConveyorOut(double speed) {
    //lift.set(0.5);
    Conveyor.set(ControlMode.PercentOutput, speed);
    //lift_1.set(ControlMode.PercentOutput, 0.5); 
    return;
  }
  
  public void ConveyorStop() {
    //lift.set(0);
    Conveyor.set(ControlMode.PercentOutput, 0);
    //lift_1.set(ControlMode.PercentOutput, 0);
    return;
  }

  public void IntakeIn(double intakeSpeed){
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
    Intake.set(ControlMode.PercentOutput,runnerSpeed);
  }

  public void IntakeOff(){
    Intake.set(ControlMode.PercentOutput,0);
    return;
  }

  public void ToggleIntakeSolenoid() {
    IntakeSolenoid.toggle();
    TimesRan = TimesRan + 1;
    SmartDashboard.putNumber("Times ran", TimesRan);
    return;
  }

  //  public void RetractIntakeSolenoid() {
  //    IntakeSolenoid.set(Value.kReverse);
  //    return;
  //  }


}
