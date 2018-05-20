class Calculator:
    def calculate(self, s):
        oper = []
        oprnd = []

        c = 0
        l = 1
        for i, v in enumerate(s):
            if v == '(':
                l += 1
            elif v == ')':
                if len(oprnd) > 0:
                    if oprnd[-1][1] == l:
                        t = oprnd[-1][0]
                        x = oper[-1]
                        if x == '+':
                            c = t + c
                        else:
                            c = t - c
                        oprnd = oprnd[:-1]
                        oper = oper[:-1]
                    oprnd += (c, l)
                l -= 1
            elif v == ' ':
                if len(oprnd) > 0:
                    if oprnd[-1][1] == l:
                        t = oprnd[-1][0]
                        x = oper[-1]
                        if x == '+':
                            c = t + c
                        else:
                            c = t - c
                        oprnd = oprnd[:-1]
                        oper = oper[:-1]
                    oprnd += (c, l)
            elif v == '+' or v == '-':
                oper += v
            else:
                c *= 10
                c += int(v)
