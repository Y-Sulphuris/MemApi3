package com.ydo4ki.memapi3;


/**
 * Interface for memory allocators.
 *
 * @author Sulphuris
 * @see MemAllocator#allocateMemory(long, long)
 * @see MemAllocator#scopeBase()
 * @see MemAllocator#scopeSize()
 * @see MemAllocator#allocRWX(long)
 * @since 11.10.2024 16:23
 */
public interface MemAllocator {
	
	/**
	 * The base address of scope that in which allocations occur.<p>
	 * Some allocators may allocate memory blocks relative to a certain base address.
	 * This method returns the base address of the scope in which allocations occur.
	 * @return the base address of the scope in which allocations occur
	 * @since 1.0
	 */
	default long scopeBase() {
		return 0;
	}
	
	/**
	 * The size of the scope in which allocations occur.<p>
	 * Some allocators may allocate memory blocks relative to a certain base address.
	 * This method returns the size of the scope in which allocations occur.
	 * @return the size of the scope in which allocations occur
	 * @since 1.0
	 */
	default long scopeSize() {
		return Long.MAX_VALUE;
	}
	
	/**
	 * Allocates memory block with given size and alignment.
	 *
	 * @param _Size      the size of the memory block to allocate
	 * @param _Alignment the alignment of the memory block to allocate
	 * @return the address of the allocated memory block
	 * @throws Unchecked                if allocation failed
	 * @throws IllegalArgumentException if _Size or _Alignment is invalid
	 * @since 1.0
	 */
	long allocateMemory(long _Size, long _Alignment) throws Unchecked, IllegalArgumentException;
	
	
	/**
	 * Allocates memory block with given size and with flags {@code rwx} (readable, writable and executable).<p>
	 * If this allocator does not support allocating memory with flags {@code rwx}, it should throw {@link RWXAllocationNotSupportedException}.
	 * @param size the size of the memory block to allocate
	 * @return the address of the allocated memory block
	 * @throws Unchecked                          if allocation failed
	 * @throws RWXAllocationNotSupportedException if allocation of memory with flags {@code rwx} is not supported
	 * @since 1.0
	 */
	default long allocRWX(long size) throws Unchecked, RWXAllocationNotSupportedException {
		throw new RWXAllocationNotSupportedException();
	}
}
