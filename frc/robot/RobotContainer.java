// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.SetDrivetrainSpeedCommand;
import frc.robot.commands.ShootBall;
import frc.robot.commands.ShooterIntakeBall;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterIntake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static DriveTrain driveTrain = new DriveTrain();
  public final Joystick joy0 = new Joystick(0);
  public final Joystick joy1 = new Joystick(1);

  private final Shooter shooter;
  private final ShootBall shootBall;

  private final ShooterIntake shooterIntake;
  private final ShooterIntakeBall shooterIntakeBall;

  private final Intake intake;
  private final IntakeBall intakeBall;





  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    driveTrain.setDefaultCommand(new SetDrivetrainSpeedCommand(() -> joy1.getRawAxis(1), () -> joy0.getRawAxis(1), driveTrain));

    shooter = new Shooter();
    shootBall = new ShootBall(shooter);
    shootBall.addRequirements(shooter);


    shooterIntake = new ShooterIntake();
    shooterIntakeBall = new ShooterIntakeBall(shooterIntake);
    shooterIntakeBall.addRequirements(shooterIntake);

    intake = new Intake();
    intakeBall = new IntakeBall(intake);
    intakeBall.addRequirements(intake);



    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    JoystickButton shootButton = new JoystickButton(joy0, 1);
    shootButton.whileHeld(new ShootBall(shooter));

    JoystickButton shooterIntakeButton = new JoystickButton(joy0, 3);
    shooterIntakeButton.whileHeld(new ShooterIntakeBall(shooterIntake));

    JoystickButton intakeBallButton = new JoystickButton(joy1, 1);
    intakeBallButton.whileHeld(new IntakeBall(intake));

  
  }

public Command getAutonomousCommand() {
	return null;
}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
    // An ExampleCommand will run in autonomous
}
