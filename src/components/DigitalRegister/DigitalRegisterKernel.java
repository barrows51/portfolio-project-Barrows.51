package components.DigitalRegister;

import components.standard.Standard;

/**
 * Kernel interface for a DigitalRegister component.
 *
 * <p>
 * A DigitalRegister models a fixed-width digital hardware register that stores
 * binary values. The kernel provides the minimal operations required to
 * manipulate individual bits within the register.
 * </p>
 *
 * @author William Barrows
 */
public interface DigitalRegisterKernel extends Standard<DigitalRegister> {

    /**
     * Sets the bit at the specified index to 1.
     *
     * @param index
     *            position of the bit
     * @requires 0 <= index < width
     * @updates this
     * @ensures the bit at position index is set to 1
     */
    void setBit(int index);

    /**
     * Clears the bit at the specified index to 0.
     *
     * @param index
     *            position of the bit
     * @requires 0 <= index < width
     * @updates this
     * @ensures the bit at position index is set to 0
     */
    void clearBit(int index);

    /**
     * Reports the value of the bit at the specified index.
     *
     * @param index
     *            position of the bit
     * @return true if the bit is 1, false otherwise
     * @requires 0 <= index < width
     * @ensures getBit = value of bit at index
     */
    boolean getBit(int index);

    /**
     * Reports the width of the register.
     *
     * @return number of bits in this register
     * @ensures width = number of bits stored in this register
     */
    int width();
}
