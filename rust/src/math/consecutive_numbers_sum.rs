struct Math;

impl Math {
    pub fn consecutive_numbers_sum(n: i32) -> i32 {
        let mut count = 0;
        let mut k = 1;
        while k * (k + 1) / 2 <= n {
            if (n - k * (k + 1) / 2) % k == 0 {
                count += 1;
            }
            k += 1;
        }
        count
    }
}

#[cfg(test)]
mod tests {
    use crate::math::consecutive_numbers_sum::Math;

    #[test]
    fn test_consecutive_numbers_sum1() {
        assert_eq!(Math::consecutive_numbers_sum(5), 2)
    }

    #[test]
    fn test_consecutive_numbers_sum2() {
        assert_eq!(Math::consecutive_numbers_sum(9), 3)
    }

    #[test]
    fn test_consecutive_numbers_sum3() {
        assert_eq!(Math::consecutive_numbers_sum(15), 4)
    }
}