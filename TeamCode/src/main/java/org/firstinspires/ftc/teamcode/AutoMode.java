package org.firstinspires.ftc.teamcode;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import org.checkerframework.checker.initialization.qual.Initialized;
//import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "AutoMode", group = "Team 13463 (WLHS)")
public class AutoMode<AprilTagAccess> extends LinearOpMode{
    private static final boolean USE_WEBCAM = true;

    @Override
    public void runOpMode() {
            April_Tag_Init();
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
    private void April_Tag_Init() {
        AprilTagProcessor aprilTag = new AprilTagProcessor.Builder()

                .build();
        VisionPortal.Builder builder = new VisionPortal.Builder();
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }
        builder.addProcessor(aprilTag);
        VisionPortal visionPortal = builder.build();
    }
}