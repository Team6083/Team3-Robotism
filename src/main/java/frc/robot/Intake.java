package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Intake {
    public static WPI_VictorSPX wheels = new WPI_VictorSPX(0);//rubber wheels
    public static WPI_VictorSPX intake = new WPI_VictorSPX(0);//intake structure

    public static void take(){
        wheels.set(0.6);
    }

    public static void forward(){//intake down
        intake.set(0.2);
    }
    
    public static void backward(){//intake up
        intake.set(-0.2);
    }
}

