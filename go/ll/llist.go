package ll

type LinkedList struct {
	Next  *LinkedList
	Value int
}

func ListFromSlice(slice []int) *LinkedList {
	if slice == nil || len(slice) == 0 {
		return nil
	}

	head := &LinkedList{nil, slice[0]}
	prev := head

	for i := 1; i < len(slice); i++ {
		node := &LinkedList{nil, slice[i]}
		prev.Next = node
		prev = node
	}

	return head
}

func CirculateListFromSlice(slice []int, k int) *LinkedList {
	head := ListFromSlice(slice)
	p := k % len(slice)

	tail := head
	kp := head

	for i := 0; tail.Next != nil; i++ {
		tail = tail.Next
		if i < p-1 {
			kp = kp.Next
		}
	}

	tail.Next = kp

	return head
}
