package components.digitalregister;

/**
 * Enhanced interface for the DigitalRegister component.
 *
 * <p>
 * This interface provides higher-level register operations layered on top of
 * the DigitalRegisterKernel operations.
 * </p>
 *
 * @author William Barrows
 */
public interface DigitalRegister extends DigitalRegisterKernel {
    /**
     * Loads the binary representation of an integer into the register.
     *
     * @param value
     *            integer value to load
     * @updates this
     * @ensures this represents value modulo 2^width
     */
    void loadFromInt(int value);

    /**
     * Converts the current register value into an integer.
     *
     * @return integer representation of register contents
     * @ensures toInt = integer value represented by bits of this
     */
    int toInt();

    /**
     * Shifts all bits one position to the left.
     *
     * @updates this
     * @ensures bits shifted left and least significant bit becomes 0
     */
    void shiftLeft();

    /**
     * Shifts all bits one position to the right.
     *
     * @updates this
     * @ensures bits shifted right and most significant bit becomes 0
     */
    void shiftRight();

    /**
     * Increments the register value by one.
     *
     * @updates this
     * @ensures this = (old this + 1) modulo 2^width
     */
    void increment();
}
