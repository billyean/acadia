class Zigzag:
    def convert(self, s, numRows):
        if numRows < 2 or len(s) == 0:
            return s

        zs = ""

        for i in range(0, numRows):
            span1 = 2 * (numRows - i - 1)
            span2 = 2 * i

            add = True

            b = i

            while b < len(s):
                zs += s[b]

                if span1 == 0:
                    b += span2
                elif span2 == 0:
                    b += span1
                elif add:
                    b += span1
                else:
                    b += span2

                add = not add


        return zs