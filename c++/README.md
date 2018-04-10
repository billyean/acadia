# Using it in IDE

This is a CMake project that it can be easily import into a CMake supported IDE like CLion. Code has been successfully verified in GCC 6 and CLang 9.0.0.

# C++ Version

Bear in mind I am using some C++ 11 feature in my code, it's better upgrade your c++ compiler to latest version. This is fine in Mac OSX, but it doesn't_ work in my Ubuntu 16.04. I managed to upgrade my gcc version to 6.3.0 as follows:
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

# Caveat

* C++ 11's regex_match must be exact matched, which you can't_ match partial of content.
```c++
    string s = "abc123 123 145";
    bool b1 = regex_match("[a-zA-Z]+[0-9]+ [0-9]+"); // here b1 is 0
    bool b2 = regex_match("[a-zA-Z]+[0-9]+ [0-9]+.*"); // here b2 is 1
```
* Look for multiple match of regular expression, you need use regex_search
```c++
    regex r("^([A-Za-z]+)([0-9]+) (.+)");
    regex_search(s1, matches, r);
    for (auto m : matches) {
        // handle m here.
    }
``` 
* In some compiler(like CLang), C++ won't_ initiate pointer to NULL, better initiate member with default value.
* map in STL is ordered.
* Syntax of tuple in C++ is a little bit weird. you have to use get<n>(here n is tuple position) to get nth value.