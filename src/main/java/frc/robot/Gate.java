package frc.robot;

import edu.wpi.first.wpilibj.Servo;

public class Gate {
    public static Servo gateL = new Servo(1);
    public static Servo gateR = new Servo(2);

    public static void Init() {
        gateL.set(0);
        gateL.setAngle(0);
        gateR.set(0);
        gateR.setAngle(0);
    }

    public static void move() {
        if (Base.joy.getRawButton(0) == true) {
            gateL.set(0.5);// A
            gateL.setAngle(90);
            gateR.set(0.5);
            gateR.setAngle(90);
        }
        if (Base.joy.getRawButton(2) == true) {
            gateL.set(0.5);// X
            gateL.setAngle(0);
            gateR.set(0.5);
            gateR.setAngle(0);

        }
    }
}
