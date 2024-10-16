package com.ydo4ki.memapi3;

/**
 * This exception is thrown if {@link MemAllocator}  does not support
 * allocating memory with flags {@code rwx} (memory that is readable, writable and executable)
 *
 * @author Sulphuris
 * @since 13.10.2024 20:50
 */
public class RWXAllocationNotSupportedException extends Exception {
	
	public RWXAllocationNotSupportedException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new {@code RWXAllocationNotSupportedException} with {@code null} as its detail message.
	 * The cause is not initialized, and may subsequently be initialized by a call to {@link #initCause(Throwable)}.
	 */
	public RWXAllocationNotSupportedException() {
	}
}