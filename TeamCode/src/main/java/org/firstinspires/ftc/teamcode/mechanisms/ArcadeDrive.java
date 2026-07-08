package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ArcadeDrive {
    private DcMotor frontLeftM, backLeftM, frontRightM, backRightM;

    public void init(HardwareMap hwMap) {
        frontLeftM = hwMap.get(DcMotor.class, "front_left_motor");
        backLeftM = hwMap.get(DcMotor.class, "back_left_motor");
        frontRightM = hwMap.get(DcMotor.class, "front_right_motor");
        backRightM = hwMap.get(DcMotor.class, "back_right_motor");

        frontLeftM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightM.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontLeftM.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftM.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void drive(double throttle, double spin) {
        double leftPower = throttle + spin;
        double rightPower = throttle - spin;
        double largest = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (largest > 1.0) {
            leftPower /= largest;
            rightPower /= largest;
        }

        frontLeftM.setPower(leftPower);
        frontRightM.setPower(rightPower);
        backLeftM.setPower(leftPower);
        backRightM.setPower(rightPower);
    }
}
