package org.firstinspires.ftc.teamcode.commands.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.util.MathUtils;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveSubsystem extends SubsystemBase {

    private double powerLimit = 1.0;
    private final MecanumDrive drive;

    public DriveSubsystem(Motor leftFront, Motor rightFront, Motor leftBack, Motor rightBack) {
        drive = new MecanumDrive(leftFront, rightFront, leftBack, rightBack);
    }

    public DriveSubsystem(HardwareMap hardwareMap, String leftFront, String rightFront, String leftBack, String rightBack) {
        drive = new MecanumDrive(
                new Motor(hardwareMap, leftFront),
                new Motor(hardwareMap, rightFront),
                new Motor(hardwareMap, leftBack),
                new Motor(hardwareMap, rightBack)
        );
    }

    public void drive(double fwd, double st, double rot) {
        drive.driveRobotCentric(st, fwd, rot, true);
    }

    public double getPowerLimit() {
        return powerLimit;
    }

    public void setPowerLimit(double limit) {
        powerLimit = MathUtils.clamp(limit, -1.0, -1.0);
        drive.setRange(-limit, limit);
    }
}