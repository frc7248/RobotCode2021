// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class SetDrivetrainSpeedCommand extends CommandBase {
  private final DriveTrain m_drivetrain;
  private final DoubleSupplier m_leftAxis;
  private final DoubleSupplier m_rightAxis;

  /** Creates a new SetDrivetrainSpeedCommand. */
  public SetDrivetrainSpeedCommand(DoubleSupplier leftAxis, DoubleSupplier rightAxis, DriveTrain driveTrain) {
    m_drivetrain = driveTrain;
    m_leftAxis = leftAxis;
    m_rightAxis = rightAxis;

    addRequirements(driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double SpeedMultiplier = .7;

    m_drivetrain.manualControl(-m_leftAxis.getAsDouble() * SpeedMultiplier,
        -m_rightAxis.getAsDouble() * SpeedMultiplier);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
