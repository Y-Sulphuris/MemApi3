package com.ydo4ki.memapi3;

/**
 * Interface for accessing native memory.<br>
 * This interface is used to access native memory from java.<br>
 * All methods marked {@link Unchecked} if operation is unsafe.<br>
 * All methods are final and can be inlined by jit.
 * @author Sulphuris
 * @since 11.10.2024 12:57
 */
public interface MemAccessor extends MemAllocatorManual {

	/**
	 * Returns boolean value from memory address.<br>
	 * @param _Addr native memory address
	 * @return boolean value from memory address
	 * @throws Unchecked This operation is unsafe
	 */
	boolean getBoolean(long _Addr) throws Unchecked;

	/**
	 * Same as {@link #getBoolean(long)}, but required aligned memory address.
	 * @param _Addr native memory address
	 * @return boolean value from memory address
	 * @throws Unchecked this operation is unsafe
	 */
	default boolean getBooleanAligned(long _Addr) throws Unchecked {
		return getBoolean(_Addr);
	}

	void putBoolean(long _Addr, boolean _Val) throws Unchecked;

	default void putBooleanAligned(long _Addr, boolean _Val) throws Unchecked {
		putBoolean(_Addr, _Val);
	}


	byte getByte(long _Addr) throws Unchecked;

	default byte getByteAligned(long _Addr) throws Unchecked {
		return getByte(_Addr);
	}

	void putByte(long _Addr, byte _Val) throws Unchecked;

	default void putByteAligned(long _Addr, byte _Val) throws Unchecked {
		putByte(_Addr, _Val);
	}


	short getShort(long _Addr) throws Unchecked;

	short getShortAligned(long _Addr) throws Unchecked;

	void putShort(long _Addr, short _Val) throws Unchecked;

	void putShortAligned(long _Addr, short _Val) throws Unchecked;


	char getChar(long _Addr) throws Unchecked;

	char getCharAligned(long _Addr) throws Unchecked;

	void putChar(long _Addr, char _Val) throws Unchecked;

	void putCharAligned(long _Addr, char _Val) throws Unchecked;


	int getInt(long _Addr) throws Unchecked;

	int getIntAligned(long _Addr) throws Unchecked;

	void putInt(long _Addr, int _Val) throws Unchecked;

	void putIntAligned(long _Addr, int _Val) throws Unchecked;


	float getFloat(long _Addr) throws Unchecked;

	float getFloatAligned(long _Addr) throws Unchecked;

	void putFloat(long _Addr, float _Val) throws Unchecked;

	void putFloatAligned(long _Addr, float _Val) throws Unchecked;


	long getLong(long _Addr) throws Unchecked;

	long getLongAligned(long _Addr) throws Unchecked;

	void putLong(long _Addr, long _Val) throws Unchecked;

	void putLongAligned(long _Addr, long _Val) throws Unchecked;


	double getDouble(long _Addr) throws Unchecked;

	double getDoubleAligned(long _Addr) throws Unchecked;

	void putDouble(long _Addr, double _Val) throws Unchecked;

	void putDoubleAligned(long _Addr, double _Val) throws Unchecked;


	long getAddress(long _Addr) throws Unchecked;

	long getAddressAligned(long _Addr) throws Unchecked;

	void putAddress(long _Addr, long _Val) throws Unchecked;

	void putAddressAligned(long _Addr, long _Val) throws Unchecked;


	void copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;

	void moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;

	default int compareMemory(long _Buf1, long _Buf2, long _Size) throws Unchecked {
		for (long i = 0L; i < _Size; ++_Buf2) {
			if (this.getByte(_Buf1) < this.getByte(_Buf2)) {
				return -1;
			}

			if (this.getByte(_Buf1) > this.getByte(_Buf2)) {
				return 1;
			}

			++i;
			++_Buf1;
		}

		return 0;
	}

	void setMemory(long _Dst, byte _Val, long _Size) throws Unchecked;

	default int addressSize() {
		return 4;
	}

	default void putBytes(long _Base, byte[] _Bytes, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putByte(_Base + i, _Bytes[i++]));
	}

	default void putBytes(long _Base, int[] _Bytes, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putByte(_Base + i, (byte)_Bytes[i++]));
	}

	default void putBooleans(long _Base, boolean[] _Value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putBoolean(_Base + i, _Value[i++]));
	}

	default void putShorts(long _Base, short[] _Value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putShort(_Base + ((long) i << 1L), _Value[i++]));
	}

	default void putChars(long _Base, char[] _Value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putChar(_Base + ((long) i << 1L), _Value[i++]));
	}

	default void putInts(long _Base, int[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putInt(_Base + ((long) i << 2L), value[i++]));
	}

	default void putFloats(long _Base, float[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putFloat(_Base + ((long) i << 2L), value[i++]));
	}

	default void putLongs(long _Base, long[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putLong(_Base + ((long) i << 3L), value[i++]));
	}

	default void putDoubles(long _Base, double[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; putDouble(_Base + ((long) i << 3L), value[i++]));
	}


	default void putBytes(long _Base, byte... value) throws Unchecked {
		putBytes(_Base, value, 0, value.length);
	}

	default void putBytes(long _Base, int... value) throws Unchecked {
		putBytes(_Base, value, 0, value.length);
	}

	default void putBooleans(long _Base, boolean... value) throws Unchecked {
		putBooleans(_Base, value, 0, value.length);
	}

	default void putShorts(long _Base, short... value) throws Unchecked {
		putShorts(_Base, value, 0, value.length);
	}

	default void putChars(long _Base, char... value) throws Unchecked {
		putChars(_Base, value, 0, value.length);
	}

	default void putInts(long _Base, int... value) throws Unchecked {
		putInts(_Base, value, 0, value.length);
	}

	default void putFloats(long _Base, float... value) throws Unchecked {
		putFloats(_Base, value, 0, value.length);
	}

	default void putLongs(long _Base, long... value) throws Unchecked {
		putLongs(_Base, value, 0, value.length);
	}

	default void putDoubles(long _Base, double... value) throws Unchecked {
		putDoubles(_Base, value, 0, value.length);
	}



	default void getBytes(long _Base, byte[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getByte(_Base + ((long) i++)));
	}

	default void getBooleans(long _Base, boolean[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getBoolean(_Base + ((long) i++)));
	}

	default void getShorts(long _Base, short[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getShort(_Base + ((long) i++ << 1L)));
	}

	default void getChars(long _Base, char[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getChar(_Base + ((long) i++ << 1L)));
	}

	default void getInts(long _Base, int[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getInt(_Base + ((long) i++ << 2L)));
	}

	default void getFloats(long _Base, float[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getFloat(_Base + ((long) i++ << 2L)));
	}

	default void getLongs(long _Base, long[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getLong(_Base + ((long) i++ << 3L)));
	}

	default void getDoubles(long _Base, double[] value, int _From, int _To) throws Unchecked {
		for (int i = _From; i < _To; value[i] = getDouble(_Base + ((long) i++ << 3L)));
	}


	default void getBytes(long _Base, byte[] value) throws Unchecked {
		getBytes(_Base, value, 0, value.length);
	}

	default void getBooleans(long _Base, boolean[] value) throws Unchecked {
		getBooleans(_Base, value, 0, value.length);
	}

	default void getShorts(long _Base, short[] value) throws Unchecked {
		getShorts(_Base, value, 0, value.length);
	}

	default void getChars(long _Base, char[] value) throws Unchecked {
		getChars(_Base, value, 0, value.length);
	}

	default void getInts(long _Base, int[] value) throws Unchecked {
		getInts(_Base, value, 0, value.length);
	}

	default void getFloats(long _Base, float[] value) throws Unchecked {
		getFloats(_Base, value, 0, value.length);
	}

	default void getLongs(long _Base, long[] value) throws Unchecked {
		getLongs(_Base, value, 0, value.length);
	}

	default void getDoubles(long _Base, double[] value) throws Unchecked {
		getDoubles(_Base, value, 0, value.length);
	}


	default byte[] getBytes(long _Base, int _Size) throws Unchecked {
		byte[] ret = new byte[_Size];
		getBytes(_Base, ret);
		return ret;
	}

	default boolean[] getBooleans(long _Base, int _Size) throws Unchecked {
		boolean[] ret = new boolean[_Size];
		getBooleans(_Base, ret);
		return ret;
	}

	default short[] getShorts(long _Base, int _Size) throws Unchecked {
		short[] ret = new short[_Size];
		getShorts(_Base, ret);
		return ret;
	}

	default char[] getChars(long _Base, int _Size) throws Unchecked {
		char[] ret = new char[_Size];
		getChars(_Base, ret);
		return ret;
	}

	default int[] getInts(long _Base, int _Size) throws Unchecked {
		int[] ret = new int[_Size];
		getInts(_Base, ret);
		return ret;
	}

	default float[] getFloats(long _Base, int _Size) throws Unchecked {
		float[] ret = new float[_Size];
		getFloats(_Base, ret);
		return ret;
	}

	default long[] getLongs(long _Base, int _Size) throws Unchecked {
		long[] ret = new long[_Size];
		getLongs(_Base, ret);
		return ret;
	}

	default double[] getDoubles(long _Base, int _Size) throws Unchecked {
		double[] ret = new double[_Size];
		getDoubles(_Base, ret);
		return ret;
	}


	default long allocRWX(long size) throws Unchecked, RWXAllocationNotSupoortedException {
		try {
			return AccessorJniDirect.allocRWX0(size);
		} catch (Throwable e) {
			throw new RWXAllocationNotSupoortedException(e);
		}
	}
}
