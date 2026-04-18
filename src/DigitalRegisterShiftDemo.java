/**
 * Demonstrates shifting and manual bit manipulation.
 */
public final class DigitalRegisterShiftDemo {
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

        DigitalRegister reg = new DigitalRegister1L(8);

        System.out.println("Bit Shift Demo:");
        System.out.println("---------------------");

        // Load initial value
        reg.loadFromInt(5); // 00000101
        System.out.println("Initial:  " + reg.toString());

        // Shift left
        reg.shiftLeft();
        System.out.println("Shift left:  " + reg.toString());

        // Shift right
        reg.shiftRight();
        System.out.println("Shift right: " + reg.toString());

        // Manually set a bit
        reg.setBit(7);
        System.out.println("Set MSB:     " + reg.toString());

        // Clear a bit
        reg.clearBit(0);
        System.out.println("Clear LSB:   " + reg.toString());

        // Final integer value
        System.out.println("Final decimal value: " + reg.toInt());
    }
}
