def selection_sort(arr):
    n = len(arr)
    for i in range(n):
        min_index = i
        # Find the minimum in the rest of the list
        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j
        # Swap the found minimum with the current element
        arr[i], arr[min_index] = arr[min_index], arr[i]

# Example Usage
nums = [64, 25, 12, 22, 11]
selection_sort(nums)
print("Sorted array:", nums)
