# Using it in IDE

This is a CMake project that it can be easily import into a CMake supported IDE like CLion. Code has been successfully verified in GCC 6 and CLang 9.0.0.

# C++ Version

Bear in mind I am using some C++ 11 feature in my code, it's better upgrade your c++ compiler to latest version. This is fine in Mac OSX, but it doesn't work in my Ubuntu 16.04. I managed to upgrade my gcc version to 6.3.0 as follows:
```bash
sudo apt-get update
sudo apt-get install build-essential software-properties-common -y
sudo add-apt-repository ppa:ubuntu-toolchain-r/test -y
sudo apt-get update
sudo apt-get install gcc-snapshot -y
sudo apt-get update
sudo apt-get install gcc-6 g++-6 -y
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-6 60 --slave /usr/bin/g++ g++ /usr/bin/g++-6
```

# Unit Test
I am using [Google test](https://github.com/google/googletest) as test framework. Since I use some gmock macro that you have to run gmock_main target if you want to run all the tests. gtest_main will only run partial of tests.
