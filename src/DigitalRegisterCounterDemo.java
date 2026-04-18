/**
 * Demonstrates using DigitalRegister as a binary counter.
 */
public final class DigitalRegisterCounterDemo {
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

        DigitalRegister reg = new DigitalRegister1L(8);

        System.out.println("Binary Counter Demo:");
        System.out.println("---------------------");

        // Count from 0 to 15
        for (int i = 0; i < 16; i++) {
            System.out.println(
                    "Decimal: " + reg.toInt() + " | Binary: " + reg.toString());
            reg.increment();
        }
    }
}
