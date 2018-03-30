'use strict'

var sort_by_ones = require('../../js/math/sort-by-ones')
var assert = require('assert')

describe('SortByOnes', function() {
    describe('#sort_by_ones', function () {
        it('sort_by_ones([1, 2, 3, 4, 5]) should return [1, 2, 4, 3, 5]', function () {
            var actual = sort_by_ones([1, 2, 3, 4, 5]);

            assert.deepEqual([1, 2, 4, 3, 5], actual);
        });

        it('sort_by_ones([1, -1, 2, - 2, 3, -3]) should return [1, 2, 3, -2, -3, -1]', function () {
            var actual = sort_by_ones([1, -1, 2, - 2, 3, -3]);

            assert.deepEqual([1, 2, 3, -2, -3, -1], actual);
        });

        it('sort_by_ones([]) should return []', function () {
            var actual = sort_by_ones([]);

            assert.deepEqual([], actual);
        });

        it('sort_by_ones([3]) should return [3]', function () {
            var actual = sort_by_ones([3]);

            assert.deepEqual([3], actual);
        });
    });
});