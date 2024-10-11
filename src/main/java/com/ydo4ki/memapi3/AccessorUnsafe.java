package com.ydo4ki.memapi3;
/*
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:50
 *
final class AccessorUnsafe {
	private static final Unsafe theUnsafe = getUnsafe();

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
			return null;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	private static final AccessorJniDirect fallback = new AccessorJniDirect();
}
*/