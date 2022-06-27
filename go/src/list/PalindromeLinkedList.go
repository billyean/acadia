package list

type ListNode struct {
	Val  int
	Next *ListNode
}

func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	var m = find_middle(head)
	var s_h = reverse(m)

	var ch = head

	for s_h != nil {
		if s_h.Val != ch.Val {
			return false
		}
	}

	return true
}

func find_middle(head *ListNode) *ListNode {
	var one = head
	var two = head.Next
	for two != nil {
		one = one.Next
		two = two.Next
		if two != nil {
			two = two.Next
		}
	}
	return one.Next
}

func reverse(head *ListNode) *ListNode {
	var nh = head

	for c := nh.Next; c != nil; {
		var cn = c.Next
		c.Next = nh
		nh = c
		c = cn
	}

	return nh
}
