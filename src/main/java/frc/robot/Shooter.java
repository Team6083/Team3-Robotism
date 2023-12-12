package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Shooter {
    public static WPI_VictorSPX shoot = new WPI_VictorSPX(0);
    
    public static void Shoot(){
        shoot.set(0.7);
    }

}
