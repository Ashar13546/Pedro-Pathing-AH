package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class GamepadPractice extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y / 2.0;
        // runs 50 times a second
        telemetry.addData("Lx", gamepad1.left_stick_x);
        telemetry.addData("Ly", speedForward);
        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("b button", gamepad1.b);
        telemetry.addData("Rx", gamepad1.right_stick_x);
        telemetry.addData("Ry", gamepad1.right_stick_y);
        telemetry.addData("difference x", (gamepad1.left_stick_x - gamepad1.right_stick_x));
        telemetry.addData("sum rear", (gamepad1.right_trigger + gamepad1.left_trigger));

    }
}
