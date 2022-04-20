// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  // ***** Making Variables ***** //
  public double z;

  // ***** Setting up Motors ***** //
  public WPI_TalonFX frontRightMotor = new WPI_TalonFX(Constants.kFrontRightID);
  public WPI_TalonFX frontLeftMotor = new WPI_TalonFX(Constants.kFrontLeftID);
  public WPI_TalonFX rearRightMotor = new WPI_TalonFX(Constants.kRearRightID);
  public WPI_TalonFX rearLeftMotor = new WPI_TalonFX(Constants.kRearLeftID);

  //Putting all the motors into a Drivetrain
  public MecanumDrive drivetrain = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

  //Setting the start gear to highgear
  private double speedValue = Constants.kHighSpeed;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // ***** Inverts all the motors that need to be inverted ***** //
    frontRightMotor.setInverted(false);
    frontLeftMotor.setInverted(true);
    rearRightMotor.setInverted(false);
    rearLeftMotor.setInverted(true);

    // ***** Sets the motors to break when at 0 ***** //
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);

    GearUp();

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /** Runs the Drivetrain with driveCartesian with the values of the stick on the controller */
  public void MecDrive(Joystick stick) {
    drivetrain.driveCartesian(
      -stick.getRawAxis(Constants.kXboxLeftJoystickY) * speedValue,
      stick.getRawAxis(Constants.kXboxLeftJoystickX) * speedValue,
      stick.getRawAxis(Constants.kXboxRightJoystickX) * speedValue
      );
  }
  
  public void TeleMecDrive(double y, double x, double z) {
    drivetrain.driveCartesian(
      y * speedValue,
      x * speedValue,
      z * speedValue
      );
  }

  /** Drives the autonomous with the speed put into the AutoDrive */
  public void AutoDrive(double xSpeed, double ySpeed, double zSpeed) {
    drivetrain.driveCartesian(xSpeed, ySpeed, zSpeed);
  }

  /** Puts the gear down to be able to slow down driving */
  public void GearDown() {
    speedValue = Constants.kLowSpeed;
    return;
  }
  
  /** Puts the gear up to be able speed up driving */
  public void GearUp() {
    speedValue = Constants.kHighSpeed;
    return;
  }

public double GetSpeedValue() {
    return 0;
}

}
