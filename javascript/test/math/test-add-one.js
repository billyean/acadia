'use strict'

var add1 = require('../../js/math/add-one')
var assert = require('assert')

describe('Addone', function(){
    describe('#add1', function(){
        it('add1([1, 1, 1]) should return [1, 1, 2]', function(){
            assert.deepEqual([1, 1, 2], add1([1, 1, 1]));
        })

        it('add1([1, 1, 9]) should return [1, 2, 0]', function(){
            assert.deepEqual([1, 2, 0], add1([1, 1, 9]));
        })

        it('add1([9, 9, 9, 9]) should return [1, 0, 0, 0, 0]', function(){
            assert.deepEqual([1, 0, 0, 0, 0], add1([9, 9, 9, 9]));
        })
    })
})