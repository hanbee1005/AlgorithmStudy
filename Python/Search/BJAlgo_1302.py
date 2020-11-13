from sys import stdin

n = int(stdin.readline())
# books = list()
# sold_book = set()
# for _ in range(n):
#     book = stdin.readline().strip()
#     books.append(book)
#     sold_book.add(book)
#
# result = {'name': '', 'count': 0}
# for b in sold_book:
#     count = books.count(b)
#     if result['count'] < count or (result['count'] == count and result['name'] > b):
#         result = {'name': b, 'count': count}
#
# print(result['name'])

books = dict()
for _ in range(n):
    book = stdin.readline().strip()

    if book in books:
        books[book] += 1
    else:
        books[book] = 1

result = sorted(books.items(), key=lambda b: (-b[1], b[0]))
print(result[0][0])
