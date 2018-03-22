package str

import (
	"testing"
	"str"
)

func TestReverseVowels(t *testing.T) {
	actual := str.ReverseVowels("My name is Tristan")
	expected := "My nami is Trestan"
	if str.ReverseVowels(actual) != expected {
		t.Errorf("Reverse Vowels on 'My name is Tristan' should return '%s' but got '%s'.", expected, actual)
	}
}
