package org.firstinspires.ftc.teamcode;

//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/** @noinspection ALL*/
@TeleOp(name = "Manual Mode", group = "Team 13463 (WLHS)")

public class ManualMode extends LinearOpMode {
    //Declaring DcMotors and Servo vars
    DcMotor Left_Motor, Right_Motor, Arm_Motor_1, Arm_Motor_2;
    Servo  webcam_rotation, Grabber;
    
    public void runOpMode() {
        //Creating vars for came controller input
        double right_stick_x, right_stick_y, left_stick_x, left_stick_y;
        boolean rb, lb, A;
        
        //Mapping DcMotors and Servos
        Left_Motor = hardwareMap.DcMotor.get("Left_Drive");
        Right_Motor = hardwareMap.DcMotor.get("Right_Drive");
        Arm_Motor_1 = hardwareMap.DcMotor.get("Arm_1");
        Arm_Motor_2 = hardwareMap.DcMotor.get("Arm_2");
        Grabber = hardwareMap.Servo.get("Grab");
        
        //setting intial power for drive motors to 0
        Right_Motor.setPower(0);
        Left_Motor.setPower(0);
        
        //updating telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        //waiting for user to press start
        waitForStart();
        
        while (opModeIsActive()) {
            //setting game controller vars = to game controller inputs
            right_stick_x = -gamepad1.right_stick_x;
            right_stick_y = -gamepad1.right_stick_y;
            left_stick_x = gamepad1.left_stick_x;
            left_stick_y = gamepad1.left_stick_y;
            lb = gamepad1.left_bumper;
            rb = gamepad1.right_bumper;
            A = gamepad1.a;
            
            //declaring new vars with limits for controller
            double Left_Power = Math.min(Math.max(right_stick_x + right_stick_y, -1), 1);
            double Right_Power = Math.min(Math.max(right_stick_x - right_stick_y, -1), 1);
            
            //setting motor speed
            Left_Motor.setPower(Left_Power);
            Right_Motor.setPower(Right_Power);

            //checking for lb / rb inputs
            if (gamepad1.rb && )

            //changing gripper position
            
            resetRuntime();
        }
        
        //after stop is pressed, informing user of program status
        telemetry.addData("Status: ", "Stopped");
        telemetry.update();
    }

}
