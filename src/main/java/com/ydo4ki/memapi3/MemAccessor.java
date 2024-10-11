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
		for(long i = 0L; i < _Size; ++_Buf2) {
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
}
