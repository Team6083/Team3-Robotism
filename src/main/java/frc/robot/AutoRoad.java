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
    public static final String AutoTimer = "AutoTimer";
    public static final String Default = "Default";
    public static String m_autoSelected;
    public static Encoder encL = new Encoder(0, 1);
    public static Encoder encR = new Encoder(0, 2);
    public static AHRS gyro = new AHRS(SPI.Port.kMXP);
    public static Timer timer = new Timer();

    public static void init() {
        m_chooser = new SendableChooser<String>();
        chooser_setting();
        timer.reset();
    }

    public static void chooser_setting() {
        m_chooser.setDefaultOption("Default", null);
        m_chooser.addOption("Auto", Auto);
        m_chooser.addOption("AutoTimer", AutoTimer);
        SmartDashboard.putData("Auto Route", m_chooser);
    }

    public static void start() {
        m_autoSelected = m_chooser.getSelected();
        timer.start();
        timer.reset();

        step = 0;
    }

    public static void loop() {
        switch (m_autoSelected) {
            case Auto:
                Auto();
                break;
            case Default:
                Default();
                break;
            case AutoTimer:
                AutoTimer();
                break;
        }
    }

    static int step;

    public static void Auto() {
        switch (step) {
            case 0:
                Base.R.set(0.7);
                Base.L.set(0.7);

                if (encR.get() > 7500 && encL.get() > 7500) {
                    Base.R.set(0);
                    Base.L.set(0);

                    encL.reset();
                    encR.reset();
                    step++;
                }

                break;
            case 1:
                Base.R.set(0.3);
                Base.L.set(-0.3);
                if (gyro.getPitch() > 90) {
                    Base.R.set(0);
                    Base.L.set(0);
                    step++;
                }
                break;

            case 2:
                Base.R.set(0.7);
                Base.L.set(0.7);

                if (encR.get() > 11500 && encL.get() > 11500) {
                    Base.R.set(0);
                    Base.L.set(0);
                }
                break;

            default:
                break;
        }
    }

    public static void AutoTimer() {
        timer.start();
        if (timer.get() < 2) {
            Base.L.set(0.3);
            Base.R.set(-0.3);
        }
        timer.reset();
        if (timer.get() < 9) {
            Base.L.set(0.5);
            Base.R.set(0.5);
        }
        // Timer自動，未確定秒數、馬達轉速、正逆轉
    }

    public static void Default() {
        Base.R.set(0);
        Base.L.set(0);
    }
}
