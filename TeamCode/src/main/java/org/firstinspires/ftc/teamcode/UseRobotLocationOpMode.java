package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class UseRobotLocationOpMode extends OpMode {

    RobotLocationPractice robotL = new RobotLocationPractice(0);



    @Override
    public void init() {
        robotL.setAngle(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            robotL.turnRobot(0.1);
        }
        else if (gamepad1.b) {
            robotL.turnRobot(-0.1);
        }
        telemetry.addData("Heading", robotL.getHeading());
        telemetry.addData("Angle", robotL.getAngle());


        //--------------------------------------------------------------------------

        if (gamepad1.dpad_left) {
            robotL.changeX(0.1);
        }
        else if (gamepad1.dpad_right) {
            robotL.changeX(-0.1);
        }

        if (gamepad1.dpad_up) {
            robotL.changeY(-0.1);
        }
        else if (gamepad1.dpad_down) {
            robotL.changeY(0.1);
        }

        telemetry.addData("x", robotL.getX());
        telemetry.addData("y", robotL.getY());

    }
}
