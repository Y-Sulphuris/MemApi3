cmake_minimum_required(VERSION 3.28)
project(jni C)

set(CMAKE_C_STANDARD 11)

#unix
#include_directories(/root/.jdks/corretto-1.8.0_392/include)
#include_directories(/root/.jdks/corretto-1.8.0_392/include/linux)

#windows
include_directories(C:/Users/lidia/.jdks/corretto-1.8.0_372/include)
include_directories(C:/Users/lidia/.jdks/corretto-1.8.0_372/include/win32)
include_directories(G:/Project/CLionProjects/JNIDirect/jni)

set(CMAKE_CXX_FLAGS "-O3 -Wall -Wextra")
# set(CMAKE_CXX_FLAGS_DEBUG "-g")
# set(CMAKE_CXX_FLAGS_RELEASE "-O3")


add_library(jni SHARED library.c)

find_library(JNIDIRECT libJNIDirect lib)
target_link_libraries(jni LINK_PUBLIC ${JNIDIRECT})
