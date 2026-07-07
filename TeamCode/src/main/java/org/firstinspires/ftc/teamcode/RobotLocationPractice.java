package org.firstinspires.ftc.teamcode;

public class RobotLocationPractice {

    double angle;
    double x;
    double y;

    // constructor method
    public RobotLocationPractice(double angle) {
        this.angle = angle;
    }
    public double getHeading() {
        // this method normalizes robot heading between -180 & 180
        // this is useful for calculating turn angles, especially when crossing the 0,360 boundary



        double angle = this.angle;
        while (angle > 180) {
            angle -=360;
        }
        while (angle <= -180) {
            angle += 360;
        }
        return angle;
    }

    public void turnRobot(double angleChange) {
        angle += angleChange;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double getAngle() {
        return angle;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void changeX(double changeAmount) {
        x += changeAmount;
    }

    public void changeY(double changeAmount) {
        y+= changeAmount;
    }
    public double getY() {
        return y;
    }
    public void setY (double y) {
        this.y = y;
    }
}
