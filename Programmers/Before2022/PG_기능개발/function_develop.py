progresses = [93, 30, 55]
speeds = [1, 30, 5]

queue = []
answer = []

for i in range(len(progresses)):
    wd = wd = (100 - progresses[i]) // speeds[i]
    if (100 - progresses[i]) % speeds[i] != 0:
        wd += 1

    if len(queue) == 0 or queue[0] >= wd:
        queue.append(wd)
    else:
        count = 0
        while queue:
            queue.pop(0)
            count += 1
        answer.append(count)
        queue.append(wd)

if len(queue) != 0:
    count = 0
    while queue:
        queue.pop(0)
        count += 1
    answer.append(count)

print(answer)

# (((100 - progresses[i]) // speeds[i]) + 1 if (100 - progresses[i]) % speeds[i] != 0
#           else (100 - progresses[i]) // speeds[i]) for i in range(len(progresses))
