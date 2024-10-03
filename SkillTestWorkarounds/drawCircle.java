import java.lang.Math;

import java.awt.event.InputEvent;
import java.awt.Robot;
import java.awt.AWTException;
import java.io.IOException;

public class drawCircle {
    public static void main(String[] args) throws IOException, AWTException {
        Robot robot = new Robot();

        int xCenter = 2720; // location on screen of dot
        int yCenter = 765;

        int distance = 200; // radius of circle

        // robot.mouseMove(xCenter, yCenter); //you could uncomment this and comment the
        // rest of the code to find where it thinks the center is /* */

        robot.mouseMove(xCenter + distance, yCenter); // actual program
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        for (int i = 0; i <= 370; i++) { // normally have to go slightly above 360 degrees
            int currentX = (int) Math.round(xCenter + distance * Math.cos(i * Math.PI / 180));
            int currentY = (int) Math.round(yCenter + distance * Math.sin(i * Math.PI / 180));
            robot.mouseMove(currentX, currentY);
            robot.delay(5); // change this to make it look more legit
        }
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}