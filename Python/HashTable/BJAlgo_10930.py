import hashlib
from sys import stdin

S = stdin.readline().strip()
hashStr = hashlib.sha256(S.encode())
print(hashStr.hexdigest())