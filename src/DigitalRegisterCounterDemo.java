import components.DigitalRegister.DigitalRegister;
import components.DigitalRegister.DigitalRegister1L;

/**
 * Demonstrates using DigitalRegister as a binary counter.
 */
public final class DigitalRegisterCounterDemo {
    /**
     * Width of the register in bits.
     */
    private static final int REGISTER_WIDTH = 8;

    /**
     * Number of values to count through.
     */
    private static final int COUNT_LIMIT = 16;

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private DigitalRegisterCounterDemo() {
    }

    /**
     * Main method.
     *
     * @param args
     *            command-line arguments
     */
    public static void main(String[] args) {

        DigitalRegister reg = new DigitalRegister1L(REGISTER_WIDTH);

        System.out.println("Binary Counter Demo:");
        System.out.println("---------------------");

        // Print current value first, then increment (shows 0 through 15)
        for (int i = 0; i < COUNT_LIMIT; i++) {
            System.out.println(
                    "Decimal: " + reg.toInt() + " | Binary: " + reg.toString());
            reg.increment();
        }
    }
}
