from sys import stdin

while True:
    stack = []
    text = stdin.readline()

    if text[0] == '.':
        break

    for i in range(len(text)):
        if text[i] == '(' or text[i] == '[':
            stack.append(text[i])
        elif text[i] == ')':
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                stack.append(text[i])
        elif text[i] == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(text[i])

    if stack:
        print('no')
    else:
        print('yes')