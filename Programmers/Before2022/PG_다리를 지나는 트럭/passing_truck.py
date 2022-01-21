def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge_weight = 0

    bridge = []

    for now in truck_weights:
        while True:
            if len(bridge) == 0:
                bridge.append(now)
                answer += 1
                bridge_weight += now
                break
            elif len(bridge) == bridge_length:
                bridge_weight -= bridge.pop(0)
            else:
                if bridge_weight + now > weight:
                    bridge.append(0)
                    answer += 1
                else:
                    bridge.append(now)
                    answer += 1
                    bridge_weight += now
                    break

    return answer + bridge_length


result = solution(2, 10, [7, 4, 5, 6])
print(result)
