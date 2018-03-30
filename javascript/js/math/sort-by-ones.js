// It's extremely simple to sort array in javascript

function ones(n) {
    var one = 0;
    while (n != 0) {
        n -= n & -n;
        one++;
    }
    return one;
}

function sortByOnes(array) {
    array.sort((a, b) => ones(a) > ones(b));
    return array;
}

module.exports = sortByOnes