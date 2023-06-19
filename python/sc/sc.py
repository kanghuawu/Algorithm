from sortedcontainers import SortedList, SortedSet, SortedDict

def sortedList():
    sl = SortedList(range(10))
    print(sl.bisect_left(1))
    print(sl.discard(1))

sortedList()