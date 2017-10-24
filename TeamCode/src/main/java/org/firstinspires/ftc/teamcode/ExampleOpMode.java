package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
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
    Servo servoFlipper = null;

    @Override
    public void runOpMode() throws InterruptedException
    {
        InitRobot();

        waitForStart();

        while (opModeIsActive())
        {
            motorL.setPower(gamepad1.left_stick_y);
            motorR.setPower(gamepad1.right_stick_y);
        }

    }

    void InitRobot()
    {
        motorL = hardwareMap.get(DcMotor.class, "motorL");
        motorR = hardwareMap.get(DcMotor.class, "motorR");
        servoFlipper = hardwareMap.get(Servo.class, "servoFlipper");
    }
}
