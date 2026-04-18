package components.digitalregister;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit tests for kernel methods of DigitalRegister1L.
 */
public class DigitalRegister1LTest {
    /**
     * Test constructor initializes all bits to 0.
     */
    @Test
    public void testConstructor() {
        DigitalRegister reg = new DigitalRegister1L(8);
        for (int i = 0; i < reg.width(); i++) {
            assertFalse(reg.getBit(i));
        }
    }

    /**
     * Test setBit sets a bit to 1.
     */
    @Test
    public void testSetBit() {
        DigitalRegister reg = new DigitalRegister1L(8);
        reg.setBit(3);
        assertTrue(reg.getBit(3));
    }

    /**
     * Test clearBit sets a bit to 0.
     */
    @Test
    public void testClearBit() {
        DigitalRegister reg = new DigitalRegister1L(8);
        reg.setBit(4);
        reg.clearBit(4);
        assertFalse(reg.getBit(4));
    }

    /**
     * Test getBit does not modify state.
     */
    @Test
    public void testGetBitNoChange() {
        DigitalRegister reg = new DigitalRegister1L(8);
        DigitalRegister regCopy = new DigitalRegister1L(8);
        reg.getBit(2);
        assertEquals(regCopy, reg);
    }

    /**
     * Test width method.
     */
    @Test
    public void testWidth() {
        DigitalRegister reg = new DigitalRegister1L(16);
        assertEquals(16, reg.width());
    }

    /**
     * Test setting multiple bits.
     */
    @Test
    public void testMultipleBits() {
        DigitalRegister reg = new DigitalRegister1L(8);
        reg.setBit(1);
        reg.setBit(5);
        assertTrue(reg.getBit(1));
        assertTrue(reg.getBit(5));
        assertFalse(reg.getBit(0));
    }
}
