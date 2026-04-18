import components.digitalregister.DigitalRegister;
import components.digitalregister.DigitalRegister1L;

/**
 * Demonstrates shifting and manual bit manipulation.
 */
public final class DigitalRegisterShiftDemo {
    /**
     * Width of the register in bits.
     */
    private static final int REGISTER_WIDTH = 8;

    /**
     * Initial value loaded into the register.
     */
    private static final int INITIAL_VALUE = 5;

    /**
     * Index of the most significant bit.
     */
    private static final int MSB_INDEX = 7;

    /**
     * Index of the least significant bit.
     */
    private static final int LSB_INDEX = 0;

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private DigitalRegisterShiftDemo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {

        DigitalRegister reg = new DigitalRegister1L(REGISTER_WIDTH);

        System.out.println("Bit Shift Demo:");
        System.out.println("---------------------");

        reg.loadFromInt(INITIAL_VALUE);
        System.out.println("Initial:     " + reg.toString()); // 00000101

        reg.shiftLeft();
        System.out.println("Shift left:  " + reg.toString()); // 00001010

        reg.shiftRight();
        System.out.println("Shift right: " + reg.toString()); // 00000101

        reg.setBit(MSB_INDEX);
        System.out.println("Set MSB:     " + reg.toString()); // 10000101

        reg.clearBit(LSB_INDEX);
        System.out.println("Clear LSB:   " + reg.toString()); // 10000100

        System.out.println("Final decimal value: " + reg.toInt()); // 132
    }
}
