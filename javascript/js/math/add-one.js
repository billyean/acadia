function add1(s) {
    var c = 1;
    var r = [];
    for (var i = s.length - 1; i >= 0; i--) {
        const v = s[i] + c;
        r.push(v == 10 ? 0 : v);
        c = v == 10 ? 1 : 0;
    }

    if (c != 0) {
        r.push(1);
    }

    return r.reverse();
}

module.exports = add1;