package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.TestBenchColor;

@Disabled
@TeleOp
public class ColorSensorsTest extends OpMode {

    TestBenchColor benchC = new TestBenchColor();
    TestBenchColor.DetectedColor detectedColor;

    @Override
    public void init() {
        benchC.init(hardwareMap);
    }

    @Override
    public void loop() {
        detectedColor = benchC.getDetectedColor(telemetry);
        telemetry.addData("Color Detected", detectedColor);
    }
}
