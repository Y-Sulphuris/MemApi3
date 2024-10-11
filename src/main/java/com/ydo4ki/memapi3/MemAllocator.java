package com.ydo4ki.memapi3;

public interface MemAllocator {

	long allocateMemory(long _Size, long _Alignment) throws Unchecked;
}
