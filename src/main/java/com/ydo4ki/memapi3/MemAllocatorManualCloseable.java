package com.ydo4ki.memapi3;

public interface MemAllocatorManualCloseable extends MemAllocatorManual, MemAllocatorCloseable {
	@Override
	long allocateMemory(long _Size, long _Alignment) throws Unchecked;

	@Override
	void deallocateMemory(long _Mem) throws Unchecked;

	@Override
	void close();
}
