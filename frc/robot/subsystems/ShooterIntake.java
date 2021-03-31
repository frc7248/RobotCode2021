// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterIntake extends SubsystemBase {
  CANSparkMax shooterIntake;

  /** Creates a new ShooterIntake. */
  public ShooterIntake() {
    shooterIntake = new CANSparkMax (6, MotorType.kBrushless);
    shooterIntake.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public void shooterIntakeBall(double speed) {
    shooterIntake.set(speed);
  }


  public void stop() {
    shooterIntake.set(0);
  }
}
