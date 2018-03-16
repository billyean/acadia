function convert(s, numRows) {
    if (numRows < 2 || s.length == 0) {
        return s;
    }

    zs = '';

    for (var i = 0; i < numRows; i++) {
        const sp1 = 2 * (numRows - i - 1);
        const sp2 = 2 * i;
        add = true;
        b = i;

        while (b < s.length) {
            zs += s[b];
            if (sp1 == 0) {
                b += sp2;
            } else if (sp2 == 0 || add) {
                b += sp1;
            } else {
                b += sp2;
            }
            add = ! add;
        }
    }

    return zs;
}

module.exports = convert;