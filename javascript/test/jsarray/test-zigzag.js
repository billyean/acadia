'use strict'

var convert = require('../../js/jsarray/zigzag')
var assert = require('assert')

describe('Zigzag', function(){
    describe('#convert', function(){
        it('zigzag(PAYPALISHIRING, 3) should return PAHNAPLSIIGYIR', function(){
            assert.equal('PAHNAPLSIIGYIR', convert('PAYPALISHIRING', 3));
        })

        it('zigzag(ABC, 2) should return ACB', function(){
            assert.equal('ACB', convert('ABC', 2));
        })
    })
})