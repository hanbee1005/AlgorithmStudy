from sys import stdin


def preorder(array, start_node):
    global pre
    pre += start_node

    left = array[start_node][0]
    right = array[start_node][1]

    if left != ".":
        preorder(array, left)

    if right != ".":
        preorder(array, right)


def inorder(array, start_node):
    global inord

    left = array[start_node][0]
    right = array[start_node][1]

    if left != ".":
        inorder(array, left)

    inord += start_node

    if right != ".":
        inorder(array, right)


def postorder(array, start_node):
    global post

    left = array[start_node][0]
    right = array[start_node][1]

    if left != ".":
        postorder(array, left)

    if right != ".":
        postorder(array, right)

    post += start_node


n = int(stdin.readline())
pre = ""
inord = ""
post = ""

binary_tree = dict()
for _ in range(n):
    inputs = stdin.readline().split()
    binary_tree[inputs[0]] = [inputs[1], inputs[2]]

preorder(binary_tree, "A")
inorder(binary_tree, "A")
postorder(binary_tree, "A")

print(pre)
print(inord)
print(post)
