package number

import (
	"number"
	"testing"
)

func TestCountPrimeSetBits(t *testing.T) {
	if number.CountPrimeSetBits(6, 10) != 4 {
		t.Errorf("Bits between 6 annd 10 should have 4 prime number.")
	}

	if number.CountPrimeSetBits(10, 15) != 5 {
		t.Errorf("Bits between 10 annd 15 should have 5 prime number.")
	}
	
	if number.CountPrimeSetBits(842, 888) != 23 {
		t.Errorf("Bits between 842 annd 888 should have 23 prime number.")
	}
}
