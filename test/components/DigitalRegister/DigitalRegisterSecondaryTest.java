package components.digitalregister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        reg.increment(); // 0100
        assertEquals(4, reg.toInt());
    }

    /**
     * Test increment overflows and wraps to 0.
     */
    @Test
    public void testIncrementOverflow() {
        DigitalRegister reg = new DigitalRegister1L(3);
        reg.loadFromInt(7); // 111 = max value for 3-bit register
        reg.increment(); // overflows, all bits carry out, wraps to 000
        assertEquals(0, reg.toInt());
    }

    /**
     * Test shiftLeft moves bits one position left.
     */
    @Test
    public void testShiftLeft() {
        DigitalRegister reg = new DigitalRegister1L(4);
        reg.loadFromInt(1); // 0001
        reg.shiftLeft(); // 0010
        assertEquals(2, reg.toInt());
    }

    /**
     * Test shiftLeft drops the most significant bit when it shifts out.
     */
    @Test
    public void testShiftLeftDropsMSB() {
        DigitalRegister reg = new DigitalRegister1L(4);
        reg.loadFromInt(8); // 1000 - MSB is set
        reg.shiftLeft(); // MSB shifts out -> 0000
        assertEquals(0, reg.toInt());
    }

    /**
     * Test shiftRight moves bits one position right.
     */
    @Test
    public void testShiftRight() {
        DigitalRegister reg = new DigitalRegister1L(4);
        reg.loadFromInt(2); // 0010
        reg.shiftRight(); // 0001
        assertEquals(1, reg.toInt());
    }

    /**
     * Test shiftRight drops the least significant bit when it shifts out.
     */
    @Test
    public void testShiftRightDropsLSB() {
        DigitalRegister reg = new DigitalRegister1L(4);
        reg.loadFromInt(1); // 0001 - LSB is set
        reg.shiftRight(); // LSB shifts out -> 0000
        assertEquals(0, reg.toInt());
    }

    /**
     * Test loadFromInt correctly loads a value.
     */
    @Test
    public void testLoadFromInt() {
        DigitalRegister reg = new DigitalRegister1L(8);
        reg.loadFromInt(10);
        assertEquals(10, reg.toInt());
    }

    /**
     * Test toString returns correct binary string.
     */
    @Test
    public void testToString() {
        DigitalRegister reg = new DigitalRegister1L(4);
        reg.loadFromInt(5); // 0101
        assertEquals("0101", reg.toString());
    }

    /**
     * Test equals with matching registers.
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
     * Test equals with different values returns false.
     */
    @Test
    public void testNotEquals() {
        DigitalRegister reg1 = new DigitalRegister1L(8);
        DigitalRegister reg2 = new DigitalRegister1L(8);
        reg1.loadFromInt(7);
        reg2.loadFromInt(8);
        assertNotEquals(reg1, reg2);
    }
}
