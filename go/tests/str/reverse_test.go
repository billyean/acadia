package str

import (
	"github.com/go/str"
	"testing"
)

func TestReverseVowels(t *testing.T) {
	actual := str.ReverseVowels("My name is Tristan")
	expected := "My nami is Trestan"
	if actual != expected {
		t.Errorf("Reverse vowels on 'My name is Tristan' should return '%s' but got '%s'.", expected, actual)
	}
}

func TestReverseWord1(t *testing.T) {
	actual := str.ReverseWord("My name is Tristan")
	expected := "Tristan is name My"
	if actual != expected {
		t.Errorf("Reverse word on 'My name is Tristan' should return '%s' but got '%s'.", expected, actual)
	}
}

func TestReverseWord2(t *testing.T) {
	actual := str.ReverseWord(" I am a programmer")
	expected := "programmer a am I "
	if actual != expected {
		t.Errorf("Reverse word on ' I am a programmer' should return '%s' but got '%s'.", expected, actual)
	}
}
