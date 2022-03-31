// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    
    // ***** Joystick ID's ***** //
    public final static int kOpStickID = 0;
    public final static int kCoopStickID = 2;

    // ***** Drivetrain Constants ***** //
    public final static int kFrontLeftID = 14; // Verified that the Motor Ids were set to the correct values 3/19/22
    public final static int kFrontRightID = 1; // Verified that the Motor Ids were set to the correct values 3/19/22
    public final static int kRearLeftID = 15; // Verified that the Motor Ids were set to the correct values 3/19/22
    public final static int kRearRightID = 2; // Verified that the Motor Ids were set to the correct values 3/19/22
    public final static double kHighSpeed = 0.6; // You are going to want to slow this down significantly, even for fast speed it is very high - S. Collins
    public final static double kLowSpeed = 0.3;

    // ***** Intake Constants ***** //
    public final static int kIntakeMotorID_0 = 11; //Motor ID for the front intake - S. COllins
    public final static int kIntakeMotorID_1 = 12; //Motor ID for the running intake to shooter - S.Collins
    public final static double kIntakeSpeed = .5;

    // ***** Shooter Constants ***** //
    public final static int kShooterMotorID = 13;
    public final static int kFlapperMotorID = 8;
    public final static int kShooterDistance = 5;
    public final static double kFlapGoalPosition = 24;
    public final static double kShootingSpeed = .6;      // Changed to .6 3/19/22  // <------------ TO CHANGE SHOOTING SPEED
    
    // ***** Conveyor Constants ***** //
    public final static int kConveyorMotorID = 12;
    public final static double kMaxConveyorSpeed = .75;
    public final static int kLightSensor = 1;

    // ***** Climb Constants ***** //
    public final static int kClimberMotorID = 3;


    //#region ***** Vision Constants ***** //

    // Network
    public final static String kLimelightIP = "10.25.9.11";        // IP Address of Camera
    public final static String kLimelightNetworkID = "limelight";  // Name of Camera on Network
    
    // Settings
    public final static int kLimelightLED = 0;                     // Sets LED. 0 = Set by Pipline, 1 = Force off, 2 = Force blink, 3 = Force on
    public final static int kLimelightMode = 0;                    // Sets camera mode. 0 = Vision processor, 1 = Driver Camera
    public final static int kLimelightStream = 0;                  // Sets streaming mode. 0 = Side-by-Side, 1 = PiP main, 2 = PiP secondary
    public final static int kLimelightStartingPipeline = 1;        // The default pipeline to stream

    // Table IDs (for getting values from the Network Table)
    public final static String kLimelightLatencyID = "tl";         // Pipeline latency in milliseconds
    public final static String kLimelightTargetID = "tv";          // Whether or not a valid target is found (0 or 1)
    public final static String kLimelightTargetXID = "tx";         // Horizontal offset from crosshair to target (+/- 27 degrees)
    public final static String kLimelightTargetYID = "ty";         // Vertical offset from crosshair to target (+/- 20.5 degrees)
    public final static String kLimelightTargetAreaID = "ta";      // Target area (0-100 % of image)
    public final static String kLimelightTargetSkewID = "ts";      // Target skew/rotation (-90 to 0 degrees)
    public final static String kLimelightTargetVertID = "tvert";   // Vertical sidelength of bounding box (0-320 pixels)
    public final static String kLimelightTargetHorID = "thor";     // Horizontal sidelength of bounding box (0-320 pixels)

    // Camera Variables
    public final static double kCameraHeight = 4;
    //public static double kCameraAngle = -28.23744554;
    public final static double kCameraAngle = -31.47286489;
    public final static double kTargetHeight = 31.5;
    public final static double kpAim = -0.02;
    public final static double kpDistance = -0.05;
    public final static double kmin_aim_command = -0.5;
    public final static double kdistance_command = -0.5;
    public final static double kTargetDistanceFromTarget = 24;
    //#endregion

    //#region ***** Xbox Controller Constants ***** //
    public final static int kXboxLeftJoystickX = 0;
    public final static int kXboxLeftJoystickY = 1;
    
    public final static int kXboxRightJoystickX = 4;
    public final static int kXboxRightJoystickY = 5;
    
    public final static int kXboxLeftJoystickButton = 9;
    public final static int kXboxRightJoystickButton = 10;

    public final static int kXboxLeftTrigger = 2;
    public final static int kXboxRightTrigger = 3;
    
    public final static int kXboxLeftBumper = 5;
    public final static int kXboxRightBumper = 6;
    
    public final static int kXboxButtonA = 1;
    public final static int kXboxButtonB = 2;
    public final static int kXboxButtonX = 3;
    public final static int kXboxButtonY = 4;
    
    //TODO Assign ID's for the Xbox DPad
    
    public final static int kXboxButtonBack = 7;
    public final static int kXboxButtonStart = 8;
    //#endregion

    //#region ***** Joystick Buttons ***** //
    public final static int kJoystickX = 0;
    public final static int kJoystickY = 1;
    public final static int kJoystickZ = 2;

    public final static int kJoystickSlider = 3;

    public final static int kJoystickButton1 = 1;
    public final static int kJoystickButton2 = 2;
    public final static int kJoystickButton3 = 3;
    public final static int kJoystickButton4 = 4;
    public final static int kJoystickButton5 = 5;
    public final static int kJoystickButton6 = 6;
    public final static int kJoystickButton7 = 7;
    public final static int kJoystickButton8 = 8;
    public final static int kJoystickButton9 = 9;
    public final static int kJoystickButton10 = 10;
    public final static int kJoystickButton11 = 11;
    public final static int kJoystickButton12 = 12;
}
