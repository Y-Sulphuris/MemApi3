package com.ydo4ki.memapi3;

import java.util.function.Supplier;

/**
 * Checked exception to explicitly indicate that called operation is unsafe<br>
 * Creation of real objects of this class is forbidden<br>
 * Example of usage:
 * <pre> {@code
 * long myTrustedGetter() {
 *   try {
 *       return Mem.memoryAccessor().getInt(target);
 *   } catch (Unchecked e) {
 *       throw e.noreturn(); // it will never happen
 *   }
 * }}</pre>
 * @author Sulphuris
 * @since 11.10.2024 12:59
 */
public abstract class Unchecked extends Throwable {
	private Unchecked() {}

	// for initialization only
	public static <T> T suppress(UncheckedSupplier<T> o) {
		try {
			return o.get();
		} catch (Unchecked e) {
			throw e.noreturn();
		}
	}

	@FunctionalInterface
	public interface UncheckedSupplier<T> {
		T get() throws Unchecked;
	}


	public abstract Error noreturn();
}
