from sys import stdin


def find(p):
    if p == parent[p]:
        return p
    else:
        pp = find(parent[p])
        parent[p] = pp
        return parent[p]


def union(p1, p2):
    parent1 = find(p1)
    parent2 = find(p2)

    if parent1 != parent2:
        parent[parent2] = parent1
        number[parent1] += number[parent2]


test_case = int(stdin.readline())
for _ in range(test_case):
    parent = dict()
    number = dict()
    F = int(stdin.readline())
    for _ in range(F):
        person1, person2 = stdin.readline().split()

        if person1 not in parent:
            parent[person1] = person1
            number[person1] = 1

        if person2 not in parent:
            parent[person2] = person2
            number[person2] = 1

        union(person1, person2)

        print(number[find(person1)])


