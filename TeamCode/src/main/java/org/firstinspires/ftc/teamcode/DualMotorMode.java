package org.firstinspires.ftc.teamcode;

//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Dual Motor Mode", group = "Team 13463 (WLHS)")

public class DualMotorMode extends LinearOpMode {
    public void runOpMode() {
        //Creating vars for came controller input
        double GCx;
        double GCy;

        //updating the display called telemetry for user knowlege.
        telemetry.addData("Status", "Initializing");
        telemetry.update();

        //declaring motors
        //DcMotor Motor_Four = hardwareMap.get(DcMotor.class, "M4");
        //DcMotor Motor_Three = hardwareMap.get(DcMotor.class, "M3");
        DcMotor Right_Motor = hardwareMap.get(DcMotor.class, "M2");
        DcMotor Left_Motor = hardwareMap.get(DcMotor.class, "M1");

        //setting intial power = 0
        Right_Motor.setPower(0);
        Left_Motor.setPower(0);
        //Motor_Three.setPower(0);
        //Motor_Four.setPower(0);

        //updating telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //waiting for user to press start
        waitForStart();
        while (opModeIsActive()) {

            //setting game controller vars = to game controller inputs
            GCy = -gamepad1.right_stick_y;
            GCx = -gamepad1.right_stick_x;

            //THIS IS STUPID
            //declaring new vars with limits for controller
            double Left_Power = Math.min(Math.max(GCx+GCy, -1),1);
            double Right_Power = Math.min(Math.max(GCx-GCy,-1),1);
            //setting motor speed
            Left_Motor.setPower(Left_Power);
            Right_Motor.setPower(Right_Power);

            //updating display for user knowlege and debugging purposes
            telemetry.addData("Status", "Running");
            telemetry.addData("Right Stick Y: ", GCy);
            telemetry.addData("Right Stick X: ", GCx);
            telemetry.update();
            resetRuntime();
        }
        //after stop is pressed, informing user of program status
        telemetry.addData("Status: ", "Stopped");
        telemetry.update();
    }

}
