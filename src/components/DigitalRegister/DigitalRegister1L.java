package components.digitalregister;

/**
 * {@code DigitalRegister1L} is a kernel implementation of the
 * {@code DigitalRegister} component using a boolean array representation.
 *
 * This implementation provides a fixed-width register where each position
 * represents a single binary digit (bit).
 *
 * @author William Barrows
 */
public final class DigitalRegister1L extends DigitalRegisterSecondary {

    /**
     * Representation of the register.
     */
    private boolean[] bits;

    /**
     * CONVENTION: bits is not null bits.length >= 0
     *
     * CORRESPONDENCE: This register represents a binary value where bits[i] is
     * the value of the bit at position i Index 0 represents the least
     * significant bit Index (bits.length - 1) represents the most significant
     * bit
     */

    /**
     * Creates a new {@code DigitalRegister1L} with the given width.
     *
     * @param width
     *            the number of bits in the register
     * @requires width >= 0
     * @ensures this.width() = width and all bits are 0
     */
    public DigitalRegister1L(int width) {
        this.bits = new boolean[width];
    }

    /**
     * Default constructor (creates a register of width 0).
     *
     * @ensures this.width() = 0
     */
    public DigitalRegister1L() {
        this.bits = new boolean[0];
    }

    @Override
    public void setBit(int index) {
        assert index >= 0 && index < this.bits.length : "Index out of bounds";
        this.bits[index] = true;
    }

    @Override
    public void clearBit(int index) {
        assert index >= 0 && index < this.bits.length : "Index out of bounds";
        this.bits[index] = false;
    }

    @Override
    public boolean getBit(int index) {
        assert index >= 0 && index < this.bits.length : "Index out of bounds";
        return this.bits[index];
    }

    @Override
    public int width() {
        return this.bits.length;
    }

    @Override
    public void clear() {
        this.bits = new boolean[this.bits.length];
    }

    @Override
    public DigitalRegister newInstance() {
        return new DigitalRegister1L(this.bits.length);
    }

    @Override
    public void transferFrom(DigitalRegister source) {
        assert source != null : "Source cannot be null";
        assert source instanceof DigitalRegister1L : "Wrong type";

        DigitalRegister1L localSource = (DigitalRegister1L) source;

        this.bits = localSource.bits;
        localSource.bits = new boolean[0];
    }
}
