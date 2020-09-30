# 시간 초과

from sys import stdin

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


class NodeMng:
    def __init__(self):
        self.head = None

    def add(self, value):
        if self.head is None:
            self.head = Node(value)
            return

        self.current_node = self.head
        while self.current_node is not None:
            if self.current_node.value > value:
                if self.current_node.left is not None:
                    self.current_node = self.current_node.left
                else:
                    self.current_node.left = Node(value)
                    break
            elif self.current_node.value < value:
                if self.current_node.right is not None:
                    self.current_node = self.current_node.right
                else:
                    self.current_node.right = Node(value)
                    break

    def printValue(self, node):
        if node.left is not None:
            self.printValue(node.left)

        if node.right is not None:
            self.printValue(node.right)

        print(node.value)


BST = NodeMng()
count = 0
while count <= 10000:
    try:
        num = int(stdin.readline())
    except:
        break

    BST.add(num)
    count += 1

BST.printValue(BST.head)
