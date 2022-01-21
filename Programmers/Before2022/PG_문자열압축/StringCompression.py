def string_comp(s):
    answer = 1

    for n in range(1, len(s) // 2 + 1):
        now = ""
        count = 0
        strings = []

        start = 0
        end = start + n
        while end < len(s):
            strings.append(s[start:end])
            start = end
            end = start + n
        strings.append(s[start:])

        temp = ""

        for cs in strings:
            if now == "":
                now = cs
                count += 1
            else:
                if now == cs:
                    count += 1
                else:
                    if count <= 1:
                        temp += "{}".format(now)
                    else:
                        temp += "{}{}".format(count, now)
                    now = cs
                    count = 1

        if count <= 1:
            temp += "{}".format(now)
        else:
            temp += "{}{}".format(count, now)

        if answer == 1:
            answer = len(temp)
        else:
            answer = min(answer, len(temp))

    return answer


result = string_comp("ababcdcdababcdcd")
print(result)
