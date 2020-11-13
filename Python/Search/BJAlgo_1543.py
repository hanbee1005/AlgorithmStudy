from sys import stdin

string = stdin.readline().strip()
search = stdin.readline().strip()

count = 0
find_idx = 0
while find_idx <= len(string) - len(search):
    if string[find_idx:find_idx + len(search)] == search:
        count += 1
        find_idx += len(search) + 1
    else:
        find_idx += 1

print(count)
