// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  CANSparkMax leftShooter;
  CANSparkMax rightShooter;
  SpeedControllerGroup shooter;


  // shooter speed, set to 0.x for X% speed
  //private final double shooterMultiplier = 1.0;

  /** Creates a new Shooter. */
  public Shooter() {
    leftShooter = new CANSparkMax (5, MotorType.kBrushless);
    leftShooter.setInverted(false);
    rightShooter = new CANSparkMax (7, MotorType.kBrushless);
    rightShooter.setInverted(true);


    shooter = new SpeedControllerGroup(leftShooter, rightShooter);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  /**public void manualShoot (double leftShooter, double rightShooter) {
    shooter.setVoltage(leftShooter * shooterMultiplier);
    shooter.setVoltage(rightShooter * shooterMultiplier);
  }*/

  public void shootBall(double speed)
  {
    shooter.set(speed);
  }

  public void stop()
  {
    shooter.set(0);
  }

}
