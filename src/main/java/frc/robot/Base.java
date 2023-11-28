package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;



public class Base {
    public static WPI_VictorSPX R = new WPI_VictorSPX(0);
    public static WPI_VictorSPX L = new WPI_VictorSPX(9);
    public static Joystick joy = new Joystick(0);
    public static void move(){
        L.set(joy.getRawAxis(1)*0.2);
        R.set(joy.getRawAxis(5)*0.2);
    }



}
