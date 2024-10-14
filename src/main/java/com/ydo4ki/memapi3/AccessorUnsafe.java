package com.ydo4ki.memapi3;

import sun.misc.Unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntSupplier;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:50
 */
final class AccessorUnsafe implements MemAccessor {
	static final Unsafe unsafe = getUnsafe();

	private static Unsafe getUnsafe() {
		try {
			final Field[] fields = Unsafe.class.getDeclaredFields();

			for (Field field : fields) {
				if (!field.getType().equals(Unsafe.class))
					continue;

				final int modifiers = field.getModifiers();
				if (!(Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)))
					continue;

				field.setAccessible(true);
				return (Unsafe) field.get(null);
			}
			throw new UnsupportedOperationException("theUnsafe not found");
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final AccessorJniDirect fallback = new AccessorJniDirect();

	private static final MethodHandles.Lookup lookup = MethodHandles.lookup();

	private static final MethodHandle getByte = findSunUnsafeMethod("getByte", byte.class, long.class);
	private static final MethodHandle putByte = findSunUnsafeMethod("putByte", void.class, long.class, byte.class);
	private static final MethodHandle getShort = findSunUnsafeMethod("getShort", short.class, long.class);
	private static final MethodHandle putShort = findSunUnsafeMethod("putShort", void.class, long.class, short.class);
	private static final MethodHandle getInt = findSunUnsafeMethod("getInt", int.class, long.class);
	private static final MethodHandle putInt = findSunUnsafeMethod("putInt", void.class, long.class, int.class);
	private static final MethodHandle getLong = findSunUnsafeMethod("getLong", long.class, long.class);
	private static final MethodHandle putLong = findSunUnsafeMethod("putLong", void.class, long.class, long.class);
	private static final MethodHandle getAddress = findSunUnsafeMethod("getAddress", long.class, long.class);
	private static final MethodHandle putAddress = findSunUnsafeMethod("putAddress", void.class, long.class, long.class);

	private static final MethodHandle copyMemory = findSunUnsafeMethod("copyMemory", void.class, long.class, long.class, long.class);
	private static final MethodHandle setMemory = findSunUnsafeMethod("setMemory", void.class, long.class, long.class, byte.class);

	private static final MethodHandle addressSize = findSunUnsafeMethod("addressSize", int.class);

	/**
	 * Tries to find the specified method in the {@link sun.misc.Unsafe} class and returns a {@link MethodHandle} to it.
	 * <p>
	 * If the method does not exist, returns {@code null}.
	 *
	 * @param methodName the name of the method to find
	 * @param returnType the return type of the method
	 * @param args the parameter types of the method
	 * @return a {@link MethodHandle} to the method, or {@code null} if the method does not exist
	 */
	private static MethodHandle findSunUnsafeMethodOrNull(String methodName, Class<?> returnType, Class<?>... args) {
		try {
			return findMethod(methodName, unsafe, returnType, args);
		} catch (Throwable e) {
			return null;
		}
	}
	private static MethodHandle findSunUnsafeMethod(String methodName, Class<?> returnType, Class<?>... args) {
		try {
			return findMethod(methodName, unsafe, returnType, args);
		} catch (Throwable e) {
			e.printStackTrace();
			return findMethodTrusted(methodName, fallback, returnType, args);
		}
	}

	private static MethodHandle findMethodTrusted(String methodName, Object target, Class<?> returnType, Class<?>... args) {
		try {
			return findMethod(methodName, target, returnType, args);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	private static MethodHandle findMethod(String methodName, Object target, Class<?> returnType, Class<?>... args) throws Throwable {
		return lookup.bind(target, methodName, MethodType.methodType(returnType, args));
	}

	@Override
	public boolean getBoolean(long _Addr) throws Unchecked {
		return getByte(_Addr) != 0;
	}

	@Override
	public void putBoolean(long _Addr, boolean _Val) throws Unchecked {
		putByte(_Addr, (byte) (_Val ? 1 : 0));
	}

	@Override
	public byte getByte(long _Addr) throws Unchecked {
		try {
			return (byte) getByte.invokeExact(_Addr);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void putByte(long _Addr, byte _Val) throws Unchecked {
		try {
			putByte.invokeExact(_Addr, _Val);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public short getShort(long _Addr) throws Unchecked {
		try {
			return (short) getShort.invokeExact(_Addr);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public short getShortAligned(long _Addr) throws Unchecked {
		return getShort(_Addr);
	}

	@Override
	public void putShort(long _Addr, short _Val) throws Unchecked {
		try {
			putShort.invokeExact(_Addr, _Val);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void putShortAligned(long _Addr, short _Val) throws Unchecked {
		putShort(_Addr, _Val);
	}

	@Override
	public char getChar(long _Addr) throws Unchecked {
		return (char) getShort(_Addr);
	}

	@Override
	public char getCharAligned(long _Addr) throws Unchecked {
		return getChar(_Addr);
	}

	@Override
	public void putChar(long _Addr, char _Val) throws Unchecked {
		putShort(_Addr, (short) _Val);
	}

	@Override
	public void putCharAligned(long _Addr, char _Val) throws Unchecked {
		putChar(_Addr, _Val);
	}

	@Override
	public int getInt(long _Addr) throws Unchecked {
		try {
			return (int) getInt.invokeExact(_Addr);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public int getIntAligned(long _Addr) throws Unchecked {
		return getInt(_Addr);
	}

	@Override
	public void putInt(long _Addr, int _Val) throws Unchecked {
		try {
			putInt.invokeExact(_Addr, _Val);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void putIntAligned(long _Addr, int _Val) throws Unchecked {
		putInt(_Addr, _Val);
	}

	@Override
	public float getFloat(long _Addr) throws Unchecked {
		return Float.intBitsToFloat(getInt(_Addr));
	}

	@Override
	public float getFloatAligned(long _Addr) throws Unchecked {
		return getFloat(_Addr);
	}

	@Override
	public void putFloat(long _Addr, float _Val) throws Unchecked {
		putInt(_Addr, Float.floatToIntBits(_Val));
	}

	@Override
	public void putFloatAligned(long _Addr, float _Val) throws Unchecked {
		putFloat(_Addr, _Val);
	}

	@Override
	public long getLong(long _Addr) throws Unchecked {
		try {
			return (long) getLong.invokeExact(_Addr);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public long getLongAligned(long _Addr) throws Unchecked {
		return getLong(_Addr);
	}

	@Override
	public void putLong(long _Addr, long _Val) throws Unchecked {
		try {
			putLong.invokeExact(_Addr, _Val);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void putLongAligned(long _Addr, long _Val) throws Unchecked {
		putLong(_Addr, _Val);
	}

	@Override
	public double getDouble(long _Addr) throws Unchecked {
		return Double.longBitsToDouble(getLong(_Addr));
	}

	@Override
	public double getDoubleAligned(long _Addr) throws Unchecked {
		return getDouble(_Addr);
	}

	@Override
	public void putDouble(long _Addr, double _Val) throws Unchecked {
		putLong(_Addr, Double.doubleToLongBits(_Val));
	}

	@Override
	public void putDoubleAligned(long _Addr, double _Val) throws Unchecked {
		putDouble(_Addr, _Val);
	}

	@Override
	public long getAddress(long _Addr) throws Unchecked {
		try {
			return (long) getAddress.invokeExact(_Addr);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public long getAddressAligned(long _Addr) throws Unchecked {
		return getAddress(_Addr);
	}

	@Override
	public void putAddress(long _Addr, long _Val) throws Unchecked {
		try {
			putAddress.invokeExact(_Addr, _Val);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void putAddressAligned(long _Addr, long _Val) throws Unchecked {
		putAddress(_Addr, _Val);
	}

	@Override
	public void copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked {
		try {
			copyMemory.invokeExact(_Dst, _Src, _Bytes);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked {
		fallback.moveMemory(_Dst, _Src, _Bytes);
	}

	@Override
	public void setMemory(long _Dst, byte _Val, long _Size) throws Unchecked {
		try {
			setMemory.invokeExact(_Dst, _Size, _Val);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public int addressSize() {
		try {
			return (int) addressSize.invokeExact();
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}

	@Override
	public void deallocateMemory(long _Mem) throws Unchecked {
		fallback.deallocateMemory(_Mem);
	}

	@Override
	public long allocateMemory(long _Size, long _Alignment) throws Unchecked, IllegalArgumentException {
		return fallback.allocateMemory(_Size, _Alignment);
	}

	// These methods intended to be implemented using MethodHandles, but there
	// is inconsistency in my mind
	private static final int BYTE_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_BYTE_BASE_OFFSET);
	private static final int BOOLEAN_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_BOOLEAN_BASE_OFFSET);
	private static final int SHORT_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_SHORT_BASE_OFFSET);
	private static final int CHAR_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_CHAR_BASE_OFFSET);
	private static final int INT_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_INT_BASE_OFFSET);
	private static final int FLOAT_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_FLOAT_BASE_OFFSET);
	private static final int LONG_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_LONG_BASE_OFFSET);
	private static final int DOUBLE_ARRAY_BASE = optionalInt(() -> Unsafe.ARRAY_DOUBLE_BASE_OFFSET);

	private static int optionalInt(IntSupplier supplier) {
		try {
			return supplier.getAsInt();
		} catch (Throwable e) {
			return -1;
		}
	}

	private static final MethodHandle copyMemoryRef = findSunUnsafeMethodOrNull("copyMemory", void.class, Object.class, long.class, Object.class, long.class, long.class);

	@Override
	public void putBytes(long _Base, byte[] _Bytes, int _From, int _To) throws Unchecked {
		if (BYTE_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(_Bytes, _From + BYTE_ARRAY_BASE, null, _Base, _To - _From);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putBytes(_Base, _Bytes, _From, _To);
	}

	@Override
	public void putBooleans(long _Base, boolean[] __Value, int _From, int _To) throws Unchecked {
		if (BOOLEAN_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(__Value, _From + BOOLEAN_ARRAY_BASE, null, _Base, _To - _From);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putBooleans(_Base, __Value, _From, _To);
	}

	@Override
	public void putShorts(long _Base, short[] __Value, int _From, int _To) throws Unchecked {
		if (SHORT_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(__Value, _From + SHORT_ARRAY_BASE, null, _Base, (long) (_To - _From) << 1L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putShorts(_Base, __Value, _From, _To);
	}

	@Override
	public void putChars(long _Base, char[] __Value, int _From, int _To) throws Unchecked {
		if (CHAR_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(__Value, _From + CHAR_ARRAY_BASE, null, _Base, (long) (_To - _From) << 1L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putChars(_Base, __Value, _From, _To);
	}

	@Override
	public void putInts(long _Base, int[] _Value, int _From, int _To) throws Unchecked {
		if (INT_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(_Value, _From + INT_ARRAY_BASE, null, _Base, (long) (_To - _From) << 2L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putInts(_Base, _Value, _From, _To);
	}

	@Override
	public void putFloats(long _Base, float[] _Value, int _From, int _To) throws Unchecked {
		if (FLOAT_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(_Value, _From + FLOAT_ARRAY_BASE, null, _Base, (long) (_To - _From) << 2L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putFloats(_Base, _Value, _From, _To);
	}

	@Override
	public void putLongs(long _Base, long[] _Value, int _From, int _To) throws Unchecked {
		if (LONG_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(_Value, _From + LONG_ARRAY_BASE, null, _Base, (long) (_To - _From) << 3L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putLongs(_Base, _Value, _From, _To);
	}

	@Override
	public void putDoubles(long _Base, double[] _Value, int _From, int _To) throws Unchecked {
		if (DOUBLE_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(_Value, _From + DOUBLE_ARRAY_BASE, null, _Base, (long) (_To - _From) << 3L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.putDoubles(_Base, _Value, _From, _To);
	}

	@Override
	public void getBytes(long _Base, byte[] _Value, int _From, int _To) throws Unchecked {
		if (BYTE_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + BYTE_ARRAY_BASE, (long) (_To - _From));
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getBytes(_Base, _Value, _From, _To);
	}

	@Override
	public void getBooleans(long _Base, boolean[] _Value, int _From, int _To) throws Unchecked {
		if (BOOLEAN_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + BOOLEAN_ARRAY_BASE, (long) (_To - _From));
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getBooleans(_Base, _Value, _From, _To);
	}

	@Override
	public void getShorts(long _Base, short[] _Value, int _From, int _To) throws Unchecked {
		if (SHORT_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + SHORT_ARRAY_BASE, (long) (_To - _From) << 1L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getShorts(_Base, _Value, _From, _To);
	}

	@Override
	public void getChars(long _Base, char[] _Value, int _From, int _To) throws Unchecked {
		if (CHAR_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + CHAR_ARRAY_BASE, (long) (_To - _From) << 1L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getChars(_Base, _Value, _From, _To);
	}

	@Override
	public void getFloats(long _Base, float[] _Value, int _From, int _To) throws Unchecked {
		if (FLOAT_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + FLOAT_ARRAY_BASE, (long) (_To - _From) << 2L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getFloats(_Base, _Value, _From, _To);
	}

	@Override
	public void getInts(long _Base, int[] _Value, int _From, int _To) throws Unchecked {
		if (INT_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + INT_ARRAY_BASE, (long) (_To - _From) << 2L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getInts(_Base, _Value, _From, _To);
	}

	@Override
	public void getLongs(long _Base, long[] _Value, int _From, int _To) throws Unchecked {
		if (LONG_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + LONG_ARRAY_BASE, (long) (_To - _From) << 3L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getLongs(_Base, _Value, _From, _To);
	}

	@Override
	public void getDoubles(long _Base, double[] _Value, int _From, int _To) throws Unchecked {
		if (DOUBLE_ARRAY_BASE != -1 && copyMemoryRef != null) try {
			copyMemoryRef.invoke(null, _Base, _Value, _From + DOUBLE_ARRAY_BASE, (long) (_To - _From) << 3L);
			return;
		} catch (Throwable ignored) {
		}
		MemAccessor.super.getDoubles(_Base, _Value, _From, _To);
	}
}
// */