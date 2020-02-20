package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.analog.adis16470.frc.ADIS16470_IMU;
import com.analog.adis16470.frc.ADIS16470_IMU.IMUAxis;

public class Gyroscope extends SubsystemBase {
    //Classes
    private ADIS16470_IMU imu;
    //variables
    private double startTime;
    private double driftPerSecond;
    
    public Gyroscope(){     
        this.imu = new ADIS16470_IMU();
        this.imu.setYawAxis(IMUAxis.kY);
        this.calibrate();
    }

    public double getGyroAngle(){
        double runTime = Timer.getFPGATimestamp() - startTime;
        double drift = runTime * driftPerSecond;
        return this.imu.getAngle() - drift;
    }

    public void resetGyro(){
        this.imu.reset();
        this.startTime = Timer.getFPGATimestamp();
    }

    public void calibrate(){
        this.startTime = Timer.getFPGATimestamp();   
        double startAngle = imu.getAngle();
        try{
            Thread.sleep(8000);
        }catch(Exception e)
        {
            //dont care about exceptions rn
        }
        this.driftPerSecond = (imu.getAngle() - startAngle)/(Timer.getFPGATimestamp() - startTime);
    }
}