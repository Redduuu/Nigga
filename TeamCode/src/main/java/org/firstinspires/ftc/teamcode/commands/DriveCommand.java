package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.commands.Subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {

    private final DriveSubsystem drive;
    private final DoubleSupplier forward, strafe, rotation;

    public DriveCommand(DriveSubsystem drive, DoubleSupplier forward, DoubleSupplier strafe, DoubleSupplier rotation) {
        this.drive = drive;
        this.forward = forward;
        this.strafe = strafe;
        this.rotation = rotation;
        addRequirements(drive);
    }


    @Override
    public void execute() {
        drive.drive(forward.getAsDouble(), strafe.getAsDouble(), rotation.getAsDouble());
    }
}