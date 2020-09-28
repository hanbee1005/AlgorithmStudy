from sys import stdin
import hashlib

text = stdin.readline().strip('\n')
hash_object = hashlib.sha1()
hash_object.update(text.encode())
print(hash_object.hexdigest())  # 16진수로 출력하기