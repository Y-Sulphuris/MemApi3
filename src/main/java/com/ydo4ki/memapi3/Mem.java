package com.ydo4ki.memapi3;

import java.io.PrintStream;

/**
 * @author Sulphuris
 * @since 11.10.2024 12:49
 */
public class Mem {

	private static final MemAccessor accessor = getAccessor();

	private static MemAccessor getAccessor() {
		try {
			return new AccessorForeign();
		} catch (Throwable e) {
			boolean givePriorityToJni = true;
			try {
				if (givePriorityToJni) return new AccessorJniDirect();
				return new AccessorUnsafe();
			} catch (Throwable ee) {
				return new AccessorJniDirect();
			}
		}
	}

	public static MemAccessor memoryAccessor() {
		return accessor;
	}

	public static final int ADDRESS_SIZE = memoryAccessor().addressSize();


	static boolean jniLibraryLoaded = false;

	public static boolean jniLibraryLoaded() {
		return jniLibraryLoaded;
	}


	public static void printMemory(PrintStream out, long mem, long size) {
		printMemory(out, mem, size, 4, 4);
	}

	public static void printMemory(PrintStream out, long mem, long size, int colSize, int colCount) {
		for (int i = 0; i < size; i++) try {
			final long addr = i + mem;
			if (i % (colSize * colCount) == 0)
				out.print((i == 0 ? "" : "\n") + "[" + String.format("%08x", addr) + "] (+" + String.format("%04x", i) + ")\t");
			out.printf("%02x ", accessor.getByte(addr));
			if (i % colSize == colSize - 1) out.print("  ");
		} catch (Unchecked e) {
			throw e.noreturn();
		}

		out.println();
	}

	public static void printMemory(PrintStream out, long mem, long size, boolean ascii) {
		printMemory(out, mem, size, 4, 4, ascii);
	}

	public static void printMemory(PrintStream out, long mem, long size, int colSize, int colCount, boolean ascii) {
		printMemory(out, mem, size, colSize, colCount, 0, ascii);
	}

	public static void printMemory(PrintStream out, long mem, long size, int colSize, int colCount, int offset, final boolean ascii) {
		StringBuilder asciiBuilder = new StringBuilder(colSize * colCount);
		offset = (int) align(offset, (long) colSize * colCount);
		long length = align(size, (long) colSize * colCount);


		String brFormat = "%0" + (Math.max(String.valueOf(length).length(), String.valueOf(offset).length())) + "x";

		for (int i = offset; i < length; i++) {
			final long addr = i + mem;
			if ((i + Math.abs(offset)) % (colSize * colCount) == 0) {
				out.print((i == offset ? "" : "\n") +
						"[" + String.format("%08x", addr) + "] (" +
						(i >= 0 ? ("+" + String.format(brFormat, i)) : ("-" + String.format(brFormat, -i))) +
						")\t");
			}
			if (i >= size) {
				out.print("__ ");
			} else try {
				byte b = accessor.getByte(addr);
				out.printf("%02x ", b);
				if (ascii) {
					char ch = (char) b;
					if (Character.isWhitespace(ch)) ch = ' ';
					else if (!Character.isDefined(ch) || b <= 9) ch = '.';
					asciiBuilder.append(ch);
				}
			} catch (Unchecked e) {
				throw e.noreturn();
			}


			if (unsignedMod(i, colSize) == colSize - 1) out.print("  ");

			if ((i + 1) % (colSize * colCount) == 0) {
				if (ascii && i != 0) {
					out.print("\t" + asciiBuilder);
					asciiBuilder.setLength(0);
				}
			}
		}
		out.println();
	}


	public static long align(long address, long alignment) {
		if (address < 0) {
			return address - (alignment + address % alignment) % alignment;
		} else {
			long m = address % alignment;
			if (m == 0) return address;
			return address + alignment - m;
		}
	}

	private static int unsignedMod(int a, int b) {
		return a >= 0 ? a % b : (b + a % b) % b;
	}
}
