package array

import (
	"github.com/go/array"
	"testing"
)

func TestZigzag(t *testing.T) {
	if array.Convert("abc", 2) != "acb" {
		t.Errorf("Zigzag abc, 2 should rerturn acb.")
	}

	if array.Convert("abc", 3) != "abc" {
		t.Errorf("Zigzag abc, 3 should rerturn abc.")
	}

	if array.Convert("PAYPALISHIRING", 3) != "PAHNAPLSIIGYIR" {
		t.Errorf("Zigzag PAYPALISHIRING, 3 should rerturn PAHNAPLSIIGYIR.")
	}
}
