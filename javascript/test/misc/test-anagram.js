'use strict'

var is_anagram = require('../../js/misc/anagram')
var assert = require('assert')

describe('Anagram', function() {
    describe('#is_anagram', function () {
        it('"anagram" and "nagaram" are anagram', function () {
            assert(is_anagram("anagram", "nagaram"), '"anagram" and "nagaram" are supposed to be anagram');
        });

        it('"rat" and "cat" are not anagram', function () {
            assert(!is_anagram("rat", "cat"), '"rat" and "cat" are supposed to be not anagram');
        });
    });
});