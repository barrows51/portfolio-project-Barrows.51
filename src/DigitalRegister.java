/**
 * Proof of concept implementation of a Digital Register system
 *
 * This class models a fixed-width digital hardware register. It supports
 * it-level manipulation as well as higher level operations such as shifting and
 * incrementing.
 */
public class DigitalRegister {

    /**
     * The fixed number of bits in this register.
     */
    private final int width;

    /**
     * The internal representation of the register bits. Index 0 represents the
     * least significant bit (LSB).
     */
    private boolean[] bits;

    /**
     * Constructs a register with the given width.
     *
     * @param width
     *            the number of bits in the register
     * @throws IlegalArgumentException
     *             if {@code width <= 0}
     */
    public DigitalRegister(int width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive.");
        }
        this.width = width;
        this.bits = new boolean[width];
    }

    /**
     * ------------------------------------------- kernel like methods.
     * -------------------------------------------
     */

    /**
     * Sets the bit at the specified index to 1.
     *
     * @param index
     *            the position of the bit to set
     * @throws IndexOutOfBoundsException
     *             if {@code index} is outside the valid range
     */
    public void setBit(int index) {
        this.checkIndex(index);
        this.bits[index] = true;
    }

    /**
     * Clears the bit at the specified index to 0.
     *
     * @param index
     *            the position of the bit to clear
     * @throws IndexOutOfBoundsException
     *             if {@code index} is outside the valid range
     */
    public void clearBit(int index) {
        this.checkIndex(index);
        this.bits[index] = false;
    }

    /**
     * Returns whether the bit at the specified index is set.
     *
     * @param index
     *            the position of the bit to inspect
     * @return {@code true} if the bit is 1, {@code false} otherwise
     * @throws IndexOutOfBoundsException
     *             if {@code index} is outside the valid range
     */
    public boolean getBit(int index) {
        this.checkIndex(index);
        return this.bits[index];
    }

    /**
     * Clears all bits in the register.
     */
    public void clear() {
        for (int i = 0; i < this.width; i++) {
            this.bits[i] = false;
        }
    }

    /**
     * -------------------------------------------- Secondary methods.
     * --------------------------------------------
     */

    /**
     * Loads the binary representation of the given integer value into the
     * register. If the value exceeds the register width, higher-order bits are
     * discarded.
     *
     * @param value
     *            the integer value to load into the register
     */
    public void loadFromInt(int value) {
        this.clear();
        for (int i = 0; i < this.width; i++) {
            if ((value & (1 << i)) != 0) {
                this.setBit(i);
            }
        }
    }

    /**
     * Converts the current bit pattern of this register into an integer.
     *
     * @return the integer representation of the register contents
     */
    public int toInt() {
        int value = 0;
        for (int i = 0; i < this.width; i++) {
            if (this.getBit(i)) {
                value |= (1 << i);
            }
        }
        return value;
    }

    /**
     * Shifts all bits one position to the left.
     */
    public void shiftLeft() {
        for (int i = this.width - 1; i > 0; i--) {
            this.bits[i] = this.bits[i - 1];
        }
        this.bits[0] = false;
    }

    /**
     * Shifts all bits one position to the right.
     */
    public void shiftRight() {
        for (int i = 0; i < this.width - 1; i++) {
            this.bits[i] = this.bits[i + 1];
        }
        this.bits[this.width - 1] = false;
    }

    /**
     * Increments the register value by 1 using binary carry logic.
     */
    public void increment() {
        for (int i = 0; i < this.width; i++) {
            if (!this.getBit(i)) {
                this.setBit(i);
                return;
            } else {
                this.clearBit(i);
            }
        }
        // I am going to ignore overflow for now
        // and leave it as wrap-around behavior.
    }

    /**
     * Utility methods.
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= this.width) {
            throw new IndexOutOfBoundsException("Invaild bit index.");
        }
    }

    /**
     * Returns a string representation of this register.
     *
     * @return a binary string representing the register contents
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = this.width - 1; i >= 0; i--) {
            sb.append(this.bits[i] ? "1" : "0");
        }
        return sb.toString();
    }

    /**
     * Main Method.
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("===== Digital Register Proof of Concept =====");

        DigitalRegister reg = new DigitalRegister(8);

        System.out.println("\nInitial register:");
        System.out.println(reg + " (int: " + reg.toInt() + ")");

        System.out.println("\nLoading value 13:");
        reg.loadFromInt(12);
        System.out.println(reg + " (int: " + reg.toInt() + ")");

        System.out.println("\nIncrementing:");
        reg.increment();
        System.out.println(reg + " (int: " + reg.toInt() + ")");

        System.out.println("\nShifting left:");
        reg.shiftLeft();
        System.out.println(reg + " (int: " + reg.toInt() + ")");

        System.out.println("\nSetting bit 7 manually:");
        reg.setBit(7);
        System.out.println(reg + " (int: " + reg.toInt() + ")");

        System.out.println("\nClearing register:");
        reg.clear();
        System.out.println(reg + " (int: " + reg.toInt() + ")");

        System.out.println("\n==== End of Demo ====");
    }
}
