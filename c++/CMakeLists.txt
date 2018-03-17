cmake_minimum_required (VERSION 2.8.11)
project (Algorithm)

# Download and unpack googletest at configure time
configure_file(CMakeLists.txt.in googletest-download/CMakeLists.txt)
execute_process(COMMAND ${CMAKE_COMMAND} -G "${CMAKE_GENERATOR}" .
        RESULT_VARIABLE result
        WORKING_DIRECTORY ${CMAKE_BINARY_DIR}/googletest-download )
if(result)
    message(FATAL_ERROR "CMake step for googletest failed: ${result}")
endif()
execute_process(COMMAND ${CMAKE_COMMAND} --build .
        RESULT_VARIABLE result
        WORKING_DIRECTORY ${CMAKE_BINARY_DIR}/googletest-download )
if(result)
    message(FATAL_ERROR "Build step for googletest failed: ${result}")
endif()

# Prevent overriding the parent project's compiler/linker
# settings on Windows
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)

# Prevent overriding the parent project's compiler/linker
# settings on Windows
set(gtest_force_shared_crt ON CACHE BOOL "" FORCE)

# Add googletest directly to our build. This defines
# the gtest and gtest_main targets.
add_subdirectory(${CMAKE_BINARY_DIR}/googletest-src
        ${CMAKE_BINARY_DIR}/googletest-build
        EXCLUDE_FROM_ALL)
# The gtest/gtest_main targets carry header search path
# dependencies automatically when using CMake 2.8.11 or
# later. Otherwise we have to add them here ourselves.
if (CMAKE_VERSION VERSION_LESS 2.8.11)
    include_directories("${gtest_SOURCE_DIR}/include")
endif()

add_executable(algorithm algorithm/datastructure/MedianFinder.h algorithm/datastructure/MedianFinder.cpp algorithm_tests/datastructure/MedianFinderTest.cpp algorithm/datastructure/FenwickTree.cpp algorithm/datastructure/FenwickTree.h algorithm_tests/datastructure/FenwickTreeTest.cpp algorithm/math/ArrangeCoins.cpp algorithm_tests/math/ArrangeCoinsTest.cpp algorithm/math/ArrangeCoins.h algorithm/array/Zigzag.cpp algorithm/array/Zigzag.h algorithm_tests/array/ZigzagTest.cpp algorithm/array/SlidingWindow.cpp algorithm/array/SlidingWindow.h algorithm/array/RemoveDuplicate.cpp algorithm/array/RemoveDuplicate.h algorithm_tests/array/RemoveDuplicateTest.cpp algorithm/stack/MinStack.cpp algorithm/stack/MinStack.h algorithm_tests/stack/MinStackTest.cpp algorithm/misc/BinaryWatch.cpp algorithm/misc/BinaryWatch.h algorithm_tests/misc/BinaryWatchTest.cpp algorithm/misc/RomeDigits.cpp algorithm/misc/RomeDigits.h algorithm_tests/misc/RomeDigitsTest.cpp algorithm/misc/Anagram.cpp algorithm/misc/Anagram.h algorithm/str/RemoveLetters.cpp algorithm/str/RemoveLetters.h algorithm_tests/str/RemoveLettersTest.cpp algorithm/str/ZSort.cpp algorithm/str/ZSort.h algorithm_tests/str/ZSortTest.cpp algorithm/dp/Fibonacci.cpp algorithm/dp/Fibonacci.h algorithm_tests/dp/FibonacciTest.cpp algorithm/math/Utilities.cpp algorithm/math/Utilities.h algorithm_tests/math/UtilitiesTest.cpp)
target_link_libraries(algorithm gtest_main)
add_test(NAME algorithm_test COMMAND algorithm)