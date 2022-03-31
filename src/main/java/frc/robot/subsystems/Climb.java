// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import java.util.ResourceBundle.Control;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.subsystems.Shooter;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  public WPI_VictorSPX Climber = new WPI_VictorSPX(Constants.kClimberMotorID);

  public DoubleSolenoid ClimbSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  /** Creates a new Climb. */
  public Climb() {
    ClimbSolenoid.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ClimbUp() {
    Climber.set(ControlMode.PercentOutput, 1);
  }

  public void ClimbDown() {
    Climber.set(ControlMode.PercentOutput, -1);
  }

  public void ClimbStop() {
    Climber.set(ControlMode.PercentOutput, 0);
  }

  public void ClimbSolenoidToggle() {
    ClimbSolenoid.toggle();
  }
}
