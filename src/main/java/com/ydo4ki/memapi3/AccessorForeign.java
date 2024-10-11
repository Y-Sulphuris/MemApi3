package com.ydo4ki.memapi3;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Optional;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:51
 */
final class AccessorForeign implements MemAccessor {
	private static final MemorySegment ram = MemorySegment.NULL.reinterpret(Long.MAX_VALUE);


	@Override
	public boolean getBoolean(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_BOOLEAN, _Addr);
	}

	@Override
	public void putBoolean(long _Addr, boolean _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_BOOLEAN, _Addr, _Val);
	}

	@Override
	public byte getByte(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_BYTE, _Addr);
	}

	@Override
	public void putByte(long _Addr, byte _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_BYTE, _Addr, _Val);
	}

	@Override
	public short getShort(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_SHORT_UNALIGNED, _Addr);
	}

	@Override
	public short getShortAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_SHORT, _Addr);
	}

	@Override
	public void putShort(long _Addr, short _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_SHORT_UNALIGNED, _Addr, _Val);
	}

	@Override
	public void putShortAligned(long _Addr, short _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_SHORT, _Addr, _Val);
	}

	@Override
	public char getChar(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_CHAR_UNALIGNED, _Addr);
	}

	@Override
	public char getCharAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_CHAR, _Addr);
	}

	@Override
	public void putChar(long _Addr, char _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_CHAR_UNALIGNED, _Addr, _Val);
	}

	@Override
	public void putCharAligned(long _Addr, char _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_CHAR, _Addr, _Val);
	}

	@Override
	public int getInt(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_INT, _Addr);
	}

	@Override
	public int getIntAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_INT_UNALIGNED, _Addr);
	}

	@Override
	public void putInt(long _Addr, int _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_INT_UNALIGNED, _Addr, _Val);
	}

	@Override
	public void putIntAligned(long _Addr, int _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_INT, _Addr, _Val);
	}

	@Override
	public float getFloat(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_FLOAT, _Addr);
	}

	@Override
	public float getFloatAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_FLOAT_UNALIGNED, _Addr);
	}

	@Override
	public void putFloat(long _Addr, float _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_FLOAT_UNALIGNED, _Addr, _Val);
	}

	@Override
	public void putFloatAligned(long _Addr, float _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_FLOAT, _Addr, _Val);
	}

	@Override
	public long getLong(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_LONG_UNALIGNED, _Addr);
	}

	@Override
	public long getLongAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_LONG, _Addr);
	}

	@Override
	public void putLong(long _Addr, long _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_LONG_UNALIGNED, _Addr, _Val);
	}

	@Override
	public void putLongAligned(long _Addr, long _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_LONG, _Addr, _Val);
	}

	@Override
	public double getDouble(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_DOUBLE_UNALIGNED, _Addr);
	}

	@Override
	public double getDoubleAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.JAVA_DOUBLE, _Addr);
	}

	@Override
	public void putDouble(long _Addr, double _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_DOUBLE_UNALIGNED, _Addr, _Val);
	}

	@Override
	public void putDoubleAligned(long _Addr, double _Val) throws Unchecked {
		ram.set(ValueLayout.JAVA_DOUBLE, _Addr, _Val);
	}

	@Override
	public long getAddress(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.ADDRESS_UNALIGNED, _Addr).address();
	}

	@Override
	public long getAddressAligned(long _Addr) throws Unchecked {
		return ram.get(ValueLayout.ADDRESS, _Addr).address();
	}

	@Override
	public void putAddress(long _Addr, long _Val) throws Unchecked {
		ram.set(ValueLayout.ADDRESS_UNALIGNED, _Addr, MemorySegment.ofAddress(_Val));
	}

	@Override
	public void putAddressAligned(long _Addr, long _Val) throws Unchecked {
		ram.set(ValueLayout.ADDRESS, _Addr, MemorySegment.ofAddress(_Val));
	}

	@Override
	public long copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked {
		MemorySegment.copy(ram, _Src, ram, _Dst, _Bytes);
		return _Dst;
	}

	@Override
	public long moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked {
		MemorySegment.copy(ram, _Src, ram, _Dst, _Bytes);
		return _Dst;
	}

	@Override
	public int compareMemory(long _Buf1, long _Buf2, long _Size) throws Unchecked {
		for (long i = 0; i < _Size; ++i, ++_Buf1, ++_Buf2) {
			if (getByte(_Buf1) < getByte(_Buf2)) {
				return -1;
			} else if (getByte(_Buf1) > getByte(_Buf2)) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public void setMemory(long _Dst, byte _Val, long _Size) throws Unchecked {
		MemorySegment.ofAddress(_Dst).reinterpret(_Size).fill(_Val);
	}


	private static final MethodHandle alloc;
	private static final MethodHandle dealloc;

	static {
		Linker linker = Linker.nativeLinker();
		SymbolLookup lookup = linker.defaultLookup();

		Optional<MemorySegment> aligned_alloc = lookup.find("aligned_alloc");
		Optional<MemorySegment> aligned_free;
		if (aligned_alloc.isEmpty()) {
			// windows _aligned_malloc
			aligned_alloc = linker.defaultLookup().find("_aligned_malloc");
			aligned_free = linker.defaultLookup().find("_aligned_free");
		} else {
			aligned_free = lookup.find("free");
		}

		// in theory size_t is actually an address, not JAVA_LONG
		FunctionDescriptor alloc_descriptor = FunctionDescriptor.of(
				ValueLayout.ADDRESS, // void*
				ValueLayout.ADDRESS, // size_t Size
				ValueLayout.ADDRESS  // size_t Alignment
		);
		alloc = linker.downcallHandle(aligned_alloc.orElseThrow(), alloc_descriptor);
		FunctionDescriptor free_descriptor = FunctionDescriptor.ofVoid(
				ValueLayout.ADDRESS // void* mem
		);
		dealloc = linker.downcallHandle(aligned_free.orElseThrow(), free_descriptor);
	}

	@Override
	public long allocateMemory(long _Size, long _Alignment) throws Unchecked {
		try {
			return ((MemorySegment)alloc.invoke(MemorySegment.ofAddress(_Size), MemorySegment.ofAddress(_Alignment))).address();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deallocateMemory(long _Mem) throws Unchecked {
		try {
			dealloc.invokeExact(MemorySegment.ofAddress(_Mem));
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}
}
