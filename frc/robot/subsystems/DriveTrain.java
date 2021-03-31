// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  CANSparkMax leftFront;
  CANSparkMax rightFront;
  CANSparkMax leftBack;
  CANSparkMax rightBack;
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  DifferentialDrive drivetrain;


  // drive train speed, set to 0.x for X% speed
  private final double drivetrainMultiplier = 1.0;


  /** Creates a new DriveTrain. */
  public DriveTrain() {
    leftFront = new CANSparkMax (8, MotorType.kBrushless);
    leftFront.setInverted(true);
    rightFront = new CANSparkMax (1, MotorType.kBrushless);
    rightFront.setInverted(true);
    leftBack = new CANSparkMax (2, MotorType.kBrushless);
    leftBack.setInverted(true);
    rightBack = new CANSparkMax (3, MotorType.kBrushless);
    rightBack.setInverted(true);


    leftMotors = new SpeedControllerGroup(leftFront, leftBack);
    rightMotors = new SpeedControllerGroup(rightFront, rightBack);
    drivetrain = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void manualControl(double rawAxis, double rawAxis2) {
    drivetrain.tankDrive(rawAxis * drivetrainMultiplier, rawAxis2 * drivetrainMultiplier);
    

  }
}