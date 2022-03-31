// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Conveyor extends SubsystemBase {
  public VictorSP conveyorMotor = new VictorSP(Constants.kConveyorMotorID);

  /** Creates a new Conveyor. */
  public Conveyor() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ConveyorIn() {
    conveyorMotor.set(-Constants.kMaxConveyorSpeed);
  }

  public void ConveyorStop() {
    conveyorMotor.set(0);
  }

  public void ConveyorReverse() {
    conveyorMotor.set(Constants.kMaxConveyorSpeed);
  }
}
