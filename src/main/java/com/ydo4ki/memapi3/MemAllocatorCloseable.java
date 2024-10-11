package com.ydo4ki.memapi3;

import java.io.Closeable;
import java.io.IOException;

public interface MemAllocatorCloseable extends MemAllocator, AutoCloseable {
	@Override
	void close();
}

