package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.DriveCommand;

@Config
@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends CommandOpMode {


    @Override
    public void initialize() {
        org.firstinspires.ftc.teamcode.commands.Subsystems.DriveSubsystem driveSystem = new org.firstinspires.ftc.teamcode.commands.Subsystems.DriveSubsystem(hardwareMap, "leftFront", "rightFront",
                "leftBack", "rightBack");
        register(driveSystem);

        GamepadEx driver1 = new GamepadEx(gamepad1);
        DriveCommand driveCommand = new DriveCommand(

                driveSystem, driver1::getLeftY, driver1::getLeftX, driver1::getRightX);


        driveSystem.setDefaultCommand(driveCommand);
        driver1.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenPressed(() -> driveSystem.setPowerLimit(0.5))
                .whenReleased(() -> driveSystem.setPowerLimit(1.0));
        driver1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenPressed(() -> driveSystem.setPowerLimit(0.2))
                .whenReleased(() -> driveSystem.setPowerLimit(1.0));
    }
}