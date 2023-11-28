package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake {
    public static WPI_VictorSPX chain = new WPI_VictorSPX(0);
    public static WPI_VictorSPX intake = new WPI_VictorSPX(0);

    public static void back(){
    chain.set(0.05);
    }

    public static void take(){
        intake.set(0.6);
    }
}

