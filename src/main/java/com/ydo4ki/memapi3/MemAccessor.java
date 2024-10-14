package com.ydo4ki.memapi3;

/**
 * Interface for accessing native memory.<br>
 * This interface is used to access native memory from java.<br>
 * All methods marked {@link Unchecked} if operation is unsafe.<br>
 * Store instances of this interface if static final fields to make jit forceinline these methods.
 *
 * @author Sulphuris
 * @since 11.10.2024 12:57
 */
@SuppressWarnings("unused")
public interface MemAccessor extends MemAllocatorManual {
	
	/**
	 * Returns boolean value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return boolean value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBoolean(long, boolean)
	 * @since 1.0
	 */
	boolean getBoolean(long _Addr) throws Unchecked;
	
	/**
	 * Returns boolean value from given memory address.<br>
	 * This method does the same as {@link MemAccessor#getBoolean(long)} and
	 * needed to avoid violating naming rules (for cases when the search for methods in this interface occurs by name)
	 *
	 * @param _Addr native memory address
	 * @return boolean value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBoolean(long)
	 * @see MemAccessor#putBoolean(long, boolean)
	 * @since 1.0
	 */
	default boolean getBooleanAligned(long _Addr) throws Unchecked {
		return getBoolean(_Addr);
	}
	
	/**
	 * Writes boolean value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  boolean value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBoolean(long)
	 * @since 1.0
	 */
	void putBoolean(long _Addr, boolean _Val) throws Unchecked;
	
	
	/**
	 * Writes boolean value to given memory address.<br>
	 * This method does the same as {@link MemAccessor#putBoolean(long, boolean)} and
	 * needed to avoid violating naming rules (for cases when the search for methods in this interface occurs by name)
	 *
	 * @param _Addr native memory address
	 * @param _Val  boolean value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBoolean(long)
	 * @see MemAccessor#putBoolean(long, boolean)
	 * @since 1.0
	 */
	default void putBooleanAligned(long _Addr, boolean _Val) throws Unchecked {
		putBoolean(_Addr, _Val);
	}
	
	
	/**
	 * Returns byte value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return byte value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putByte(long, byte)
	 * @since 1.0
	 */
	byte getByte(long _Addr) throws Unchecked;
	
	/**
	 * Returns byte value from given memory address.<br>
	 * This method does the same as {@link MemAccessor#getByte(long)} and
	 * needed to avoid violating naming rules (for cases when the search for methods in this interface occurs by name)
	 *
	 * @param _Addr native memory address
	 * @return byte value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getByte(long)
	 * @see MemAccessor#putByte(long, byte)
	 * @since 1.0
	 */
	default byte getByteAligned(long _Addr) throws Unchecked {
		return getByte(_Addr);
	}
	
	/**
	 * Writes byte value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  byte value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getByte(long)
	 * @since 1.0
	 */
	void putByte(long _Addr, byte _Val) throws Unchecked;
	
	/**
	 * Writes byte value to given memory address.<br>
	 * This method does the same as {@link MemAccessor#putByte(long, byte)} and
	 * needed to avoid violating naming rules (for cases when the search for methods in this interface occurs by name)
	 *
	 * @param _Addr native memory address
	 * @param _Val  byte value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getByte(long)
	 * @see MemAccessor#putByte(long, byte)
	 * @since 1.0
	 */
	default void putByteAligned(long _Addr, byte _Val) throws Unchecked {
		putByte(_Addr, _Val);
	}
	
	/**
	 * Returns short value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return short value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putShort(long, short)
	 * @see MemAccessor#getShortAligned(long)
	 * @since 1.0
	 */
	short getShort(long _Addr) throws Unchecked;
	
	/**
	 * Returns short value from given aligned memory address (address must be aligned by {@link Short#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return short value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getShort(long)
	 * @see MemAccessor#putShort(long, short)
	 * @see MemAccessor#putShortAligned(long, short)
	 * @since 1.0
	 */
	short getShortAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes short value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  short value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getShort(long)
	 * @see MemAccessor#putShortAligned(long, short)
	 * @since 1.0
	 */
	void putShort(long _Addr, short _Val) throws Unchecked;
	
	/**
	 * Writes short value to given aligned memory address (address must be aligned by {@link Short#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  short value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getShort(long)
	 * @see MemAccessor#putShort(long, short)
	 * @see MemAccessor#getShortAligned(long)
	 * @since 1.0
	 */
	void putShortAligned(long _Addr, short _Val) throws Unchecked;
	
	
	/**
	 * Returns char value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return char value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putChar(long, char)
	 * @see MemAccessor#getCharAligned(long)
	 * @since 1.0
	 */
	char getChar(long _Addr) throws Unchecked;
	
	/**
	 * Returns char value from given aligned memory address (address must be aligned by {@link Character#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return char value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getChar(long)
	 * @see MemAccessor#putChar(long, char)
	 * @see MemAccessor#putCharAligned(long, char)
	 * @since 1.0
	 */
	char getCharAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes char value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  char value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getChar(long)
	 * @see MemAccessor#putCharAligned(long, char)
	 * @see MemAccessor#getCharAligned(long)
	 * @since 1.0
	 */
	void putChar(long _Addr, char _Val) throws Unchecked;
	
	/**
	 * Writes char value to given aligned memory address (address must be aligned by {@link Character#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  char value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getChar(long)
	 * @see MemAccessor#putChar(long, char)
	 * @see MemAccessor#getCharAligned(long)
	 * @since 1.0
	 */
	void putCharAligned(long _Addr, char _Val) throws Unchecked;
	
	
	/**
	 * Returns int value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return int value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putInt(long, int)
	 * @see MemAccessor#getIntAligned(long)
	 * @since 1.0
	 */
	int getInt(long _Addr) throws Unchecked;
	
	/**
	 * Returns int value from given aligned memory address (address must be aligned by {@link Integer#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return int value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getInt(long)
	 * @see MemAccessor#putInt(long, int)
	 * @see MemAccessor#putIntAligned(long, int)
	 * @since 1.0
	 */
	int getIntAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes int value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  int value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getInt(long)
	 * @see MemAccessor#putIntAligned(long, int)
	 * @since 1.0
	 */
	void putInt(long _Addr, int _Val) throws Unchecked;
	
	
	/**
	 * Writes int value to given aligned memory address (address must be aligned by {@link Integer#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  int value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getInt(long)
	 * @see MemAccessor#putInt(long, int)
	 * @see MemAccessor#getIntAligned(long)
	 * @since 1.0
	 */
	void putIntAligned(long _Addr, int _Val) throws Unchecked;
	
	
	/**
	 * Returns float value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return float value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putFloat(long, float)
	 * @see MemAccessor#getFloatAligned(long)
	 * @since 1.0
	 */
	float getFloat(long _Addr) throws Unchecked;
	
	
	/**
	 * Returns float value from given aligned memory address (address must be aligned by {@link Float#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return float value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getFloat(long)
	 * @see MemAccessor#putFloat(long, float)
	 * @see MemAccessor#putFloatAligned(long, float)
	 * @since 1.0
	 */
	float getFloatAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes float value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  float value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getFloat(long)
	 * @see MemAccessor#putFloatAligned(long, float)
	 * @since 1.0
	 */
	void putFloat(long _Addr, float _Val) throws Unchecked;
	
	/**
	 * Writes float value to given aligned memory address (address must be aligned by {@link Float#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  float value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getFloat(long)
	 * @see MemAccessor#putFloat(long, float)
	 * @see MemAccessor#getFloatAligned(long)
	 * @since 1.0
	 */
	void putFloatAligned(long _Addr, float _Val) throws Unchecked;
	
	
	/**
	 * Returns long value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return long value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getLongAligned(long)
	 * @see MemAccessor#putLong(long, long)
	 * @since 1.0
	 */
	long getLong(long _Addr) throws Unchecked;
	
	/**
	 * Returns long value from given aligned memory address (address must be aligned by {@link Long#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return long value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getLong(long)
	 * @see MemAccessor#putLong(long, long)
	 * @see MemAccessor#putLongAligned(long, long)
	 * @since 1.0
	 */
	long getLongAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes long value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  long value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getLong(long)
	 * @see MemAccessor#getLongAligned(long)
	 * @see MemAccessor#putLongAligned(long, long)
	 * @since 1.0
	 */
	void putLong(long _Addr, long _Val) throws Unchecked;
	
	/**
	 * Writes long value to given aligned memory address (address must be aligned by {@link Long#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  long value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getLong(long)
	 * @see MemAccessor#getLongAligned(long)
	 * @see MemAccessor#putLong(long, long)
	 * @since 1.0
	 */
	void putLongAligned(long _Addr, long _Val) throws Unchecked;
	
	
	/**
	 * Returns double value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return double value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getDoubleAligned(long)
	 * @see MemAccessor#putDouble(long, double)
	 * @see MemAccessor#putDoubleAligned(long, double)
	 * @since 1.0
	 */
	double getDouble(long _Addr) throws Unchecked;
	
	/**
	 * Returns double value from given aligned memory address (address must be aligned by {@link Double#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return double value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getDouble(long)
	 * @see MemAccessor#putDouble(long, double)
	 * @see MemAccessor#putDoubleAligned(long, double)
	 * @since 1.0
	 */
	double getDoubleAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes double value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  double value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getDouble(long)
	 * @see MemAccessor#getDoubleAligned(long)
	 * @see MemAccessor#putDoubleAligned(long, double)
	 * @since 1.0
	 */
	void putDouble(long _Addr, double _Val) throws Unchecked;
	
	/**
	 * Writes double value to given aligned memory address (address must be aligned by {@link Double#BYTES}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  double value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getDouble(long)
	 * @see MemAccessor#getDoubleAligned(long)
	 * @see MemAccessor#putDouble(long, double)
	 * @since 1.0
	 */
	void putDoubleAligned(long _Addr, double _Val) throws Unchecked;
	
	
	/**
	 * Returns address value from given memory address.
	 *
	 * @param _Addr native memory address
	 * @return address value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getAddressAligned(long)
	 * @see MemAccessor#putAddress(long, long)
	 * @see MemAccessor#putAddressAligned(long, long)
	 * @since 1.0
	 */
	long getAddress(long _Addr) throws Unchecked;
	
	/**
	 * Returns address value from given aligned memory address (address must be aligned by {@link Mem#ADDRESS_SIZE}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @return address value from memory address
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getAddress(long)
	 * @see MemAccessor#putAddress(long, long)
	 * @see MemAccessor#putAddressAligned(long, long)
	 * @since 1.0
	 */
	long getAddressAligned(long _Addr) throws Unchecked;
	
	/**
	 * Writes address value to given memory address.
	 *
	 * @param _Addr native memory address
	 * @param _Val  address value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getAddress(long)
	 * @see MemAccessor#getAddressAligned(long)
	 * @see MemAccessor#putAddressAligned(long, long)
	 * @since 1.0
	 */
	void putAddress(long _Addr, long _Val) throws Unchecked;
	
	/**
	 * Writes address value to given aligned memory address (address must be aligned by {@link Mem#ADDRESS_SIZE}).<br>
	 * If given address is not aligned, the behavior is undefined.
	 *
	 * @param _Addr native memory address
	 * @param _Val  address value to write
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getAddress(long)
	 * @see MemAccessor#getAddressAligned(long)
	 * @see MemAccessor#putAddress(long, long)
	 * @since 1.0
	 */
	void putAddressAligned(long _Addr, long _Val) throws Unchecked;
	
	
	/**
	 * Copies given number of bytes from given source memory address to given destination memory address.
	 *
	 * @param _Dst   destination memory address
	 * @param _Src   source memory address
	 * @param _Bytes number of bytes to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#moveMemory(long, long, long)
	 * @since 1.0
	 */
	void copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;
	
	/**
	 * Copies given number of bytes from given source memory address to given destination memory address, overlapping aware.
	 *
	 * @param _Dst   destination memory address
	 * @param _Src   source memory address
	 * @param _Bytes number of bytes to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#copyMemory(long, long, long)
	 * @since 1.0
	 */
	void moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;
	
	/**
	 * Compares two memory regions for order.
	 *
	 * @param _Buf1 the first memory address
	 * @param _Buf2 the second memory address
	 * @param _Size the size of the memory region
	 * @return the value {@code 0} if {@code _Buf1 == _Buf2};
	 * a value less than {@code 0} if {@code _Buf1 < _Buf2}; and
	 * a value greater than {@code 0} if {@code _Buf1 > _Buf2}
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#compareMemory(long, long, long)
	 * @since 1.0
	 */
	default int compareMemory(long _Buf1, long _Buf2, long _Size) throws Unchecked {
		// Compare the memory regions byte by byte
		for (long i = 0L; i < _Size; ++i, ++_Buf1, ++_Buf2) {
			// If the first byte is less than the second, return -1
			if (this.getByte(_Buf1) < this.getByte(_Buf2)) {
				return -1;
			}
			
			// If the first byte is greater than the second, return 1
			if (this.getByte(_Buf1) > this.getByte(_Buf2)) {
				return 1;
			}
		}
		
		// If all bytes are equal, return 0
		return 0;
	}
	
	void setMemory(long _Dst, byte _Val, long _Size) throws Unchecked;
	
	/**
	 * Gets the size of memory addresses in bytes.
	 * <p>
	 * This size is equal to the size of a pointer in the current platform.
	 *
	 * @return the size of memory addresses in bytes
	 * @see Mem#ADDRESS_SIZE
	 * @since 1.0
	 */
	default int addressSize() {
		return Mem.ADDRESS_SIZE; // cyclic dependency, but no standard implementation uses it, so in theory it should work ¯\_(ツ)_/¯
	}
	
	/**
	 * Puts the given array of bytes into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param _Bytes the array of bytes to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBytes(long, int[], int, int)
	 * @see MemAccessor#putBytes(long, byte...)
	 * @since 1.0
	 */
	default void putBytes(long _Base, byte[] _Bytes, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putByte(_Base + i, _Bytes[i++])) ;
	}
	
	/**
	 * Puts the given array of bytes into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 * The given array is expected to contain {@code byte} values, and the
	 * cast is done using a simple cast, which may lose information.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param _Bytes the array of bytes to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBytes(long, byte[], int, int)
	 * @see MemAccessor#putBytes(long, byte...)
	 * @since 1.0
	 */
	default void putBytes(long _Base, int[] _Bytes, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putByte(_Base + i, (byte) _Bytes[i++])) ;
	}
	
	/**
	 * Puts the given array of booleans into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param _Value the array of booleans to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBooleans(long, boolean...)
	 * @since 1.0
	 */
	default void putBooleans(long _Base, boolean[] _Value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putBoolean(_Base + i, _Value[i++])) ;
	}
	
	/**
	 * Puts the given array of shorts into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From * 2}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param _Value the array of shorts to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putShorts(long, short...)
	 * @since 1.0
	 */
	default void putShorts(long _Base, short[] _Value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putShort(_Base + ((long) i << 1L), _Value[i++])) ;
	}
	
	/**
	 * Puts the given array of characters into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From * 2}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param _Value the array of characters to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putChars(long, char...)
	 * @since 1.0
	 */
	default void putChars(long _Base, char[] _Value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putChar(_Base + ((long) i << 1L), _Value[i++])) ;
	}
	/**
	 * Puts the given array of integers into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From * 4}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of integers to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putInts(long, int...)
	 * @since 1.0
	 */
	default void putInts(long _Base, int[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putInt(_Base + ((long) i << 2L), value[i++])) ;
	}
	
	/**
	 * Puts the given array of floats into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base + _From * 4}.
	 * The given array is copied to the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of floats to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putFloats(long, float...) 
	 * @since 1.0
	 */
	default void putFloats(long _Base, float[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putFloat(_Base + ((long) i << 2L), value[i++])) ;
	}
	
	default void putLongs(long _Base, long[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putLong(_Base + ((long) i << 3L), value[i++])) ;
	}
	
	default void putDoubles(long _Base, double[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putDouble(_Base + ((long) i << 3L), value[i++])) ;
	}
	
	
	/**
	 * Puts the given array of bytes into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of bytes to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void putBytes(long _Base, byte... value) throws Unchecked {
		putBytes(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of bytes into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of bytes to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBytes(long, int[], int, int)
	 * @since 1.0
	 */
	default void putBytes(long _Base, int... value) throws Unchecked {
		putBytes(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of booleans into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of booleans to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBooleans(long, boolean[], int, int)
	 * @since 1.0
	 */
	default void putBooleans(long _Base, boolean... value) throws Unchecked {
		putBooleans(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of shorts into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of shorts to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putShorts(long, short[], int, int)
	 * @since 1.0
	 */
	default void putShorts(long _Base, short... value) throws Unchecked {
		putShorts(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of characters into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of characters to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putChars(long, char[], int, int)
	 * @since 1.0
	 */
	default void putChars(long _Base, char... value) throws Unchecked {
		putChars(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of integers into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of integers to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putInts(long, int[], int, int)
	 * @since 1.0
	 */
	default void putInts(long _Base, int... value) throws Unchecked {
		putInts(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of floats into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of floats to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putFloats(long, float[], int, int)
	 * @since 1.0
	 */
	default void putFloats(long _Base, float... value) throws Unchecked {
		putFloats(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of longs into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of longs to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putLongs(long, long[], int, int)
	 * @since 1.0
	 */
	default void putLongs(long _Base, long... value) throws Unchecked {
		putLongs(_Base, value, 0, value.length);
	}
	
	/**
	 * Puts the given array of doubles into memory.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied to the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of doubles to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putDoubles(long, double[], int, int)
	 * @since 1.0
	 */
	default void putDoubles(long _Base, double... value) throws Unchecked {
		putDoubles(_Base, value, 0, value.length);
	}
	
	
	/**
	 * Copies the given memory region into the given array of bytes.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is fully copied from the memory region.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of bytes to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#putBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getBytes(long _Base, byte[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getByte(_Base + ((long) i++))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of booleans.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of booleans to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getBooleans(long _Base, boolean[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getBoolean(_Base + ((long) i++))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of shorts.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of shorts to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getShorts(long _Base, short[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getShort(_Base + ((long) i++ << 1L))) ;
	}
	/**
	 * Copies the given memory region into the given array of characters.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of characters to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getChars(long _Base, char[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getChar(_Base + ((long) i++ << 1L))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of integers.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of integers to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getInts(long _Base, int[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getInt(_Base + ((long) i++ << 2L))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of floats.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of floats to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getFloats(long _Base, float[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getFloat(_Base + ((long) i++ << 2L))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of longs.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of longs to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getLongs(long _Base, long[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getLong(_Base + ((long) i++ << 3L))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of doubles.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index {@code _From}
	 * to index {@code _To - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of doubles to copy
	 * @param _From the starting index of the array to copy
	 * @param _To the ending index of the array to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getDoubles(long _Base, double[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getDouble(_Base + ((long) i++ << 3L))) ;
	}
	
	/**
	 * Copies the given memory region into the given array of bytes.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of bytes to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getBytes(long _Base, byte[] value) throws Unchecked {
		getBytes(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of booleans.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of booleans to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getBooleans(long _Base, boolean[] value) throws Unchecked {
		getBooleans(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of shorts.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of shorts to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getShorts(long _Base, short[] value) throws Unchecked {
		getShorts(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of characters.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of characters to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getChars(long _Base, char[] value) throws Unchecked {
		getChars(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of integers.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of integers to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getInts(long _Base, int[] value) throws Unchecked {
		getInts(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of floats.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of floats to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getFloats(long _Base, float[] value) throws Unchecked {
		getFloats(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of longs.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of longs to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getLongs(long _Base, long[] value) throws Unchecked {
		getLongs(_Base, value, 0, value.length);
	}
	
	/**
	 * Copies the given memory region into the given array of doubles.
	 * <p>
	 * The starting address of the memory region is {@code _Base}.
	 * The given array is copied from the memory region from index 0 to
	 * index {@code value.length - 1}.
	 * <p>
	 *
	 * @param _Base the starting address of the memory region
	 * @param value the array of doubles to copy
	 * @throws Unchecked this operation is unsafe
	 * @see MemAccessor#getBytes(long, byte[], int, int)
	 * @since 1.0
	 */
	default void getDoubles(long _Base, double[] value) throws Unchecked {
		getDoubles(_Base, value, 0, value.length);
	}
	
	
	/**
	 * Allocates memory with RWX (readable, writable and executable) permissions.
	 *
	 * @param size the size of the memory block to allocate
	 * @return the address of the allocated memory block
	 * @throws Unchecked indicates that the operation is unsafe
	 * @throws RWXAllocationNotSupportedException if allocation of memory with RWX permissions is not supported
	 */
	default long allocRWX(long size) throws Unchecked, RWXAllocationNotSupportedException {
		try {
			return AccessorJniDirect.allocRWX0(size);
		} catch (Throwable e) {
			throw new RWXAllocationNotSupportedException(e);
		}
	}
}
