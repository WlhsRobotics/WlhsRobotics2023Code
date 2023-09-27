/**package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.eventloop.opmode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//@Override
@TeleOp(name = "FourMotorMode", group = "Team 13463 (WLHS)")
public class FourMotorMode extends LinearOpMode {
    @Override
    public void runOpMode() {
        //updating display
        telemetry.addData("Status", "Initializing");
        telemetry.update();
        //decaring new vars for game conroler
        double GCx;
        double GCy;

        //mapping hardware and creating 'virtual' motors
        DcMotor Motor_Four = hardwareMap.get(DcMotor.class, "M4");
        DcMotor Motor_Three = hardwareMap.get(DcMotor.class, "M3");
        DcMotor Motor_two = hardwareMap.get(DcMotor.class, "M2");
        DcMotor Motor_one = hardwareMap.get(DcMotor.class, "M1");

        //setting motor power to 0
        Motor_one.setPower(0);
        Motor_two.setPower(0);
        Motor_Three.setPower(0);
        Motor_Four.setPower(0);

        //updating display for user
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //waiting for user to press start
        waitForStart();
        while (opModeIsActive()) {

            //setting vars for controller = to controller data
            GCy = gamepad1.right_stick_y;
            GCx = gamepad1.right_stick_x;

            //setting power for motor = to controller data

            Motor_one.setPower(GCx);
            Motor_two.setPower(GCx);
            Motor_Three.setPower(GCy);
            Motor_Four.setPower(GCy);

            //updating display for user knowledge
            telemetry.addData("Status", "Running");
            telemetry.addData("Right Stick Y: ", GCy);
            telemetry.addData("Right Stick X: ", GCx);
            telemetry.update();
            resetRuntime();
        }
        telemetry.addData("Status: ", "Stopped");
        telemetry.update();
    }
}**/