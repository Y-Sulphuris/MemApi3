package com.ydo4ki.memapi3;
/**
 * This interface is a combination of {@link MemAllocatorManual} and {@link MemAllocatorCloseable}.
 * <p>
 * This interface is used when you want to manually manage memory and you want to be able to close the memory allocator.
 * <p>
 * All methods marked {@link Unchecked} if operation is unsafe.
 * <p>
 *
 * @author Sulphuris
 * @since 11.10.2024 13:21
 */
public interface MemAllocatorManualCloseable extends MemAllocatorManual, MemAllocatorCloseable {
	@Override
	long allocateMemory(long _Size, long _Alignment) throws Unchecked;

	@Override
	void deallocateMemory(long _Mem) throws Unchecked;

	@Override
	void close();
}
