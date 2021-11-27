package str

import (
	"github.com/go/str"
	"testing"
)

func TestSubstr(t *testing.T) {
	if index := str.Substr("abc", "a"); index != 0 {
		t.Errorf("Substr(abc, a) should rerturn 0 but it return %d.", index)
	}

	if index := str.Substr("abc", "bc"); index != 1 {
		t.Errorf("Substr(abc, bc) should rerturn 1 but it return %d.", index)
	}

	if index := str.Substr("aabc", "aa"); index != 0 {
		t.Errorf("Substr(aabc, aa) should rerturn 0 but it return %d.", index)
	}

	if index := str.Substr("aabc", "ab"); index != 1 {
		t.Errorf("Substr(aabc, ab) should rerturn 1 but it return %d.", index)
	}
}