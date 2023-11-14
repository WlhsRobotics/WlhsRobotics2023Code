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
        double GCrx;
        double GCry;
        double GCly;
        double GClx;
        boolean bGCrb;
        boolean bGClb;
        double GClb;
        double GCrb;
        boolean GC_A;
        
        //Mapping DcMotors and Servos
        Right_Motor = hardwareMap.get(DcMotor.class, "M2");
        Left_Motor = hardwareMap.get(DcMotor.class, "M1");
        
        //setting intial power for drive motors to 0
        Right_Motor.setPower(0);
        Left_Motor.setPower(0);

        //If we add front two drive motors
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
            bGClb = gamepad1.left_bumper;
            bGCrb = gamepad1.right_bumper;
            GC_A = gamepad1.a;
            
            //boolean to Double Conversion
            if (!bGClb) GClb = 0.0; else GClb = 1.0;
            if (!bGCrb) GCrb = 0.0; else GCrb = 1.0;
            
            //declaring new vars with limits for controller
            double Left_Power = Math.min(Math.max(GCrx+GCry, -1),1);
            double Right_Power = Math.min(Math.max(GCrx-GCry, -1),1);
            
            //setting motor speed
            Left_Motor.setPower(Left_Power);
            Right_Motor.setPower(Right_Power);
            
            //updating display for user knowlege and debugging purposes
            debug();
            
            resetRuntime();
        }
        //after stop is pressed, informing user of program status
        telemetry.addData("Status: ", "Stopped");
        telemetry.update();
    }

    
    public void debug extends runOpMode()
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
        telemetry.addData("Right Bumper: ", GCrb);
        telemetry.addData("Left Bumper: ", GCrb);
        telemetry.update();
    }
    
    public double superComplexFormula extends runOpMode()
    {
        GCry = 1;
    }

}
