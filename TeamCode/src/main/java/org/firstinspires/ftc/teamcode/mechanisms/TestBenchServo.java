package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestBenchServo {
    private Servo servoPos;
    private CRServo servoCon;

    public void init(HardwareMap hwMap) {
        servoPos = hwMap.get(Servo.class, "servo_pos");
        servoCon = hwMap.get(CRServo.class, "servo_con");
        servoPos.scaleRange(0.5,1.0);
        servoPos.setDirection(Servo.Direction.REVERSE);
        servoCon.setDirection(CRServo.Direction.REVERSE);
    }
    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }

    public void setServoCon(double power) {
        servoCon.setPower(power);
    }
}
