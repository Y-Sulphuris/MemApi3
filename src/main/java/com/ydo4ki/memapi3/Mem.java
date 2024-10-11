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
		} catch (ExceptionInInitializerError e) {
			try {
				//return new AccessorUnsafe();
			} catch (Throwable ee) {
				//return new AccessorJniDirect();
			}
			throw e;
		}
	}

	public static MemAccessor memoryAccessor() {
		return accessor;
	}


	public static void printMemory(PrintStream out, long mem, long size) {
		printMemory(out, mem, size, 4, 4);
	}

	public static void printMemory(PrintStream out, long mem, long size, int colSize, int colCount) {
		for (int i = 0; i < size; i++) {
			if (i % (colSize * colCount) == 0)
				out.print((i == 0 ? "" : "\n") + "[" + String.format("%08x", i + mem) + "] (+" + String.format("%04x", i) + ")\t");
			try {
				out.printf("%02x ", accessor.getByte(mem + i));
			} catch (Unchecked e) {
				throw e.noreturn();
			}
			if (i % colSize == colSize - 1) out.print("  ");
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
			if ((i + Math.abs(offset)) % (colSize * colCount) == 0) {
				out.print((i == offset ? "" : "\n") +
						"[" + String.format("%08x", i + mem) + "] (" +
						(i >= 0 ? ("+" + String.format(brFormat, i)) : ("-" + String.format(brFormat, -i))) +
						")\t");
			}
			if (i >= size) {
				out.print("__ ");
			} else {
				byte b = 0;
				try {
					b = accessor.getByte(mem + i);
				} catch (Unchecked e) {
					throw e.noreturn();
				}
				out.printf("%02x ", b);
				if (ascii) {
					char ch = (char) b;
					if (Character.isWhitespace(ch)) ch = ' ';
					else if (!Character.isDefined(ch) || b <= 9) ch = '.';
					asciiBuilder.append(ch);
				}
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
