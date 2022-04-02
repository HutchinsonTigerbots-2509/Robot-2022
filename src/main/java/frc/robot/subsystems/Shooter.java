// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  public WPI_TalonFX shooterMotor = new WPI_TalonFX(Constants.kShooterMotorID);
  public WPI_TalonSRX flapperMotor = new WPI_TalonSRX(Constants.kFlapperMotorID);

  public AnalogEncoder shooterDistance = new AnalogEncoder(new AnalogInput(Constants.kShooterDistance));
  public double flapGoalPosition = (Constants.kFlapGoalPosition / 10);
  public double shootSpeed = Constants.kShootingSpeed;
  
  /** Creates a new Shooter. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Shoot() {
    //shooterMotor.set(SmartDashboard.getNumber("Shooter Speed", 0));
    shooterMotor.set(shootSpeed);
  }

  public void Shoot(double shotSpeed) {
    shooterMotor.set(shotSpeed);
  }

  public void ShootStall() {
    shooterMotor.set(.4);
  }

  public void ShootStop() {
    shooterMotor.set(0);
  }

  public void ShootSpeed1() {
    shootSpeed = .4;
  }

  public void ShootSpeed2() {
    shootSpeed = .6;
  }

  public void ShootSpeed3() {
    shootSpeed = .7;
  }

  public void ShootSpeed4() {
    shootSpeed = .9;
  }

  public void FlapOut() {
    if (shooterDistance.get() < .5)
      flapperMotor.set(-.35);
    else
      FlapStop();
  }

  public void FlapIn() {
    if (shooterDistance.get() > .4)
      flapperMotor.set(.35);
    else
      FlapStop();
  }

  public void FlapStop() {
    flapperMotor.set(0);
  }

public void FlapPosition() {
  if (shooterDistance.get() > flapGoalPosition)
    flapperMotor.set(.35);
  else
    if (shooterDistance.get() < flapGoalPosition)
      flapperMotor.set(-.35);
    else
      FlapStop();
}
  
}
