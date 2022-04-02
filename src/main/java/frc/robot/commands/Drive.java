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

  //Makes the variables exist
  private Drivetrain sDt;
  private double xSpeed, ySpeed, zSpeed;

  public Drive(Drivetrain pDt, double pSpeed) {
    //Is called and inputs the variables to set them to forward speed and the drivetrain
    sDt = pDt;
    xSpeed = pSpeed;
    ySpeed = 0;
    zSpeed = 0;

    addRequirements(sDt);
  }

  public Drive(Drivetrain pDt, double pxSpeed, double pySpeed, double pzSpeed) {
    //Is called and inputs the variables to set them to all directions and the drivetrain
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

    //Calls the Drivetrain subsystem and calls AutoDrive with the speed input in Drive
    sDt.AutoDrive(xSpeed, ySpeed, zSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    //Calls the Drivetrain subsytem and calls AutoDrive With the speed of 0 stopping it
    sDt.AutoDrive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
