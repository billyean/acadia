package miscellaneous

import (
	"miscellaneous"
	"testing"
)

func TestValid(t *testing.T) {
	if !miscellaneous.Valid("anagram", "nagaram") {
		t.Errorf("anagram and nagaram are anagram.")
	}


	if miscellaneous.Valid("rat", "cat") {
		t.Errorf("rat and cat are not anagram.")
	}
}
