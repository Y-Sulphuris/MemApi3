package com.ydo4ki.memapi3;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(value = 1)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class Main {

	static {
		System.out.println(Mem.memoryAccessor());
	}

	public static void main(String[] args) throws Throwable {
		MemAccessor accessor = Mem.memoryAccessor();
		long mem = accessor.allocateMemory(0x20, 0x10);



		accessor.putBytes(mem+4, 'h', 'e', 5, 'l');
		accessor.copyMemory(mem, mem+4, 8);
		System.out.println(mem);
		byte[] bytes = new byte[0x10];
		accessor.getBytes(mem, bytes);
		System.out.println(Arrays.toString(bytes));
		Mem.printMemory(System.out, mem, 0x10, true);
		System.out.println(accessor.getLong(mem));
		System.out.println(accessor.getLong(mem+1));
	}

	private static final MemAccessor accessor = Mem.memoryAccessor();

	private static final long memory = Unchecked.suppress(() -> accessor.allocateMemory(32, 8));



	// foreign: 0,874 ± 0,437  ns/op
	// unsafe:  3,808 ± 0,904  ns/op ????? (something wrong with it)
	// jni:     8,995 ± 0,573  ns/op
	@Benchmark
	public void measureAccessorGetLong(Blackhole bh) {
		try {
			bh.consume(accessor.getLong(memory));
		} catch (Unchecked e) {
			throw e.noreturn();
		}
	}
	/*@Benchmark
	public void measureAccessorGetLongUnsafeMH(Blackhole bh) {
		try {
			bh.consume((long)AccessorUnsafe.getLong.invokeExact(memory));
		} catch (Unchecked e) {
			throw e.noreturn();
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}*/
	@Benchmark
	public void measureAccessorGetLongUnsafeDirectly(Blackhole bh) {
		try {
			bh.consume((long)AccessorUnsafe.unsafe.getLong(memory));
		} catch (Throwable e) {
			throw Unchecked.pass(e);
		}
	}
}
