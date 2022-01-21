w = 8
h = 12


def get_gcd(a, b):
    while b:
        a, b = b, a % b

    return a


gcd = get_gcd(max(w, h), min(w, h))
mw = w // gcd
mh = h // gcd

print((w * h) - ((mw + mh - 1) * gcd))
