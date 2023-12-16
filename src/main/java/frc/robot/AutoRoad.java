package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoRoad {
    public static SendableChooser<String> m_chooser;
    public static final String Auto = "Auto";
    public static final String Default = "Default";
    public static  String m_autoSelected;
    public static Encoder enc = new Encoder(0, 1);
    public static AHRS gyro = new AHRS(SPI.Port.kMXP);

    public static Timer timer = new Timer();

    
    public static void init() {
        m_chooser = new SendableChooser<String>();
        chooser_setting();
    }

    public static void chooser_setting() {
        m_chooser.setDefaultOption("Default", Default);
        m_chooser.addOption("Auto", Auto);
        SmartDashboard.putData("Auto Route", m_chooser);
    }

    /*public static void start() {
        m_autoSelected = m_chooser.getSelected();
        timer.start();
    }
    */
    
    public static void loop() {
        switch (m_autoSelected) {
            case Auto:
                Auto();
                break;
            case Default:
                Default();
                break;
        }
    }

    public static void Default(){
        Base.R.set(0);
        Base.L.set(0);
    }

    public static void Auto(){
        while(enc.get()<7500){
            Base.R.set(0.7);
            Base.L.set(0.7);
        }
        enc.reset();
        if(gyro.getAngle()<90){
            Base.R.set(0.3);
            Base.L.set(-0.3);
        }
        while(enc.get()<11500){
            Base.R.set(0.7);
            Base.L.set(0.7);
        }
    }
}
