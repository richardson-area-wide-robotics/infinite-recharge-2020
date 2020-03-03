package frc.robot.operatorInputs;

import frc.robot.commands.drivingCommands.GyroTurnCommand;
import frc.robot.commands.drivingCommands.ReorientToFieldCommand;
import frc.robot.commands.powerCellScoringCommands.PowerCellScoringCommandGroup;
import frc.robot.commands.climbingCommands.ClimbingCommandGroup;
import frc.robot.commands.climbingCommands.ElevatorMidpointCommand;
import frc.robot.commands.climbingCommands.ElevatorUpCommand;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.HopperController;
import frc.robot.subsystems.IndexerController;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.drive.Gyroscope;
import frc.robot.subsystems.shooter.ShooterSpeedController;
import frc.robot.subsystems.vision.Limelight;

public class OperatorInputs {

  public OperatorInputs(Controls controls, Drive drive, Gyroscope gyro, ShooterSpeedController shooterSpeedController,
      HopperController hopperController, IndexerController indexerController, Limelight limelight, Climber climber) {
    controls.getJoystickXButton().whenPressed(new GyroTurnCommand(gyro, drive, 180));
    controls.getRightJoystickBumper().whenPressed(new GyroTurnCommand(gyro, drive, -90));
    controls.getLeftJoystickBumper().whenPressed(new GyroTurnCommand(gyro, drive, 90));
    controls.getJoystickBButton().whenPressed(new ReorientToFieldCommand(gyro, drive));
    controls.getJoystickAButton().whileHeld(new PowerCellScoringCommandGroup(drive, shooterSpeedController,
        hopperController, indexerController, limelight));
    controls.getJoystickYButton().whenPressed(new ElevatorMidpointCommand(climber));
    controls.getLeftStick().whenPressed(new ClimbingCommandGroup(climber));
    // //TODO reenable
  }
}