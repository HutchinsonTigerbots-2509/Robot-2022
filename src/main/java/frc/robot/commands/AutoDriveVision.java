// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimeLight;

public class AutoDriveVision extends CommandBase {
  private final Drivetrain m_Drivetrain;
  private LimeLight m_Vision;
  private double turn;
  private double X;
  private double Y;

  /** Creates a new DriveTele. */
  public AutoDriveVision(double x, double y, Drivetrain subsystem, LimeLight pVision) {
    m_Drivetrain = subsystem;
    m_Vision = pVision;
    X = x;
    Y = y;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Drivetrain);
    addRequirements(m_Vision);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_Vision.getTargetX() < 29) {turn = ((m_Vision.getTargetX() - 30) * .014) - .15;}
    else if (m_Vision.getTargetX() > 31) {turn = ((m_Vision.getTargetX() - 30) * .014) + .15;}
    else {turn = 0;}

    SmartDashboard.putNumber("x", m_Vision.getTargetX());

    m_Drivetrain.TeleMecDrive(
      Y,
      X,
      turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drivetrain.TeleMecDrive(0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
