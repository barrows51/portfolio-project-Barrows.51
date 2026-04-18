package components.digitalregister;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit tests for secondary methods of DigitalRegister.
 */
public class DigitalRegisterSecondaryTest {

    /**
     * Test increment from zero.
     */
    @Test
    public void testIncrementFromZero() {
        DigitalRegister reg = new DigitalRegister1L(8);

        reg.increment();

        assertEquals(1, reg.toInt());
    }

    /**
     * Test increment with carry.
     */
    @Test
    public void testIncrementWithCarry() {
        DigitalRegister reg = new DigitalRegister1L(4);

        reg.loadFromInt(3); // 0011
        reg.increment(); // should be 0100

        assertEquals(4, reg.toInt());
    }

    /**
     * Test shiftLeft.
     */
    @Test
    public void testShiftLeft() {
        DigitalRegister reg = new DigitalRegister1L(4);

        reg.loadFromInt(1); // 0001
        reg.shiftLeft(); // 0010

        assertEquals(2, reg.toInt());
    }

    /**
     * Test shiftRight.
     */
    @Test
    public void testShiftRight() {
        DigitalRegister reg = new DigitalRegister1L(4);

        reg.loadFromInt(2); // 0010
        reg.shiftRight(); // 0001

        assertEquals(1, reg.toInt());
    }

    /**
     * Test loadFromInt.
     */
    @Test
    public void testLoadFromInt() {
        DigitalRegister reg = new DigitalRegister1L(8);

        reg.loadFromInt(10);

        assertEquals(10, reg.toInt());
    }

    /**
     * Test toString format.
     */
    @Test
    public void testToString() {
        DigitalRegister reg = new DigitalRegister1L(4);

        reg.loadFromInt(5); // 0101

        assertEquals("0101", reg.toString());
    }

    /**
     * Test equals method.
     */
    @Test
    public void testEquals() {
        DigitalRegister reg1 = new DigitalRegister1L(8);
        DigitalRegister reg2 = new DigitalRegister1L(8);

        reg1.loadFromInt(7);
        reg2.loadFromInt(7);

        assertEquals(reg1, reg2);
    }

    /**
     * Test equals with different values.
     */
    @Test
    public void testNotEquals() {
        DigitalRegister reg1 = new DigitalRegister1L(8);
        DigitalRegister reg2 = new DigitalRegister1L(8);

        reg1.loadFromInt(7);
        reg2.loadFromInt(8);

        assertEquals(false, reg1.equals(reg2));
    }

    /**
     * Test increment does not exceed width (overflow behavior).
     */
    @Test
    public void testIncrementOverflow() {
        DigitalRegister reg = new DigitalRegister1L(3);

        reg.loadFromInt(7); // 111
        reg.increment(); // depends on your design (likely wraps to 000)

        assertEquals(0, reg.toInt());
    }
}
