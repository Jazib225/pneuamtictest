package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain {
    private CANSparkMax leftMotor, rightMotor;
    private SlewRateLimiter slewRateLeft;
    private DifferentialDrive drive;


    public Drivetrain() {
   leftMotor = new CANSparkMax(1, MotorType.kBrushless);
   rightMotor = new CANSparkMax(2, MotorType.kBrushless);

   slewRateLeft = new SlewRateLimiter(0.6);

   leftMotor.setInverted(true);
   rightMotor.setInverted(false);
   
  //Differential Drive
   drive = new DifferentialDrive(leftMotor, rightMotor);
}

  public void arcadeDrive(double leftY, double rightX) {
    drive.arcadeDrive(slewRateLeft.calculate(leftY), rightX);
}
}