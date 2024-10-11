package com.ydo4ki.memapi3;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:49
 */
public class Mem {

	private static final MemAccessor accessor = getAccessor();

	private static MemAccessor getAccessor() {
		try {
			return new AccessorForeign();
		} catch (ExceptionInInitializerError e) {
			try {
				//return new AccessorUnsafe();
			} catch (Throwable ee) {
				//return new AccessorJniDirect();
			}
			throw e;
		}
	}

	public static MemAccessor memoryAccessor() {
		return accessor;
	}
}
