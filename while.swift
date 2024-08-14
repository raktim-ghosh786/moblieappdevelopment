import Foundation

var arr:[Int] = [11,23,34,34,78]

var i = 0

print("Printing by While Loop:")

while i <  arr.count {
    print(arr[i])
    i += 1
}

print("Printing by ForEach Loop:")

arr.forEach { x in
    print(x)
}