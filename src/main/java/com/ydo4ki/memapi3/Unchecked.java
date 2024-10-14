package com.ydo4ki.memapi3;

/**
 * Checked exception to explicitly indicate that called operation is unsafe<br>
 * Creation of real instances of this class is forbidden<br>
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

	@SuppressWarnings("unchecked")
	static <T extends Throwable> Error pass(Throwable e) throws T{
		throw (T)e;
	}

	/**
	 * A functional interface that can throw {@link Unchecked}.<br>
	 * This interface is useful for wrapping code that may throw {@link Unchecked} into a lambda expression
	 * @see java.util.function.Supplier
	 */
	@FunctionalInterface
	public interface UncheckedSupplier<T> {
		/**
		 * Gets a result.
		 *
		 * @return a result
		 * @throws Unchecked indicates that called operation is unsafe
		 */
		T get() throws Unchecked;
	}
	
	
	/**
	 * @return nothing
	 */
	public abstract Error noreturn();
}
