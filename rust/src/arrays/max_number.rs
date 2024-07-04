fn pick_max(nums: &[i32], k: usize) -> Vec<i32> {
    let mut stack = Vec::new();
    let mut drop = nums.len() - k;
    for &num in nums {
        while drop > 0 && !stack.is_empty() && stack.last() < Some(&num) {
            stack.pop();
            drop -= 1;
        }
        stack.push(num);
    }
    stack.truncate(k);
    stack
}

fn merge(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    let mut result = Vec::with_capacity(nums1.len() + nums2.len());
    let mut i = 0;
    let mut j = 0;
    while i < nums1.len() || j < nums2.len() {
        if i < nums1.len() && (j == nums2.len() || nums1[i..] > nums2[j..]) {
            result.push(nums1[i]);
            i += 1;
        } else {
            result.push(nums2[j]);
            j += 1;
        }
    }
    result
}

struct TwoArrays;

impl TwoArrays {


    pub fn max_number(nums1: Vec<i32>, nums2: Vec<i32>, k: i32) -> Vec<i32> {
        let mut max_number = Vec::new();
        let m = nums1.len() as i32;
        let n = nums2.len() as i32 ;

        for i in 0..=k {
            if i <= m && k - i <= n {
                let max_from_nums1 = pick_max(&nums1, i as usize);
                let max_from_nums2 = pick_max(&nums2, (k - i) as usize);
                let candidate = merge(max_from_nums1, max_from_nums2);
                if candidate > max_number {
                    max_number = candidate;
                }
            }
        }

        max_number
    }
}

#[cfg(test)]
mod tests {
    use crate::arrays::max_number::TwoArrays;

    #[test]
    fn test_max_number1() {
        assert_eq!(
            TwoArrays::max_number(vec![3,4,6,5], vec![9,1,2,5,8,3], 5),
            vec![9,8,6,5,3]
        );
    }

    #[test]
    fn test_max_number2() {
        assert_eq!(
            TwoArrays::max_number(vec![6, 7], vec![6, 0, 4], 5),
            vec![6, 7, 6, 0, 4]
        );
    }

    #[test]
    fn test_max_number2() {
        assert_eq!(
            TwoArrays::max_number(vec![3, 9], vec![8, 9], 3),
            vec![9, 8, 9]
        );
    }
}