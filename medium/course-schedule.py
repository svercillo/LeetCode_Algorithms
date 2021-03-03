class Node:
    def __init__(self, key):
        self.gt = set({})  # is greater than me
        self.lt = set({})  # is less than me
        self.key = key

    def __str__(self):
        return f"{self.lt} <  {self.key} < {self.gt}"


class Solution:
    def canFinish(self, numCourses: int, prerequisites) -> bool:
        node_map = {}  # number: Node

        for pre in prerequisites:
            first = pre[0]
            second = pre[1]

            if first in node_map and second in node_map:
                print(first, second)
                # pass
                n = node_map[first]

                if second in n.lt:
                    print("sdfsdfsssssdfsdfsd")
                    return False
                n.gt.add(second)
                if second in node_map:
                    n.gt = n.gt.union(node_map[second].gt)
                    for i in n.lt:
                        node_map[i].gt = node_map[i].gt.union(n.gt)

                n = node_map[second]
                if first in n.gt:
                    print("sdfsdfssss")
                    return False
                n.lt.add(first)
                if first in node_map:
                    n.lt = n.lt.union(node_map[first].lt)
                    for i in n.gt:
                        node_map[i].lt = node_map[i].lt.union(n.lt)
            else:
                if first in node_map:
                    n = node_map[first]
                    if second in n.lt:
                        print("fff")
                        return False
                    n.gt.add(second)
                    if second in node_map:
                        n.gt = n.gt.union(node_map[second].gt)
                        for i in n.lt:
                            node_map[i].gt = node_map[i].gt.union(n.gt)
                else:
                    n = Node(first)
                    n.gt.add(second)
                    if second in node_map:
                        n.gt = n.gt.union(node_map[second].gt)
                        for i in n.lt:
                            node_map[i].gt = node_map[i].gt.union(n.gt)
                    node_map[first] = n

                if second in node_map:

                    n = node_map[second]

                    if first in n.gt:
                        return False
                    n.lt.add(first)
                    if first in node_map:
                        n.lt = n.lt.union(node_map[first].lt)
                        for i in n.gt:
                            node_map[i].lt = node_map[i].lt.union(n.lt)
                else:
                    n = Node(second)
                    n.lt.add(first)

                    if first in node_map:
                        n.lt = n.lt.union(node_map[first].lt)
                        for i in n.gt:
                            node_map[i].lt = node_map[i].lt.union(n.lt)

                    node_map[second] = n

        if len(node_map) <= numCourses:
            for k in node_map:
                print(f"{k} : {node_map[k]}")
            # print(node_map[3])
            return True
        else:
            print("DFDFGDFG")
            return False

