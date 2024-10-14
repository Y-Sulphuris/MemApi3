package com.ydo4ki.memapi3;

/**
 * Interface that extends {@link MemAllocator} with {@link AutoCloseable}.
 * <p>
 * Implementations of this interface are expected to release any allocated memory
 * when the {@link #close()} method is called.
 * <p>
 *
 * @author Sulphuris
 * @since 11.10.2024 22:16
 */
public interface MemAllocatorCloseable extends MemAllocator, AutoCloseable {
	/**
	 * Closes this allocator and releases any allocated memory.
	 * <p>
	 * After calling this method, any {@link MemAllocator} methods may throw
	 * {@link IllegalStateException} or {@link NullPointerException}.
	 * <p>
	 * Implementations of this interface are expected to release any allocated memory
	 * when this method is called.
	 * <p>
	 */
	@Override
	void close();
}

