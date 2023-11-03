package org.firstinspires.ftc.teamcode;

import android.graphics.Canvas;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.hardware.camera.controls.CameraControl;
import org.firstinspires.ftc.robotcore.internal.camera.calibration.CameraCalibration;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.opencv.core.Mat;

import java.util.ArrayList;
import java.util.List;

@TeleOp(name="AutoMode", group = "Main")

public class AutoMode extends LinearOpMode{
    //declaring Webcams
    private WebcamName Webcam1, Webcam2;
    //Declaring an Active Webcam for easy and setting it to Webcam 1 by default.
    WebcamName ActiveWebCam;
    //For Vison Portal as used AprilTagInitation
    private VisionPortal visionPortal;
    //Making April Tag var as used in multiple Methods
    private AprilTagProcessor aprilTag;
    public void runOpMode() {
        //Initiation for April Tag and Webcams
        AprilTagInitiation();
        telemetry.addData("Status: ","Initialized");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()){
            SwitchCamera();
            telemetryAprilTag();
            sleep(10000);
        }
    }
    //Creating Function for initiation of April Tag and Vision Processor
    private void AprilTagInitiation() {
        //Telling april tag to build
        aprilTag = new AprilTagProcessor.Builder().build();
        //Mapping Webcams
        Webcam1 = hardwareMap.get(WebcamName.class, "Webcam1");
        Webcam2 = hardwareMap.get(WebcamName.class, "Webcam2");
        //Setting up Vision Portal
        visionPortal = new VisionPortal.Builder()
                .setCamera(ActiveWebCam)
                .addProcessor(aprilTag)
                .build();
    }
    //Creating Function for webcam switching
    public void SwitchCamera(){
        if (ActiveWebCam.equals(Webcam1)){
            ActiveWebCam=Webcam2;
        }
        else if (ActiveWebCam.equals(Webcam2)){
            ActiveWebCam=Webcam1;
        }
    }

    //for telling user about what is being dectected
    public void telemetryAprilTag() throws NullPointerException {
        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
            }
        }   // end for() loop

        // Add "key" information to telemetry
        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        telemetry.addLine("RBE = Range, Bearing & Elevation");

    }







}