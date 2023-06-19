import random

def merge_sort(arr):
	sort(arr, [0] * len(arr), 0, len(arr) - 1)
	return arr

def sort(arr, temp, l, r):
	if l >= r:
		return

	mid = (l + r) // 2
	sort(arr, temp, l, mid)
	sort(arr, temp, mid + 1, r)
	merge(arr, temp, mid + 1, l, r)

def merge(arr, temp, mid, l, r):
	for k in range(l, r + 1):
		temp[k] = arr[k]
	i = l
	j = mid
	for k in range(l, r + 1):
		if i >= mid:
			arr[k] = temp[j]
			j += 1
		elif j > r:
			arr[k] = temp[i]
			i += 1
		elif temp[i] > temp[j]:
			arr[k] = temp[j]
			j += 1
		else:
			arr[k] = temp[i]
			i += 1
	


test_array = [random.randint(0, 100) for _ in range(10)]
ans_array = sorted(test_array.copy())
merge_sort(test_array)
if test_array == ans_array:
	print("Correct")
else:
	print("Incorrect")
	print(test_array)