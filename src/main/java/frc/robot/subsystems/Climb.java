// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climb extends SubsystemBase {
  public WPI_TalonFX Climber = new WPI_TalonFX(Constants.kClimberMotorID);
  

  public DoubleSolenoid ClimbSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  /** Creates a new Climb. */
  public Climb() {

    //Sets up the Motor to when at 0 not want to move
    Climber.setNeutralMode(NeutralMode.Brake);

    //Sets the solenoid to when starting be in the forward position
    ClimbSolenoid.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ClimbUp() {

    //Starts the Climber Motor to go upward when called
    Climber.set(ControlMode.PercentOutput, 1);
  }

  public void ClimbDown() {

    //Starts the Climber Motor to go downward when called
    Climber.set(ControlMode.PercentOutput, -1);
  }

  public void ClimbStop() {
    
    //Turns off the climber will run when needed to stop
    Climber.set(ControlMode.PercentOutput, 0);
  }

  public void ClimbSolenoidToggle() {

    //Causes the climber to move back and forth with the button will only work if set to a direct beforehand
    ClimbSolenoid.toggle();
  }
}
