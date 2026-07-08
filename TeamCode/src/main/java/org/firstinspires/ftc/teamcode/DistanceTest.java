package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchDistance;

@Disabled
@TeleOp
public class DistanceTest extends OpMode {
    TestBenchDistance benchD = new TestBenchDistance();

    @Override
    public void init() {
        benchD.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Distance",benchD.getDistance());
        if (benchD.getDistance() < 10) {
            telemetry.addLine("Too Close!");
        }
    }
}
