package dp

import (
	"github.com/go/src/dp"
	"testing"
)

func TestFibonacci(t *testing.T) {
	f1 := dp.Fibonacci(1)
	if f1 != 1 {
		t.Errorf("Fibonacci(1) should be 1, but actual is %d.", f1)
	}

	f2 := dp.Fibonacci(2)
	if f2 != 1 {
		t.Errorf("Fibonacci(2) should be 1, but actual is %d.", f2)
	}

	f3 := dp.Fibonacci(3)
	if f3 != 2 {
		t.Errorf("Fibonacci(3) should be 2, but actual is %d.", f3)
	}

	f12 := dp.Fibonacci(12)
	if f12 != 144 {
		t.Errorf("Fibonacci(12) should be 144, but actual is %d.", f12)
	}

	f40 := dp.Fibonacci(40)
	if f40 != 102334155 {
		t.Errorf("Fibonacci(40) should be 102334155, but actual is %d.", f40)
	}
}