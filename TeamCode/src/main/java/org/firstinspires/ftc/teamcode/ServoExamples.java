package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchServo;

@Disabled
@TeleOp
public class ServoExamples extends OpMode {
    TestBenchServo bench = new TestBenchServo();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            bench.setServoPos(0.0);
        }
        else {
            bench.setServoPos(1.0);
        }
        if (gamepad1.b) {
            bench.setServoCon(1.0);
        }
        else {
            bench.setServoCon(0.0);
        }
        if (gamepad1.left_trigger > 0.0) {
            bench.setServoPos(gamepad1.left_trigger);
        }
        if (gamepad1.right_trigger > 0.0) {
            bench.setServoCon(gamepad1.right_trigger);
        }

    }
}
