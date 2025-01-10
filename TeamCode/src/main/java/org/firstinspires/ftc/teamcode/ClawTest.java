package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "Claw Test")
public class ClawTest extends LinearOpMode {

    private boolean IntakeClawClosed = false;
    private ElapsedTime ClawTime = new ElapsedTime();

    @Override
    public void runOpMode(){

        Servo IntakeClaw = hardwareMap.servo.get("Intake Claw");

        IntakeClaw.setPosition(0);

        waitForStart();
        while(opModeIsActive()){
            if (gamepad1.b && !IntakeClawClosed && ClawTime.seconds() >= .3){
                ClawTime.reset();
                IntakeClaw.setPosition(.5);
                IntakeClawClosed = true;
            }
            else if (gamepad1.b && IntakeClawClosed && ClawTime.seconds() >= .3){
                ClawTime.reset();
                IntakeClaw.setPosition(0);
                IntakeClawClosed = false;
            }
        }
    }
}
