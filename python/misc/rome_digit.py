class RomeDigit:
    def __init__(self):
        self.__r2i__ = {'I': 1, 'V': 5, 'X': 10, 'L':50, 'C': 100, 'D': 500, 'M': 1000}
        self.__boundary__ = [
            (1000, 900, 'M', 'C'),
            (500,  400, 'D', 'C'),
            (100,   90, 'C', 'X'),
            ( 50,   40, 'L', 'X'),
            ( 10,    9, 'X', 'I'),
            (  5,    4, 'V', 'I'),
            (  1,    1, 'I', 'I'),
        ]

    def int_to_rome(self, num):
        r = ""
        for b in self.__boundary__:
            while num >= b[1]:
                if num < b[0]:
                   r += b[3]
                r += b[2]
                num -= b[0]
                if num < 0:
                    num += b[0] - b[1]

        return r