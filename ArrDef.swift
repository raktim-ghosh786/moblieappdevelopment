import Foundation

var arr:[Int] = [11,23,34,34,78]
print(arr)

var arr1 = [65,12,10,19,32]
print(arr1)

var arr2 = Array(repeating: "Raktim", count: 4)
print(arr2)
print(arr[2] ,";", arr1[3]) //34 ; 19


arr2[1] = "Aaryan"
print(arr2)

arr.append(86)
arr.append(95)

arr1 += [45]
arr1 += [52]

print("Updated Arrays are:", arr  ,"and",  arr1)