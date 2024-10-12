package com.ydo4ki.memapi3;
/*
import sun.misc.Unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:50
 *
final class AccessorUnsafe implements MemAccessor {
	private static final Unsafe unsafe = getUnsafe();

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

	private static MethodHandle findSunUnsafeMethod(String methodName, Class<?> returnType, Class<?>... args) {
		try {
			return findMethod(methodName, unsafe, returnType, args);
		} catch (Throwable e) {
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
	public long copyMemory(long _Dst, long _Src, long _Bytes) throws Unchecked {
		try {
			copyMemory.invokeExact(_Dst, _Src, _Bytes);
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
		return _Dst;
	}

	@Override
	public long moveMemory(long _Dst, long _Src, long _Bytes) throws Unchecked {
		return fallback.moveMemory(_Dst, _Src, _Bytes);
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
}
*/