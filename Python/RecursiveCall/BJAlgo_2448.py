from sys import stdin


def make_star(star):
    matrix = []
    for i in range(2 * len(star)):
        if i < len(star):
            matrix.append((" " * len(star)) + star[i % len(star)] + (" " * len(star)))
        else:
            matrix.append(star[i % len(star)] + " " + star[i % len(star)])
    return matrix


n = int(stdin.readline())
stars = ["  *  ", " * * ", "*****"]
k = 0
n = int(n/3)

while n != 1:
    n = int(n/2)
    k += 1

for _ in range(k):
    stars = make_star(stars)

print("\n".join(s for s in stars))
