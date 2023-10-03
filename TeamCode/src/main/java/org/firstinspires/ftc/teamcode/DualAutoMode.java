package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import org.checkerframework.checker.initialization.qual.Initialized;
//import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "DualAutoMode", group = "Team 13463 (WLHS)")
public class DualAutoMode extends LinearOpMode{
    @Override
    public void runOpMode() {
        ColorSensor Color1 = hardwareMap.get(ColorSensor.class, "Color1");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Blue", Color1.blue());
            telemetry.addData("Green", Color1.green());
            telemetry.addData("Red", Color1.red());
            telemetry.update();
        }
    }
}