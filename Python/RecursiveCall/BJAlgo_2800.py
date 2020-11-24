# 조합, 재귀
from sys import stdin
from itertools import combinations

equation = list(stdin.readline().strip())

stack = list()
brackets = list()

result = set()

for i in range(len(equation)):
    if equation[i] == "(":
        equation[i] = ""
        stack.append(i)
    elif equation[i] == ")":
        equation[i] = ""
        brackets.append([stack.pop(), i])

for i in range(len(brackets)):
    for j in combinations(brackets, i):
        tmp = equation[:]
        for ob, cb in j:
            tmp[ob] = "("
            tmp[cb] = ")"
        result.add("".join(tmp))

for r in sorted(result):
    print(r)
