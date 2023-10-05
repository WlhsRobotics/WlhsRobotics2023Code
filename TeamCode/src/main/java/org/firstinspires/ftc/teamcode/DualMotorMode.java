package org.firstinspires.ftc.teamcode;

//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Dual Motor Mode", group = "Team 13463 (WLHS)")

public class DualMotorMode extends LinearOpMode {
    //Declaring DcMotors and Servo vars
    DcMotor Right_Motor, Left_Motor, Turn_Table_Motor;
    Servo Servo1;
    public void runOpMode() {
        //Creating vars for came controller input
        double GCrx;
        double GCry;
        double GCly;
        double GClx;
        //boolean GCrb;
        //boolean GClb;

        //updating the display called telemetry for user knowlege.
        telemetry.addData("Status", "Initializing");
        telemetry.update();
        //Mapping DcMotors and Servos
        //DcMotor Motor_Four = hardwareMap.get(DcMotor.class, "M4");
        //DcMotor Motor_Three = hardwareMap.get(DcMotor.class, "M3");
        Right_Motor = hardwareMap.get(DcMotor.class, "M2");
        Left_Motor = hardwareMap.get(DcMotor.class, "M1");
        Servo1 = hardwareMap.get(Servo.class, "S1");
        Turn_Table_Motor = hardwareMap.get(DcMotor.class, "M3");
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
            GCry = -gamepad1.right_stick_y;
            GCrx = -gamepad1.right_stick_x;
            GClx = gamepad1.left_stick_x;
            GCly = gamepad1.left_stick_y;
            //GClb = gamepad1.left_bumper;
            //GCrb = gamepad1.right_bumper;
            //THIS IS STUPID
            //declaring new vars with limits for controller
            double Left_Power = Math.min(Math.max(GCrx+GCry, -1),1);
            double Right_Power = Math.min(Math.max(GCrx-GCry,-1),1);
            //double Turn_Table_Motor_Power = Math.min(Math.max(GClb, -1),1);
            //setting motor speed
            Left_Motor.setPower(Left_Power);
            Right_Motor.setPower(Right_Power);
            //Turn_Table_Motor.setPower(Turn_Table_Motor_Power);
//this is annoying
            SetServoPositions(Servo1.getPosition() + (GCly-GClx));
            //updating display for user knowlege and debugging purposes
            {
                telemetry.addData("Status", "Running");
                telemetry.addData("Movement Stuff:", "");
                telemetry.addData("Right Stick Y: ", GCry);
                telemetry.addData("Right Stick X: ", GCrx);
                telemetry.addData("Servo Stuff:", "");
                telemetry.addData("Left Stick Y: ", GCly);
                telemetry.addData("Left Stick X: ", GClx);
                telemetry.addData("Servo Value", GCly-GClx);
                telemetry.addData("Turn Table Stuff:", "");
                //telemetry.addData("Right Bumper: ", GCrb);
                //telemetry.addData("Left Bumper: ", GCrb);
                //telemetry.addData("Turn Table Motor Value: ", Turn_Table_Motor_Power);
                telemetry.update();
            }
            resetRuntime();
        }
        //after stop is pressed, informing user of program status
        telemetry.addData("Status: ", "Stopped");
        telemetry.update();
    }
    /**Servos have min/max positions
    This method allows us to set servo positions and limits
     while still allowing us to use the servo in OPmode
    **/
     public void SetServoPositions(double Servo1Pos){
        Servo1.setPosition(Math.min(Math.max(Servo1Pos, -1), 1));
    }
}