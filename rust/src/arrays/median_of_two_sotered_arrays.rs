struct Array {
}

fn find_median(nums: &Vec<i32>, s: usize, e: usize) -> f64 {
    let m = (e + s) / 2;
    if (e - s) % 2 == 1 {
        nums[m] as f64
    } else {
        nums[m-1] as f64 / 2.0f64 + nums[m] as f64 / 2.0f64
    }
}
fn find_median_sorted_arrays_with_indices(nums1: &Vec<i32>, s1: usize, e1: usize,
                                          nums2: &Vec<i32>, s2: usize, e2: usize) -> f64 {
    if e1 - s1 > e2 - s2 {
        return find_median_sorted_arrays_with_indices(nums2, s2, e2, nums1, s1, e1);
    }

    if e1 - s1 == 0 {
        return find_median(nums2, s2, e2);
    }

    let len1 = e1 - s1;
    let len2 = e2 - s2;
    let half_len = (len1 + len2 + 1) / 2;

    let mut imin = 0;
    let mut imax = len1;

    while imin <= imax {
        let i = (imin + imax) / 2;
        let j = half_len - i;

        if i < len1 && nums2[s2 + j - 1] > nums1[s1 + i] {
            // i is too small, must increase it
            imin = i + 1;
        } else if i > 0 && nums1[s1 + i - 1] > nums2[s2 + j] {
            // i is too big, must decrease it
            imax = i - 1;
        } else {
            // i is perfect
            let max_of_left = if i == 0 {
                nums2[s2 + j - 1]
            } else if j == 0 {
                nums1[s1 + i - 1]
            } else {
                std::cmp::max(nums1[s1 + i - 1], nums2[s2 + j - 1])
            };

            if (len1 + len2) % 2 == 1 {
                return max_of_left as f64;
            }

            let min_of_right = if i == len1 {
                nums2[s2 + j]
            } else if j == len2 {
                nums1[s1 + i]
            } else {
                std::cmp::min(nums1[s1 + i], nums2[s2 + j])
            };

            return (max_of_left as f64 + min_of_right as f64) / 2.0;
        }
    }

    0.0
}

impl Array {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        find_median_sorted_arrays_with_indices(&nums1, 0, nums1.len(), &nums2, 0, nums2.len())
    }
}

#[cfg(test)]
mod tests {
    use crate::arrays::median_of_two_sotered_arrays::Array;

    #[test]
    fn test_find_median_sorted_arrays() {
        // assert_eq!(Array::find_median_sorted_arrays(vec![0, 1, 2, 3, 4, 5], vec![0, 1, 2, 3, 4, 5]), 2.5f64);
        // assert_eq!(Array::find_median_sorted_arrays(vec![0, 3], vec![2]), 2.0f64);
        assert_eq!(Array::find_median_sorted_arrays(vec![], vec![2,3]), 1.5f64);
    }
}