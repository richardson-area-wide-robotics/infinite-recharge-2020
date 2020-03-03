package frc.robot.operatorInputs;

import frc.robot.commands.GyroTurnCommand;
import frc.robot.commands.PowerCellScoringCommandGroup;
import frc.robot.commands.ReorientToFieldCommand;
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
    controls.getDriveJoystickXButton().whenPressed(new GyroTurnCommand(gyro, drive, 180));
    controls.getDriveRightJoystickBumper().whenPressed(new GyroTurnCommand(gyro, drive, -90));
    controls.getDriveLeftJoystickBumper().whenPressed(new GyroTurnCommand(gyro, drive, 90));
    controls.getDriveJoystickBButton().whenPressed(new ReorientToFieldCommand(gyro, drive));
    controls.getOperatorJoystickAButton().whileHeld(new PowerCellScoringCommandGroup(drive, limelight, shooterSpeedController,
        hopperController, indexerController));
    controls.getOperatorJoystickYButton().whenPressed(new ElevatorMidpointCommand(climber));
    controls.getOperatorLeftStick().whenPressed(new ClimbingCommandGroup(climber));
    // //TODO reenable
  }
}