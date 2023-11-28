package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;



public class Base {
<<<<<<< HEAD
    public static VictorSP R = new VictorSP(0);
    public static VictorSP L = new VictorSP(1);
=======
    public static WPI_VictorSPX R = new WPI_VictorSPX(0);
    public static WPI_VictorSPX L = new WPI_VictorSPX(9);
>>>>>>> c8ec7c9051b564e43d143e6d8386e935185a5eaf
    public static Joystick joy = new Joystick(0);

    public static void move() {
        L.set(joy.getRawAxis(1) * 0.2);
        R.set(joy.getRawAxis(5) * 0.2);
    }

}
