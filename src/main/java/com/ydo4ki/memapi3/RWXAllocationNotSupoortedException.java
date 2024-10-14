package com.ydo4ki.memapi3;

/**
 * This exception is thrown if {@link MemAllocator}  does not support
 * allocating memory with flags {@code rwx} (memory that is readable, writable and executable)
 *
 * @author Sulphuris
 * @since 13.10.2024 20:50
 */
public class RWXAllocationNotSupoortedException extends Exception {
	public RWXAllocationNotSupoortedException(Throwable cause) {
		super(cause);
	}

	public RWXAllocationNotSupoortedException() {
	}
}
