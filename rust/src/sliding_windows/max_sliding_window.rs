struct SlidingWindows;

impl SlidingWindows {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        let mut sliding_windows = Vec::<i32>::new();
        let mut queue = Vec::<i32>::new();

        for i in 0..k-1  {
            while let Some(l) = queue.last() {
                if nums[*l as usize] >= nums[i as usize]  {
                    break;
                }
                queue.pop();
            }
            queue.push(i);
        }

        println!("{:?}", queue);

        for i in k-1..nums.len() as i32 {
            while let Some(l) = queue.last() {
                if nums[*l as usize] >= nums[i as usize]  {
                    break;
                }
                queue.pop();
            }
            queue.push(i);

            if let Some(first) = queue.first() {
                sliding_windows.push(nums[*first as usize]);
            }
            if let Some(v) = queue.first() {
                if i - v  + 1 >= k {
                    queue.remove(0);
                }
            }
        }

        sliding_windows
    }
}

#[cfg(test)]
mod tests {
    use crate::sliding_windows::max_sliding_window::SlidingWindows;

    #[test]
    fn test_ax_sliding_window1() {
        assert_eq!(SlidingWindows::max_sliding_window(
            vec![1, 3, -1, -3, 5, 3, 6, 7],
            3
        ),
        vec![3, 3, 5, 5, 6, 7]
        );
    }


    #[test]
    fn test_ax_sliding_window2() {
        assert_eq!(SlidingWindows::max_sliding_window(
            vec![1, -1],
            1
        ),
        vec![1, -1]
        );
    }
}