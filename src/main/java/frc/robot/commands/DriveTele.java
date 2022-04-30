// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveTele extends CommandBase {
  private final Drivetrain m_Drivetrain;
  private Joystick m_joystick;

  /** Creates a new DriveTele. */
  public DriveTele(Joystick stick, Drivetrain subsystem) {
    m_Drivetrain = subsystem;
    m_joystick = stick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  //   m_Drivetrain.TeleMecDrive(
  //     -m_joystick.getRawAxis(Constants.kXboxLeftJoystickY),
  //     m_joystick.getRawAxis(Constants.kXboxLeftJoystickX),
  //     m_joystick.getRawAxis(Constants.kXboxRightJoystickX));
  // }

    m_Drivetrain.TeleMecDrive(
      -m_joystick.getRawAxis(Constants.kXboxLeftJoystickY),
      m_Drivetrain.GetStrafeValue(m_joystick),
      m_joystick.getRawAxis(Constants.kXboxRightJoystickX));
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
