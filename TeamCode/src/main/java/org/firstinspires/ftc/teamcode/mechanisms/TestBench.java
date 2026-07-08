package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DigitalChannel touchSensor;
    private DcMotor motor;
    private double ticksPerRev;

    public void init(HardwareMap hwMap) {
        // touch sensor
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor"); // second statement should match configuration on driver hub
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

        // DC motor
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    // ------Touch Sensor-------

    public boolean IsTouchSensorPressed() {
        return !touchSensor.getState();
    }
    public boolean IsTouchSensorReleased() {
        return touchSensor.getState();
    }

    // --------DC Motor--------

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }


    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev;
    }

    public void setMotorBehavior(DcMotor.ZeroPowerBehavior zeroBehavior) {
        motor.setZeroPowerBehavior(zeroBehavior);
    }
}
