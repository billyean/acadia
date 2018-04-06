'use strict'

var assert = require('assert')

describe('Reverse', function() {
    describe('#reverse', function () {
        it('reverse([1, 2, 3, 4, 5]) should return [5, 4, 3, 2, 1]', function () {
            assert.deepEqual([5, 4, 3, 2, 1], [1, 2, 3, 4, 5].reverse());
        });
    });
});