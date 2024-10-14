package com.ydo4ki.memapi3;

/**
 * Memory allocator interface that allows manual memory deallocation.
 *
 * @see MemAllocator
 *
 * @author Sulphuris
 * @since 11.10.2024 13:21
 */

public interface MemAllocatorManual extends MemAllocator {

	void deallocateMemory(long _Mem) throws Unchecked;
}

