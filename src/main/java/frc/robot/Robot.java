// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    AutoRoad.init();
    Gate.Init();
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    AutoRoad.start();
  }

  @Override
  public void autonomousPeriodic() {
    AutoRoad.loop();
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    Base.move();
    if(Base.joy.getRawButtonPressed(6)==true){//RB
      Shooter.shootneg();
    }
    Gate.move();
    if(Base.joy.getRawButton(4)==true){//Y鍵
      Intake.forward();
    }else if(Base.joy.getRawButton(1)==true){//A鍵
      Intake.backward();
    }else if(Base.joy.getRawButtonPressed(5)==true){//LB
      Shooter.Shoot();
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
