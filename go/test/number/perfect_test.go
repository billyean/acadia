package number

import (
	"number"
	"testing"
)

func TestCount(t *testing.T) {
	if !number.CheckPerfectNumber(24) {
		t.Errorf("24 should be a perfect number.")
	}

	if !number.CheckPerfectNumber(6) {
		t.Errorf("6 should be a perfect number.")
	}

	if number.CheckPerfectNumber(1) {
		t.Errorf("1 should not be a perfect number.")
	}
}