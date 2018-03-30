class Roman {
    constructor() {
        this.romanInt = new Map([
            ['I', 1],
            ['V', 5],
            ['X', 10],
            ['L', 50],
            ['C', 100],
            ['D', 500],
            ['M', 1000]
        ]);

        this.boundaries = [
            {up: 1000, low: 900, upc: 'M', lowc: 'C'},
            {up: 500, low: 400, upc: 'D', lowc: 'C'},
            {up: 100, low: 90, upc: 'C', lowc: 'X'},
            {up: 50, low: 40, upc: 'L', lowc: 'X'},
            {up: 10, low: 9, upc: 'X', lowc: 'I'},
            {up: 5, low: 4, upc: 'V', lowc: 'I'},
            {up: 1, low: 1, upc: 'I', lowc: 'I'}
        ];
    }

    toRome(n) {
        var rome = "";

        for (var i = 0; i < this.boundaries.length; i++) {
            var boundary = this.boundaries[i];
            while (n >= boundary.low) {
                if (n < boundary.up) {
                    rome += boundary.lowc;
                }
                rome += boundary.upc;
                n -= boundary.up;
                if (n < 0) {
                    n += boundary.up - boundary.low;
                }
            }
        }

        return rome;
    }

    toDigits(rome) {
        var digits = 0;
        for (var i = 0; i < rome.length; i++) {
            var c = rome.charAt(i);
            var d = this.romanInt.get(c);

            if (i < rome.length - 1 && d < this.romanInt.get(rome.charAt(i + 1))) {
                digits -= d;
            } else {
                digits += d;
            }
        }
        return digits;
    }
}

module.exports = Roman;