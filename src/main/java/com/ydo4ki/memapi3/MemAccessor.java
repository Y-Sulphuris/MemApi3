package com.ydo4ki.memapi3;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:57
 */
public interface MemAccessor extends MemAllocatorManual {

	boolean getBoolean(long _Addr) throws Unchecked;

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


	long copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;

	long moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;

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
}
