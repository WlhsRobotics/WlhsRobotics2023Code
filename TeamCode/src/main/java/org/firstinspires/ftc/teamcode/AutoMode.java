package org.firstinspires.ftc.teamcode;

import com.google.blocks.ftcrobotcontroller.runtime.AprilTagAccess;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import org.checkerframework.checker.initialization.qual.Initialized;
//import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "AutoMode", group = "Team 13463 (WLHS)")
public class AutoMode<AprilTagAccess> extends LinearOpMode{
    //this is a test
    @Override
    public void runOpMode() {
        //ColorSensor Color1 = hardwareMap.get(ColorSensor.class, "Color1");

        /*AprilTagAccess aprilTag = null;
        for (AprilTagDetection detection : aprilTag.getDetections())  {

            Orientation rot = Orientation.getOrientation(detection.rawPose.R, AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

            // Original source data
            double poseX = detection.rawPose.x;
            double poseY = detection.rawPose.y;
            double poseZ = detection.rawPose.z;

            double poseAX = rot.firstAngle;
            double poseAY = rot.secondAngle;
            double poseAZ = rot.thirdAngle;
        }*/

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