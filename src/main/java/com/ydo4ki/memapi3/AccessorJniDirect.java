package com.ydo4ki.memapi3;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:51
 */
final class AccessorJniDirect implements MemAccessor {
	@Override
	public boolean getBoolean(long _Addr) throws Unchecked {
		return getByte(_Addr) != 0;
	}

	@Override
	public void putBoolean(long _Addr, boolean _Val) throws Unchecked {
		putByte(_Addr, (byte) (_Val ? 1 : 0));
	}

	@Override
	public native byte getByte(long _Addr) throws Unchecked;

	@Override
	public native void putByte(long _Addr, byte _Val) throws Unchecked;

	@Override
	public native short getShort(long _Addr) throws Unchecked;

	@Override
	public native short getShortAligned(long _Addr) throws Unchecked;

	@Override
	public native void putShort(long _Addr, short _Val) throws Unchecked;

	@Override
	public native void putShortAligned(long _Addr, short _Val) throws Unchecked;

	@Override
	public char getChar(long _Addr) throws Unchecked {
		return (char) getShort(_Addr);
	}

	@Override
	public char getCharAligned(long _Addr) throws Unchecked {
		return (char) getShortAligned(_Addr);
	}

	@Override
	public void putChar(long _Addr, char _Val) throws Unchecked {
		putShort(_Addr, (short) _Val);
	}

	@Override
	public void putCharAligned(long _Addr, char _Val) throws Unchecked {
		putShortAligned(_Addr, (short) _Val);
	}

	@Override
	public native int getInt(long _Addr) throws Unchecked;

	@Override
	public native int getIntAligned(long _Addr) throws Unchecked;

	@Override
	public native void putInt(long _Addr, int _Val) throws Unchecked;

	@Override
	public native void putIntAligned(long _Addr, int _Val) throws Unchecked;

	@Override
	public float getFloat(long _Addr) throws Unchecked {
		return Float.intBitsToFloat(getInt(_Addr));
	}

	@Override
	public float getFloatAligned(long _Addr) throws Unchecked {
		return Float.intBitsToFloat(getIntAligned(_Addr));
	}

	@Override
	public void putFloat(long _Addr, float _Val) throws Unchecked {
		putInt(_Addr, Float.floatToIntBits(_Val));
	}

	@Override
	public void putFloatAligned(long _Addr, float _Val) throws Unchecked {
		putIntAligned(_Addr, Float.floatToIntBits(_Val));
	}

	@Override
	public native long getLong(long _Addr) throws Unchecked;

	@Override
	public native long getLongAligned(long _Addr) throws Unchecked;

	@Override
	public native void putLong(long _Addr, long _Val) throws Unchecked;

	@Override
	public native void putLongAligned(long _Addr, long _Val) throws Unchecked;

	@Override
	public double getDouble(long _Addr) throws Unchecked {
		return Double.longBitsToDouble(getLong(_Addr));
	}

	@Override
	public double getDoubleAligned(long _Addr) throws Unchecked {
		return Double.longBitsToDouble(getLongAligned(_Addr));
	}

	@Override
	public void putDouble(long _Addr, double _Val) throws Unchecked {
		putLong(_Addr, Double.doubleToLongBits(_Val));
	}

	@Override
	public void putDoubleAligned(long _Addr, double _Val) throws Unchecked {
		putLongAligned(_Addr, Double.doubleToLongBits(_Val));
	}

	@Override
	public native long getAddress(long _Addr) throws Unchecked;

	@Override
	public native long getAddressAligned(long _Addr) throws Unchecked;

	@Override
	public native void putAddress(long _Addr, long _Val) throws Unchecked;

	@Override
	public native void putAddressAligned(long _Addr, long _Val) throws Unchecked;

	@Override
	public native long copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;

	@Override
	public native long moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked;

	@Override
	public native int compareMemory(long _Buf1, long _Buf2, long _Size) throws Unchecked;

	@Override
	public native void setMemory(long _Dst, byte _Val, long _Size) throws Unchecked;

	@Override
	public native int addressSize();

	@Override
	public native void deallocateMemory(long _Mem) throws Unchecked;

	@Override
	public long allocateMemory(long _Size, long _Alignment) throws Unchecked, IllegalArgumentException {
		if (_Size % _Alignment != 0)
			throw new IllegalArgumentException("Size must be aligned by specified alignment (" + _Size + " % " + _Alignment + " != 0)");
		return allocateMemory0(_Size, _Alignment);
	}

	private static native long allocateMemory0(long _Size, long _Alignment);
}
