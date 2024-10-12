package com.ydo4ki.memapi3;

public interface MemAllocatorCloseable extends MemAllocator, AutoCloseable {
	@Override
	void close();
}

