package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import io.github.oblarg.oblog.annotations.Config;

public class IndexerController {
    private final int CAN_ID = 8;

    private CANSparkMax controller;

    private double speed = 0.3;

    public IndexerController() {
        this.controller = new CANSparkMax(CAN_ID, MotorType.kBrushless);
    }

    public void intake() {
        this.controller.set(speed);
    }

    public void stop() {
        this.controller.set(0.0);
    }

    public void outtake() {
        this.controller.set(-speed);
    }

    @Config
    public void setSpeed(double speed){
        this.speed = speed;
        this.intake();
    }

}