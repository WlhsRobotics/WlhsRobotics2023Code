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
    DcMotor Right_Motor, Left_Motor, Turn_Table_Motor;
    Servo  webcam_rotation;
    
    public void runOpMode() {
        //Creating vars for came controller input
        double right_stick_x, right_stick_y, left_stick_x, left_stick_y;
        boolean rb, lb, A;
        
        //Mapping DcMotors and Servos
        Right_Motor = hardwareMap.get(DcMotor.class, "M2");
        Left_Motor = hardwareMap.get(DcMotor.class, "M1");
        
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
            
            resetRuntime();
        }
        
        //after stop is pressed, informing user of program status
        telemetry.addData("Status: ", "Stopped");
        telemetry.update();
    }

}
