package com.ydo4ki.memapi3;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class Main {


	public static void main(String[] args) throws Throwable {
		System.out.println(Mem.memoryAccessor());
		long mem = Mem.memoryAccessor().allocateMemory(0x10, 0x10);
		System.out.println(mem);
		Mem.printMemory(System.out, mem, 0x10, true);
	}

	private static final MemAccessor accessor = Mem.memoryAccessor();

	private static final long memory = Unchecked.suppress(() -> accessor.allocateMemory(32, 8));



	// foreign: 0,874 ± 0,437  ns/op
	// unsafe:  0,353 ± 0,099  ns/op ????? (something wrong with it)
	// jni:
	@Benchmark
	public void measureAccessorGetLong(Blackhole bh) {
		try {
			bh.consume(accessor.getLong(memory));
		} catch (Unchecked e) {
			throw e.noreturn();
		}
	}
}
