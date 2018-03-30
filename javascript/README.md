# Caveat

* My node version is 9.8.0
```
$ node -v
v9.8.0
```
* [Mocha](https://mochajs.org/) is the test framework that is using.
* I am having trouble to make import with node 9.8.0. Gave up by using require instead.
* looks like array compare with === doesn't return true even when length and elements are same, need to figure out why.
* Javascript's sort with function suprises me that you have to set a > b when a is less than b.