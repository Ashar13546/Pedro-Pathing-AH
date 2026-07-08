package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
import org.firstinspires.ftc.teamcode.mechanisms.TestBenchIMU;

@Disabled
@TeleOp
public class ImuPractice extends OpMode {

    TestBenchIMU bench = new TestBenchIMU();
    TestBench benchMotor = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);
        benchMotor.init(hardwareMap);
    }

    @Override
    public void loop() {
        double heading = bench.getHeading(AngleUnit.DEGREES);
        telemetry.addData("Heading", bench.getHeading(AngleUnit.DEGREES));
        if (heading < 0.5 && heading > -0.5) {
            benchMotor.setMotorSpeed(0.0);
        }
        else if (heading > 0.5) {
            benchMotor.setMotorSpeed(0.5);
        }
        else {
            benchMotor.setMotorSpeed(-0.5);
        }
    }
}
