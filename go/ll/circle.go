package ll

func Circulated(head *LinkedList) bool {
	if head == nil && head.Next == nil {
		return false
	}

	one := head
	two := head.Next.Next

	for two != nil && two.Next != nil {
		if one == two {
			return true;
		}
		one = one.Next
		two = two.Next.Next
	}

	return false
}

func Junction(head *LinkedList) *LinkedList {
	if !Circulated(head) {
		return nil
	}

	meet := head
	two := head
	i := 0
	for i == 0 || meet != two {
		meet = meet.Next
		two = two.Next.Next
		i++
	}
	junction := head

	for junction != meet {
		meet = meet.Next
		junction = junction.Next
	}

	return junction
}
