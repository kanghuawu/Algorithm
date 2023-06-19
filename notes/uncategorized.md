# Useful Tips

## Check If Two Intervals Overlap
```python
def overlap(first, second):
    s1, e1 = first
    s2, e2 = second
    return s1 < e2 and s2 < e1

def overlap(first, second):
    s1, e1 = first
    s2, e2 = second
    return max(s1, s2) < min(e1, e2)
```

## Binary Search
```python
def search(self, nums: List[int], target: int) -> int:
    le, ri = 0, len(nums)-1
    while le < ri:
        mid = (le+ri)//2
        if nums[mid] < target:
            le = mid + 1
        else:
            ri = mid
    return le if nums[le] == target else -1
```

```python
def search(self, nums: List[int], target: int) -> int:
    le, ri = 0, len(nums)-1
    while le < ri:
        mid = (le+ri+1)//2
        if nums[mid] <= target:
            le = mid
        else:
            ri = mid - 1
    return le if nums[le] == target else -1
```