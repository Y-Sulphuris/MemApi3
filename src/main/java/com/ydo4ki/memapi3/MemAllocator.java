package com.ydo4ki.memapi3;

public interface MemAllocator {

	default long scopeBase() {
		return 0;
	}

	default long scopeSize() {
		return Long.MAX_VALUE;
	}

	long allocateMemory(long _Size, long _Alignment) throws Unchecked, IllegalArgumentException;
}
