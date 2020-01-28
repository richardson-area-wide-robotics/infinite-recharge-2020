// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.drive.Drive;

/**
 *
 */
public class AutonomousCommand extends Command {

    private Drive drive;
    double distance;
    double maxSpeed;
    double constant;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutonomousCommand(double distance, double maxSpeed, double constant, Drive drive) {

        this.distance = distance;
        this.maxSpeed = maxSpeed;
        this.constant = constant;
        this.drive = drive;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        System.out.println("Initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        System.out.println("executing");
        driveStraight(distance, maxSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        System.out.println("finished");
        return true;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }

    public void driveStraight(double distance, double maxSpeed) {
        drive.setBrakeMode();
        drive.resetEncoders();
        while (drive.getLeftEncoderDistance() < distance || drive.getRightEncoderDistance() < distance) {
            double error = drive.getLeftEncoderDistance() - drive.getRightEncoderDistance();
            double turnPower = error * .15;
            double fowardSpeed = maxSpeed - ((drive.getLeftEncoderDistance() / distance) * maxSpeed);
            System.out.println("forward speed: " + fowardSpeed);
            drive.arcadeDrive(-fowardSpeed, -turnPower);
        }
        drive.setRightSpeed(0);
        drive.setLeftSpeed(0);
    }
}
