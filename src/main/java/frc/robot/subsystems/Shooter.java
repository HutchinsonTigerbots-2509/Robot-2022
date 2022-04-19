// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  /** Starts up the shooter with the button its set to */
  public void Shoot() {
    shooterMotor.set(shootSpeed);
  }

  /** Starts up the shooter with the number called */
  public void Shoot(double shotSpeed) {
    shooterMotor.set(shotSpeed);
  }

  public void VelocityShoot(double shotVelocity) {
    shooterMotor.set(ControlMode.Velocity, 1000);
  }

  /** Stalls the shooter */
  public void ShootStall() {
    shooterMotor.set(.35);
  }

  /** Stops the shooter in emergency */
  public void ShootStop() {
    shooterMotor.set(0);
  }

  /** Sets the shot from right next to it (lowest) */
  public void ShootSpeed1() {
    shootSpeed = .35;
  }

  /** Sets the shot from mid field (2nd to lowest) */
  public void ShootSpeed2() {
    shootSpeed = .6;
  }

  /** Sets the Shot from our save zone (3rd to lowest) */
  public void ShootSpeed3() {
    shootSpeed = .7;
  }

  /** Sets the shot from back field (4th to lowest) */
  public void ShootSpeed4() {
    shootSpeed = .9;
  }

  /** Change the shot distance with a plate (Not used anymore) */
  public void FlapOut() {
    if (shooterDistance.get() < .5)
      flapperMotor.set(-.35);
    else
      FlapStop();
  }

  /** Change the shot distance with a plate (Not used anymore) */
  public void FlapIn() {
    if (shooterDistance.get() > .4)
      flapperMotor.set(.35);
    else
      FlapStop();
  }

  /** Stops the flapper (Not used anymore) */
  public void FlapStop() {
    flapperMotor.set(0);
  }

  /** Used incoders to put flaper to a position (Not used anymore) */
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
