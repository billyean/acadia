function is_anagram(s1, s2) {
    if (s1.length != s2.length) {
        return false;
    }
    var is1 = Array.from({length: 128}, (v, i) => 0);
    var is2 = Array.from({length: 128}, (v, i) => 0);

    for (var i = 0; i < s1.length; i++) {
        var ci1 = s1.charAt(i).charCodeAt(0);
        var ci2 = s2.charAt(i).charCodeAt(0);
        is1[ci1]++;
        is2[ci2]++;
    }

    for (var j = 0; j < is1.length; j++) {
        if (is1[j] != is2[j]) {
            return false;
        }
    }

    return true;
}

module.exports = is_anagram;