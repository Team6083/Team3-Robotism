package frc.robot;

import edu.wpi.first.wpilibj.Servo;

public class Gate {
    public static Servo gate =new Servo(1);
    
    public static void Init(){
        gate.set(0);
        gate.setAngle(0);
    }
    
    
    public static void move(){if(Base.joy.getRawButton(0)==true){
        gate.set(0.5);//A
        gate.setAngle(90);
    }if(Base.joy.getRawButton(2)==true){
        gate.set(0.5);//X
        gate.setAngle(0);
    }
}   }