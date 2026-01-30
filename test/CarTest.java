import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class CarTest {

    Saab95 saab;
    double initSpeed;

    Volvo240 volvo;

    @Before
    public void init() {
        saab = new Saab95();
        saab.startEngine();
        initSpeed = saab.currentSpeed;

        volvo = new Volvo240();
    }

    @Test
    public void testGas() {
        saab.gas(1);
        assertTrue(saab.currentSpeed > initSpeed);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGasFail() {
        saab.gas(2);
    }

    @Test
    public void testBreak() {
        saab.brake(1);
        assertTrue(saab.currentSpeed < initSpeed);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testBreakFail() {
        saab.brake(2);
    }

    @Test
    public void testTurnLeft() {
        saab.turnLeft();
        assertEquals(Direction.LEFT, saab.dir);
    }

    @Test
    public void testTurn360Degrees() {
        for (int i = 0; i < 4 ; i++) {
            saab.turnLeft();
        }
        assertEquals(Direction.FORWARD, saab.dir);
    }

    @Test
    public void testMoveForwards() {
        saab.move();
        assertTrue(saab.x == 10 && saab.y == 0);
    }

    @Test
    public void testMoveBackwards() {
        saab.turnLeft();
        saab.turnLeft();
        saab.move();
        assertTrue(saab.x == -10 && saab.y == 0);
    }

    @Test
    public void testMoveLeft() {
        saab.turnLeft();
        saab.move();
        assertTrue(saab.x == 0 && saab.y == 10);
    }

    @Test
    public void testMoveRight() {
        saab.turnRight();
        saab.move();
        assertTrue(saab.x == 0 && saab.y == -10);
    }


}