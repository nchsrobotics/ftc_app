package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by csteinbaugh on 10/10/2017.
 * Example OpMode to demonstrate the general order of commands in an OpMode
 */

@TeleOp(name = "Example")
public class ExampleOpMode extends LinearOpMode
{
    DcMotor motorL = null;
    DcMotor motorR = null;
    CRServo servoElevator = null;
    Servo servoArmL = null;
    Servo servoArmR = null;


    public void accelerate(double power, DcMotor mo, double acc)
    {
        while(mo.getPower() != power)
        {
            if (power > mo.getPower())
            {
                mo.setPower(mo.getPower() + acc);
            }
            else
            {
                mo.setPower(mo.getPower() - acc);
            }
        }
    }

    @Override
    public void runOpMode() throws InterruptedException
    {
        InitRobot();

        waitForStart();

        while (opModeIsActive())
        {
            accelerate(gamepad1.right_stick_y, motorR, -0.005);
            accelerate(gamepad1.right_stick_y, motorL, -0.005);
            String data = "Left Drive Input: " + gamepad1.left_stick_y + "; Right Drive Input: " + gamepad1.right_stick_y;
            telemetry.addData("Left Drive Input: ", gamepad1.left_stick_y);
            telemetry.addData("Right Drive Input: ", gamepad1.right_stick_y);
            telemetry.addData("Dpad Drive Input: ", gamepad1.dpad_up);
            telemetry.update();

            if (gamepad2.dpad_up)
            {
                servoElevator.setPower(1);
            }
            else if (gamepad2.dpad_down)
            {
                servoElevator.setPower(-1);
            }
            else
            {
                servoElevator.setPower(0);
            }
            if (gamepad2.left_bumper)
            {
                servoArmL.setPosition(0.7);
            }
            else if (gamepad2.left_trigger > 0)
            {
                servoArmL.setPosition(0.2);
            }
            if (gamepad2.right_bumper)
            {
                servoArmR.setPosition(0);
            }
            else if (gamepad2.right_trigger > 0)
            {
                servoArmR.setPosition(0.5);
            }



        }

    }

    void InitializePosition()
    {
        servoArmR.setPosition(0.5);
        servoArmL.setPosition(0.5);
    }

    void InitRobot()
    {
        motorL = hardwareMap.get(DcMotor.class, "motorL");
        motorR = hardwareMap.get(DcMotor.class, "motorR");
        servoElevator = hardwareMap.get(CRServo.class, "servoElevator");
        servoArmL = hardwareMap.get(Servo.class, "servoArmL");
        servoArmR = hardwareMap.get(Servo.class, "servoArmR");
        InitializePosition();
    }
}
