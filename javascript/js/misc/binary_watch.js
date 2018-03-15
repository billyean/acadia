class BinaryWatch {
    constructor() {
        this.cache = new Map()
        for (let h = 0; h < 12; h++) {
            for (let m = 0; m < 60; m++) {
                const b = bits(h, m)
                const s = formatHM(h, m)
                if (this.cache.has(b)) {
                    this.cache.get(b).push(s)
                } else {
                    this.cache.set(b, [s])
                }
            }
        }
    }

    bits(h, n) {
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
        const fms = ms.length() == 1 ? "0" : "" + ms
        return `${hs}:${fms}`;
    }

    watchN(n) {
        if (n < 0 || n > 8) {
            return [];
        } else {
            return this.cache.get(n);
        }
    }
}