package components.DigitalRegister;

/**
 * Secondary (abstract) implementation of DigitalRegister.
 *
 * This class implements all secondary methods using only the kernel methods.
 *
 * @author William Barrows
 */
public abstract class DigitalRegisterSecondary implements DigitalRegister {

    /**
     * Loads the bits of this register from the given integer value. Bit 0
     * corresponds to the least significant bit of {@code value}.
     *
     * @param value
     *            the integer value to load into this register
     */
    @Override
    public void loadFromInt(int value) {
        int w = this.width();

        // Clear existing bits
        this.clear();

        for (int i = 0; i < w; i++) {
            if ((value & (1 << i)) != 0) {
                this.setBit(i);
            }
        }
    }

    /**
     * Converts this register to an integer. Bit 0 is the least significant bit
     * in the resulting integer.
     *
     * @return the integer value corresponding to the bits in this register
     */
    @Override
    public int toInt() {
        int result = 0;

        for (int i = 0; i < this.width(); i++) {
            if (this.getBit(i)) {
                result += (1 << i);
            }
        }

        return result;
    }

    /**
     * Shifts all bits in this register one position to the left. The least
     * significant bit is cleared. Subclasses overriding this method should
     * preserve the shift behavior.
     */
    @Override
    public void shiftLeft() {
        int w = this.width();

        for (int i = w - 1; i > 0; i--) {
            if (this.getBit(i - 1)) {
                this.setBit(i);
            } else {
                this.clearBit(i);
            }
        }

        this.clearBit(0);
    }

    /**
     * Shifts all bits in this register one position to the right. The most
     * significant bit is cleared. Subclasses overriding this method should
     * preserve the shift behavior.
     */
    @Override
    public void shiftRight() {
        int w = this.width();

        for (int i = 0; i < w - 1; i++) {
            if (this.getBit(i + 1)) {
                this.setBit(i);
            } else {
                this.clearBit(i);
            }
        }

        this.clearBit(w - 1);
    }

    /**
     * Increments the value of this register by 1. If the register overflows, it
     * wraps around to zero. Uses only kernel methods and preserves the width of
     * the register.
     */
    @Override
    public void increment() {
        int i = 0;

        while (i < this.width() && this.getBit(i)) {
            this.clearBit(i);
            i++;
        }

        if (i < this.width()) {
            this.setBit(i);
        }
    }

    /**
     * Returns a binary string representation of this register. The string has
     * most-significant-bit to least-significant-bit order.
     *
     * @return a string representing the bits of this register
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = this.width() - 1; i >= 0; i--) {
            if (this.getBit(i)) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }

    /**
     * Compares this register with another object for equality. Returns true if
     * the other object is a DigitalRegister of the same width and all bits
     * match eactly.
     *
     * @param obj
     *            the object to compare with
     * @return true if {@code obj} is equal to this register
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DigitalRegister)) {
            return false;
        }

        DigitalRegister other = (DigitalRegister) obj;

        if (this.width() != other.width()) {
            return false;
        }

        for (int i = 0; i < this.width(); i++) {
            if (this.getBit(i) != other.getBit(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a hash code value for this register. The hash code is based on
     * the bits of the register. Definition of 'equals()' without corresponding
     * definition of 'hashCode() is part of the reason I added this.
     *
     * @return the hash code of this register
     */
    @Override
    public int hashCode() {
        int hash = 0;

        for (int i = 0; i < this.width(); i++) {
            if (this.getBit(i)) {
                hash = hash * 2 + 1; // shift left by 1 and add 1 for a set bit
            } else {
                hash = hash * 2; // shift left by 1 for a clear bit
            }
        }

        return hash;
    }
}
