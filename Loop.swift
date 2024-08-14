import Foundation

var arr:[Int] = [11,23,34,34,78]

for x in arr {
    print(x)
}

for (index , element) in arr.enumerated() {
    print("Value at index = \(index) is \(element)")
}