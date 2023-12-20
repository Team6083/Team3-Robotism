package frc.robot;

import edu.wpi.first.wpilibj.Servo;

public class Gate {
    public static Servo gate =new Servo(1);
    
    public static void Init(){
        gate.set(0);
        gate.setAngle(0);
    }
    
    
    if(Base.joy.getRawbutton(0)==true){
        gate.set(0.5);//A
        gate.setAngle(90);
    }if(Base.joy.getRawbutton(2)==true){
        gate.set(0.5);//X
        gate.setAngle(0);
    }
}
