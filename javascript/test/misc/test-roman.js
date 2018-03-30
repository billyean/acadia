'use strict'

var Roman = require('../../js/misc/roman')
var assert = require('assert')

describe('Roman', function(){
    var intWithRome = [
        {digits: 1, rome: "I"},
        {digits: 2, rome: "II"},
        {digits: 3, rome: "III"},
        {digits: 4, rome: "IV"},
        {digits: 5, rome: "V"},
        {digits: 6, rome: "VI"},
        {digits: 7, rome: "VII"},
        {digits: 8, rome: "VIII"},
        {digits: 9, rome: "IX"},
        {digits: 10, rome: "X"},
        {digits: 11, rome: "XI"},
        {digits: 12, rome: "XII"},
        {digits: 13, rome: "XIII"},
        {digits: 14, rome: "XIV"},
        {digits: 15, rome: "XV"},
        {digits: 16, rome: "XVI"},
        {digits: 17, rome: "XVII"},
        {digits: 18, rome: "XVIII"},
        {digits: 19, rome: "XIX"},
        {digits: 20, rome: "XX"},
        {digits: 21, rome: "XXI"},
        {digits: 22, rome: "XXII"},
        {digits: 23, rome: "XXIII"},
        {digits: 24, rome: "XXIV"},
        {digits: 25, rome: "XXV"},
        {digits: 26, rome: "XXVI"},
        {digits: 27, rome: "XXVII"},
        {digits: 28, rome: "XXVIII"},
        {digits: 29, rome: "XXIX"},
        {digits: 30, rome: "XXX"},
        {digits: 49, rome: "XLIX"},
        {digits: 50, rome: "L"},
        {digits: 51, rome: "LI"},
        {digits: 59, rome: "LIX"},
        {digits: 60, rome: "LX"},
        {digits: 61, rome: "LXI"},
        {digits: 69, rome: "LXIX"},
        {digits: 70, rome: "LXX"},
        {digits: 71, rome: "LXXI"},
        {digits: 3499, rome: "MMMCDXCIX"}
    ];
    describe('#toRome', function(){
        it('digits should map to rome', function(){
            let roman = new Roman();
            intWithRome.forEach(v => {
                assert.equal(v.rome, roman.toRome(v.digits));
            });
        })
    });

    describe('#toDigits', function(){
        it('rome should map to digits', function(){
            let roman = new Roman();
            intWithRome.forEach(v => {
                assert.equal(v.digits, roman.toDigits(v.rome));
            });
        })
    });
});