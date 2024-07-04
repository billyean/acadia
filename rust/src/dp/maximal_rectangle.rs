fn largest_rectangle_area(heights: &[i32]) -> i32 {
    let mut stack = Vec::new();
    let mut max_area = 0;
    let mut heights = heights.to_vec();
    heights.push(0); // Append a zero height to handle remaining elements in the stack

    for (i, &height) in heights.iter().enumerate() {
        while let Some(&top) = stack.last() {
            if height < heights[top] {
                stack.pop();
                let h = heights[top];
                let w = if let Some(&last) = stack.last() {
                    i - last - 1
                } else {
                    i
                };
                max_area = max_area.max(h * w as i32);
            } else {
                break;
            }
        }
        stack.push(i);
    }

    max_area
}

struct Rectangle;
impl Rectangle {
    pub fn maximal_rectangle(matrix: Vec<Vec<char>>) -> i32 {
        if matrix.is_empty() || matrix[0].is_empty() {
            return 0;
        }

        let rows = matrix.len();
        let cols = matrix[0].len();
        let mut heights = vec![0; cols];
        let mut max_area = 0;

        for i in 0..rows {
            for j in 0..cols {
                // Update the height of the current column
                if matrix[i][j] == '1' {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate the maximum area for the current row's histogram
            max_area = max_area.max(largest_rectangle_area(&heights));
        }

        max_area
    }
}

#[cfg(test)]
mod tests {
    use crate::dp::maximal_rectangle::Rectangle;

    #[test]
    fn test_maximal_rectangle1() {
        assert_eq!(Rectangle::maximal_rectangle(
            vec![
                vec!['1', '0', '1', '0', '0'],
                vec!['1', '0', '1', '1', '1'],
                vec!['1', '1', '1', '1', '1'],
                vec!['1', '0', '0', '1', '0']
            ]),
            6
        );
    }

    #[test]
    fn test_maximal_rectangle2() {
        assert_eq!(Rectangle::maximal_rectangle(
            vec![
                vec!['0'],
            ]),
            0
        );
    }

    #[test]
    fn test_maximal_rectangle3() {
        assert_eq!(Rectangle::maximal_rectangle(
            vec![
                vec!['1']
            ]),
            1
        );
    }

    #[test]
    fn test_maximal_rectangle4() {
        assert_eq!(Rectangle::maximal_rectangle(
            vec![
                vec!['1', '1']
            ]),
            2
        );
    }

    #[test]
    fn test_maximal_rectangle5() {
        assert_eq!(Rectangle::maximal_rectangle(
            vec![
                vec!['1'],
                vec!['1']
            ]),
            2
        );
    }

    #[test]
    fn test_maximal_rectangle6() {
        assert_eq!(Rectangle::maximal_rectangle(
            vec![
                vec!['0', '1'],
                vec!['0', '1']
            ]),
                   2
        );
    }
}