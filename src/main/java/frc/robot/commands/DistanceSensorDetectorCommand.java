/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.*;
import com.revrobotics.Rev2mDistanceSensor.Port;
import com.revrobotics.Rev2mDistanceSensor.Unit;


/**
 * Add your docs here.
 */
public class DistanceSensorDetectorCommand extends CommandBase{
    private Rev2mDistanceSensor distOnboard; 
    private final double DISTANCE_RANGE = 0.5;
    private double distance;
    public DistanceSensorDetectorCommand()
    {
        //Empty constructor might add more later
    }

    //Called just before this command runs for the first time
    @Override
    public void initialize() {
        distOnboard = new Rev2mDistanceSensor(Port.kOnboard);
        distOnboard.setAutomaticMode(true);
    }

    //Called and executes during the run
    @Override
    public void execute() {
        if(distOnboard.isRangeValid()) {
            distance = Double.valueOf(distOnboard.getRange());
            SmartDashboard.putNumber("Range Onboard", distance);
            SmartDashboard.putNumber("Timestamp Onboard", distOnboard.getTimestamp());
        }
        if(Math.abs(distOnboard.getRange(Unit.kInches) - 6.0) <= DISTANCE_RANGE){
            System.out.println("Is a ball");
        }

    }

}
