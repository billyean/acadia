struct Sort;

fn merge_sort(nums: &mut Vec<i32>, start: usize, end: usize) -> i32 {
    if start + 1 >= end {
        return 0
    }

    let mid = (start + end) / 2;
    let mut paris_count = merge_sort(nums, start, mid) + merge_sort(nums, mid, end);

    let mut right = mid;
    for left in start.. mid {
        while right < end && nums[left] > nums[right] * 2 {
            right += 1
        }
        paris_count += (right - mid) as i32;
    }

    let mut temp = vec![];
    let mut left = start;
    let mut right = mid;

    while left < mid && right < end {
        if nums[left] < nums[right] {
            temp.push( nums[left]);
            left += 1;
        } else {
            temp.push( nums[right]);
            right += 1;
        }
    }
    while left < mid {
        temp.push( nums[left]);
        left += 1;
    }
    while right < end {
        temp.push( nums[right]);
        right += 1;
    }

    nums[start..end].copy_from_slice(&temp);
    paris_count
}

impl Sort {
    pub fn reverse_pairs(nums: Vec<i32>) -> i32 {
        let mut sort_vec = nums.clone();
        let end = nums.len();
        merge_sort(&mut sort_vec, 0, end)
    }
}

#[cfg(test)]
mod tests {
    use crate::arrays::reverse_pairs::Sort;

    #[test]
    fn test_reverse_pairs1() {
        assert_eq!(Sort::reverse_pairs(vec![1, 3, 2, 3, 1]),
                   2)
    }

    #[test]
    fn test_reverse_pairs2() {
        assert_eq!(Sort::reverse_pairs(vec![2, 4, 3, 5, 1]),
                   3)
    }
}