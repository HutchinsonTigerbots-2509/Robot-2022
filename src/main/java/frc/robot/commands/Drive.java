// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  private Drivetrain sDt;
  private double xSpeed, ySpeed, zSpeed;

  /** Creates a new Drive. */
  // public Drive(Drivetrain pDt, double pSpeed) {
  //   sDt = pDt;
  //   xSpeed = pSpeed;
  //   double ySpeed = 0;
  //   double zSpeed = 0;
    
  //   addRequirements(sDt);
  // }

  public Drive(Drivetrain pDt, double pSpeed) {
    sDt = pDt;
    xSpeed = pSpeed;
  }

  public Drive(Drivetrain pDt, double pxSpeed, double pySpeed, double pzSpeed) {
    sDt = pDt;
    xSpeed = pxSpeed;
    ySpeed = pySpeed;
    zSpeed = pzSpeed;
    
    addRequirements(sDt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    sDt.StraightDrive(xSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    sDt.StraightDrive(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
