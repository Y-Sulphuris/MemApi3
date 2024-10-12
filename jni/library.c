#include <memory.h>
#include <string.h>
#include <malloc.h>
#include "com_ydo4ki_memapi3_AccessorJniDirect.h"



JNIEXPORT jbyte JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getByte
	(JNIEnv *, jobject, jlong _Addr) {
	return *((jbyte*)_Addr);
}


JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putByte
	(JNIEnv *, jobject, jlong _Addr, jbyte _Val) {
	*((jbyte*)_Addr) = _Val;
}


JNIEXPORT jshort JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getShort
	(JNIEnv *, jobject, jlong _Addr) {
	return *((jshort*)_Addr);
}


JNIEXPORT jshort JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getShortAligned
	(JNIEnv *, jobject, jlong _Addr) {
	return *((jshort*)_Addr);
}


JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putShort
	(JNIEnv *, jobject, jlong _Addr, jshort _Val) {
	*((jshort*)_Addr) = _Val;
}


JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putShortAligned
	(JNIEnv *, jobject, jlong _Addr, jshort _Val) {
	*((jshort*)_Addr) = _Val;
}


JNIEXPORT jint JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getInt
	(JNIEnv *, jobject, jlong _Addr) {
	return *((jint*)_Addr);
}

JNIEXPORT jint JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getIntAligned
	(JNIEnv *, jobject, jlong _Addr) {
	return *((jint*)_Addr);
}


JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putInt
	(JNIEnv *, jobject, jlong _Addr, jint _Val) {
	*((jint*)_Addr) = _Val;
}


JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putIntAligned
	(JNIEnv *, jobject, jlong _Addr, jint _Val) {
	*((jint*)_Addr) = _Val;
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getLong
	(JNIEnv *, jobject, jlong _Addr) {
	return *(jlong*)_Addr;
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getLongAligned
	(JNIEnv *, jobject, jlong _Addr) {
	return *(jlong*)_Addr;
}

JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putLong
	(JNIEnv *, jobject, jlong _Addr, jlong _Val) {
	*(jlong*)_Addr = _Val;
}

JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putLongAligned
	(JNIEnv *, jobject, jlong _Addr, jlong _Val) {
	*(jlong*)_Addr = _Val;
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getAddress
	(JNIEnv *, jobject, jlong _Addr) {
	return *(size_t*)_Addr;
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_getAddressAligned
	(JNIEnv *, jobject, jlong _Addr) {
	return *(size_t*)_Addr;
}

JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putAddress
	(JNIEnv *, jobject, jlong _Addr, jlong _Val) {
	*(size_t*)_Addr = _Val;
}

JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_putAddressAligned
	(JNIEnv *, jobject, jlong _Addr, jlong _Val) {
	*(size_t*)_Addr = _Val;
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_copyMemory
	(JNIEnv *, jobject, jlong _Dst, jlong _Src, jlong _Bytes) {
	return (jlong)memcpy((void*)_Dst, (void*)_Src, _Bytes);
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_moveMemory
	(JNIEnv *, jobject, jlong _Dst, jlong _Src, jlong _Bytes) {
	return (jlong)memmove((void*)_Dst, (void*)_Src, _Bytes);
}

JNIEXPORT jint JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_compareMemory
	(JNIEnv *, jobject, jlong _Buf1, jlong _Buf2, jlong _Bytes) {
	return memcmp((void*)_Buf1, (void*)_Buf2, _Bytes);
}

JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_setMemory
	(JNIEnv *, jobject, jlong _Dst, jbyte _Val, jlong _Size) {
	memset((void*)_Dst, _Val, _Size);
}

JNIEXPORT jint JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_addressSize
	(JNIEnv *, jobject) {
	return sizeof(size_t);
}

#if defined(WIN32) || defined(_WIN32) || defined(__WIN32__) || defined(__NT__)
#define aligned_alloc _aligned_malloc
#define free _aligned_free
#elif __APPLE__
#include <TargetConditionals.h>
    #if TARGET_IPHONE_SIMULATOR
         // iOS, tvOS, or watchOS Simulator
    #elif TARGET_OS_MACCATALYST
         // Mac's Catalyst (ports iOS API into Mac, like UIKit).
    #elif TARGET_OS_IPHONE
        // iOS, tvOS, or watchOS device
    #elif TARGET_OS_MAC
        // Other kinds of Apple platforms
    #else
    #   error "Unknown Apple platform"
    #endif
#elif __ANDROID__
    // Below __linux__ check should be enough to handle Android,
    // but something may be unique to Android.
#elif __linux__
    // linux
#elif __unix__ // all unices not caught above
    // Unix
#elif defined(_POSIX_VERSION)
    // POSIX
#else
#   error "Unknown compiler"
#endif

JNIEXPORT void JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_deallocateMemory
	(JNIEnv *, jobject, jlong _Memory) {
	free((void*)_Memory);
}

JNIEXPORT jlong JNICALL Java_com_ydo4ki_memapi3_AccessorJniDirect_allocateMemory0
	(JNIEnv *, jclass, jlong _Size, jlong _Alignment) {
	return (jlong)aligned_alloc(_Size, _Alignment);
}

