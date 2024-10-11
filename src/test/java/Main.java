import com.ydo4ki.memapi3.Mem;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

public class Main {
	public static void main(String[] args) throws Throwable {
		System.out.println(Mem.memoryAccessor().allocateMemory(100, 200));;

	}
}