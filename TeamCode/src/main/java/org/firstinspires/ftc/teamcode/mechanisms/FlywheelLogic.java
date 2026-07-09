package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class FlywheelLogic {
    private Servo gateServo;
    private CRServo flywheelServo;
    private ElapsedTime stateTimer = new ElapsedTime();

    private enum FlywheelState {
        IDLE,
        SPIN_UP,
        LAUNCH,
        RESET_GATE
    }

    private FlywheelState flywheelState;

    // -------------Gate Logic-----------
    private double GATE_CLOSE_ANGLE = 0;
    private double GATE_OPEN_ANGLE = 90;

    private double GATE_OPEN_TIME = 0.4;

    private double GATE_CLOSE_TIME = 0.4;

    //---------------Flywheel Constants-----------
    private int shotsRemaining = 0;
    private double flywheelVelocity = 0;
    private double MIN_FLYWHEEL_RPM = 1000;

    private double TARGET_FLYWHEEL_RPM = 1300;

    private double FLYWHEEL_MAX_SPINUP_TIME = 2;

    private void init(HardwareMap hwMap) {
        gateServo = hwMap.get(Servo.class, "servo");
        flywheelServo = hwMap.get(CRServo.class, "con_servo");


        flywheelState = FlywheelState.IDLE;

        flywheelServo.setPower(0);
        gateServo.setPosition(GATE_CLOSE_ANGLE);

    }

    public void update() {
        switch (flywheelState) {
            case IDLE:
                if (shotsRemaining > 0) {
                    gateServo.setPosition(GATE_CLOSE_ANGLE);
                    flywheelServo.setPower(TARGET_FLYWHEEL_RPM);

                    stateTimer.reset();
                    flywheelState = FlywheelState.SPIN_UP;
                }
                break;

            case SPIN_UP:

                if (flywheelVelocity > MIN_FLYWHEEL_RPM || stateTimer.seconds() > FLYWHEEL_MAX_SPINUP_TIME) {
                    gateServo.setPosition(GATE_OPEN_ANGLE);
                    stateTimer.reset();

                    flywheelState = FlywheelState.LAUNCH;
                }
                break;

            case LAUNCH:
                if (stateTimer.seconds() > GATE_OPEN_TIME) {
                    shotsRemaining--;
                    gateServo.setPosition(GATE_CLOSE_ANGLE);

                    stateTimer.reset();
                    flywheelState = FlywheelState.RESET_GATE;
                }
                break;

            case RESET_GATE:
                if (stateTimer.seconds() > GATE_CLOSE_TIME) {
                    if (shotsRemaining > 0) {
                        stateTimer.reset();
                        flywheelState = FlywheelState.SPIN_UP;
                    }
                    else {
                        flywheelServo.setPower(0);
                        flywheelState = FlywheelState.IDLE;
                    }
                }
                break;
        }
    }

    public void fireShots(int numShots) {
        if (flywheelState == FlywheelState.IDLE) {
            shotsRemaining = numShots;
        }
    }

    public boolean isBusy() {
        return flywheelState != FlywheelState.IDLE;
    }
}
