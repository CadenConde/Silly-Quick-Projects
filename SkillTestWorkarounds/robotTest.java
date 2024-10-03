
import java.awt.event.InputEvent;
import java.awt.Robot;
import java.awt.AWTException;
import java.io.IOException;

public class robotTest {
    public static void main(String[] args) throws IOException, AWTException {
        Robot robot = new Robot();
        robot.mouseMove(2500, 600);
        while (true) {
            if (robot.getPixelColor(2500, 600).getRGB() == -11805846) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.delay(1);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            }
        }
    }
}