package maths

import (
	"testing"
	"maths"
)

func TestPowerOfTwo1(t *testing.T) {
	if !maths.PowerOfTwo(2) 	{
		t.Errorf("2 is expected to be power of 2");
	}
}

func TestPowerOfTwo2(t *testing.T) {
	if !maths.PowerOfTwo(1) 	{
		t.Errorf("1 is expected to be power of 2");
	}
}

func TestPowerOfTwo3(t *testing.T) {
	if !maths.PowerOfTwo(8) 	{
		t.Errorf("8 is expected to be power of 2");
	}
}

func TestPowerOfTwo4(t *testing.T) {
	if maths.PowerOfTwo(7) 	{
		t.Errorf("7 is expected to be not power of 2");
	}
}

func TestPowerOfFour1(t *testing.T) {
	if maths.PowerOfFour(2) 	{
		t.Errorf("2 is expected to be not power of 4");
	}
}

func TestPowerOfFour2(t *testing.T) {
	if !maths.PowerOfFour(1) 	{
		t.Errorf("1 is expected to be power of 4");
	}
}

func TestPowerOfFour3(t *testing.T) {
	if maths.PowerOfFour(8) 	{
		t.Errorf("8 is expected to be not power of 4");
	}
}

func TestPowerOfFour4(t *testing.T) {
	if !maths.PowerOfFour(16) 	{
		t.Errorf("16 is expected to be power of 4");
	}
}

func TestPowerOfFour5(t *testing.T) {
	if maths.PowerOfFour(7) 	{
		t.Errorf("7 is expected to be not power of 4");
	}
}
