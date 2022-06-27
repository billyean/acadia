package miscellaneous

import (
	"github.com/go/src/miscellaneous"
"testing"
)

type param_and_result struct {
	value int
	rome string
}

func TestInt2Rome(t *testing.T) {
	test_data := []param_and_result{
		param_and_result{1, "I"},
		param_and_result{2, "II"},
		param_and_result{3, "III"},
		param_and_result{4, "IV"},
		param_and_result{49, "XLIX"},
		param_and_result{50, "L"},
		param_and_result{51, "LI"},
		param_and_result{59, "LIX"},
		param_and_result{60, "LX"},
		param_and_result{61, "LXI"},
		param_and_result{69, "LXIX"},
		param_and_result{70, "LXX"},
		param_and_result{71, "LXXI"},
		param_and_result{3499, "MMMCDXCIX"},

	}

	for _, line := range test_data{
		actual := miscellaneous.Int2Rome(line.value)
		if actual != line.rome {
			t.Errorf("%d's rome digits is expected %s, but got %s.", line.value, line.rome, actual)
		}
	}


}
