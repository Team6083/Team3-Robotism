package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class Base {
    public static VictorSP R = new VictorSP(0);
    public static VictorSP L = new VictorSP(9);
    public static Joystick joy = new Joystick(0);
    public static void move(){
        L.set(joy.getRawAxis(1)*0.2);
        R.set(joy.getRawAxis(5)*0.2);
    }



}
