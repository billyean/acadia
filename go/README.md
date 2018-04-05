# Caveat

* Go has obsession on the test name should be end up with test.
* ==, != is not working on array or map, I have to use reflect.deepEqual
* Go's range is very similar to Python's enumerated method, first element is index
```
for _, c := range s {
    ms[c] += 1
}
```
* Go doesn't have tuple like Python and Scala, but it's easy to implement with struct.
* Be cautious don't name local variable same name as package name, function name

# Simplicity

* Go's unit test won't stop even if the assertion failed in the same method.