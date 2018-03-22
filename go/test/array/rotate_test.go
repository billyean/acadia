package array

import (
	"array"
	"testing"
	"reflect"
)

func TestBinarySearch(t *testing.T) {
	test_data1 := []int{1, 2, 3, 4, 5, 6, 7}
	actual11 := array.BinarySearch(test_data1, 1);
	if actual11 != 0 {
		t.Errorf("Binary search 1 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 0 but got %d.", actual11)
	}
	actual12 := array.BinarySearch(test_data1, 2);
	if actual12 != 1 {
		t.Errorf("Binary search 2 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 1 but got %d.", actual12)
	}
	actual13 := array.BinarySearch(test_data1, 3);
	if actual13 != 2 {
		t.Errorf("Binary search 3 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 2 but got %d.", actual13)
	}
	actual14 := array.BinarySearch(test_data1, 4);
	if actual14 != 3 {
		t.Errorf("Binary search 4 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 3 but got %d.", actual14)
	}
	actual15 := array.BinarySearch(test_data1, 5);
	if actual15 != 4 {
		t.Errorf("Binary search 5 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 4 but got %d.", actual15)
	}
	actual16 := array.BinarySearch(test_data1, 6);
	if actual16 != 5 {
		t.Errorf("Binary search 6 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 5 but got %d.", actual16)
	}
	actual17 := array.BinarySearch(test_data1, 7);
	if actual17 != 6 {
		t.Errorf("Binary search 7 on rotate array [1, 2, 3, 4, 5, 6, 7] expected 6 but got %d.", actual17)
	}

	test_data2 := []int{3, 4, 5, 6, 7, 1, 2}
	actual21 := array.BinarySearch(test_data2, 1);
	if actual21 != 5 {
		t.Errorf("Binary search 1 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 5 but got %d.", actual21)
	}
	actual22 := array.BinarySearch(test_data2, 2);
	if actual22 != 6 {
		t.Errorf("Binary search 2 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 6 but got %d.", actual22)
	}
	actual23 := array.BinarySearch(test_data2, 3);
	if actual23 != 0 {
		t.Errorf("Binary search 3 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 0 but got %d.", actual23)
	}
	actual24 := array.BinarySearch(test_data2, 4);
	if actual24 != 1 {
		t.Errorf("Binary search 4 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 1 but got %d.", actual24)
	}
	actual25 := array.BinarySearch(test_data2, 5);
	if actual25 != 2 {
		t.Errorf("Binary search 5 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 2 but got %d.", actual25)
	}
	actual26 := array.BinarySearch(test_data2, 6);
	if actual26 != 3 {
		t.Errorf("Binary search 6 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 3 but got %d.", actual26)
	}
	actual27 := array.BinarySearch(test_data2, 7);
	if actual27 != 4 {
		t.Errorf("Binary search 7 on rotate array [3, 4, 5, 6, 7, 1, 2] expected 4 but got %d.", actual27)
	}

	test_data3 := []int{7, 1, 2, 3, 4, 5, 6}
	actual31 := array.BinarySearch(test_data3, 1);
	if actual31 != 1 {
		t.Errorf("Binary search 1 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 1 but got %d.", actual31)
	}
	actual32 := array.BinarySearch(test_data3, 2);
	if actual32 != 2 {
		t.Errorf("Binary search 2 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 2 but got %d.", actual32)
	}
	actual33 := array.BinarySearch(test_data3, 3);
	if actual33 != 3 {
		t.Errorf("Binary search 3 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 3 but got %d.", actual33)
	}
	actual34 := array.BinarySearch(test_data3, 4);
	if actual34 != 4 {
		t.Errorf("Binary search 4 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 4 but got %d.", actual34)
	}
	actual35 := array.BinarySearch(test_data3, 5);
	if actual35 != 5 {
		t.Errorf("Binary search 5 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 5 but got %d.", actual35)
	}
	actual36 := array.BinarySearch(test_data3, 6);
	if actual36 != 6 {
		t.Errorf("Binary search 6 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 6 but got %d.", actual36)
	}
	actual37 := array.BinarySearch(test_data3, 7);
	if actual37 != 0 {
		t.Errorf("Binary search 7 on rotate array [7, 1, 2, 3, 4, 5, 6] expected 0 but got %d.", actual37)
	}

	test_data4 := []int{1, 1, 2, 3, 4, 5, 1}
	actual41 := array.BinarySearch(test_data4, 1);
	if actual41 != 0 {
		t.Errorf("Binary search 1 on rotate array [1, 1, 2, 3, 4, 5, 1] expected 0 but got %d.", actual41)
	}
	actual42 := array.BinarySearch(test_data4, 2);
	if actual42 != 2 {
		t.Errorf("Binary search 2 on rotate array [1, 1, 2, 3, 4, 5, 1] expected 2 but got %d.", actual32)
	}
	actual43 := array.BinarySearch(test_data4, 3);
	if actual43 != 3 {
		t.Errorf("Binary search 3 on rotate array [1, 1, 2, 3, 4, 5, 1] expected 3 but got %d.", actual33)
	}
	actual44 := array.BinarySearch(test_data4, 4);
	if actual44 != 4 {
		t.Errorf("Binary search 4 on rotate array [1, 1, 2, 3, 4, 5, 1] expected 4 but got %d.", actual34)
	}
	actual45 := array.BinarySearch(test_data4, 5);
	if actual45 != 5 {
		t.Errorf("Binary search 5 on rotate array [1, 1, 2, 3, 4, 5, 1] expected 5 but got %d.", actual35)
	}

	test_data5 := []int{5, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5}
	actual51 := array.BinarySearch(test_data5, 1);
	if actual51 != 1 {
		t.Errorf("Binary search 1 on rotate array [5, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5] expected 1 but got %d.", actual51)
	}
	actual52 := array.BinarySearch(test_data5, 2);
	if actual52 != 2 {
		t.Errorf("Binary search 2 on rotate array [5, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5] expected 2 but got %d.", actual52)
	}
	actual53 := array.BinarySearch(test_data5, 3);
	if actual53 != 3 {
		t.Errorf("Binary search 3 on rotate array [5, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5] expected 3 but got %d.", actual53)
	}
	actual54 := array.BinarySearch(test_data5, 4);
	if actual54 != 10 {
		t.Errorf("Binary search 4 on rotate array [5, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5] expected 10 but got %d.", actual54)
	}
	actual55 := array.BinarySearch(test_data5, 5);
	if actual55 != 0 {
		t.Errorf("Binary search 5 on rotate array [5, 1, 2, 3, 3, 3, 3, 3, 3, 3, 4, 5, 5] expected 0 but got %d.", actual55)
	}
}

func TestRotateLeft(t *testing.T) {
	test_data1 := []int{1, 2, 3, 4, 5, 6, 7}
	array.RotateLeft(test_data1, 0)
	if !reflect.DeepEqual(test_data1, []int{1, 2, 3, 4, 5, 6, 7}) {
		t.Errorf("%d's rome digits is expected %s, but got %s.", []int{1, 2, 3, 4, 5, 6, 7}, test_data1)
		}

	test_data2 := []int{1, 2, 3, 4, 5, 6, 7}
	array.RotateLeft(test_data2, 1)
	if !reflect.DeepEqual(test_data2, []int{2, 3, 4, 5, 6, 7, 1}) {
		t.Errorf("%d's rome digits is expected %s, but got %s.", []int{2, 3, 4, 5, 6, 7, 1}, test_data2)
	}

	test_data3 := []int{1, 2, 3, 4, 5, 6, 7}
	array.RotateLeft(test_data3, 5)
	if !reflect.DeepEqual(test_data3, []int{6, 7, 1, 2, 3, 4, 5}) {
		t.Errorf("%d's rome digits is expected %s, but got %s.", []int{6, 7, 1, 2, 3, 4, 5}, test_data3)
	}
}