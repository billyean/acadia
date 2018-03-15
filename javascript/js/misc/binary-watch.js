class BinaryWatch {
    bits(h, m) {
        var b = 0;

        while (h > 0) {
            h -= h & -h;
            b += 1;
        }

        while (m > 0) {
            m -= m & -m;
            b += 1;
        }

        return b
    }

    formatHM(h, m) {
        const hs = h.toString();
        const ms = m.toString();
        const fms = (ms.length == 1 ? "0" : "") + ms
        return `${hs}:${fms}`;
    }

    constructor() {
        this.cache = new Map()
        for (let h = 0; h < 12; h++) {
            for (let m = 0; m < 60; m++) {
                const b = this.bits(h, m)
                const s = this.formatHM(h, m)
                if (this.cache.has(b)) {
                    this.cache.get(b).push(s)
                } else {
                    this.cache.set(b, [s])
                }
            }
        }
    }

    watchN(n) {
        if (n < 0 || n > 8) {
            return [];
        } else {
            return this.cache.get(n);
        }
    }
}

module.exports = BinaryWatch;