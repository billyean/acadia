struct Regex;


pub fn is_match(s: &str, p: &str, sp: usize, pp: usize) -> bool {
    if sp > s.len() {
        if pp > p.len() {
            return true;
        }
        let current = p.get(pp..p.len());
        return match current {
            None => false,
            Some(str) => str == "." || str == ".*"
        }
    }

    if let Some(c) = s.chars().nth(sp) {
        if let Some(pc) = p.chars().nth(pp) {
            return match pc {
                '.' => match p.chars().nth(pp + 1) {
                    Some('*') => is_match(s, p, sp + 1, pp) || is_match(s, p, sp + 2, pp),
                    _ => is_match(s, p, sp+1, pp+1)
                }
                other =>
                    if c != other {
                        false
                    } else {
                        is_match(s, p, sp+1, pp+1)
                    }
            }
        }
    }

    false
}

impl Regex {
    pub fn is_match(s: String, p: String) -> bool {
        is_match(s.as_str(), p.as_str(), 0, 0)
    }
}

#[cfg(test)]
mod tests {

    #[test]
    fn test_regular_expression_matching() {
        //assert!(Regex::is_match(String::new("aa").clone(), "a"));
    }
}