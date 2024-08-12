func myadd(_ num: Int...) -> Int {
  var result = 0
  for x in num {
    result += x
  }

  return result
}



func factorial(num: Int) -> Int {
 var result = 1
     for x in 2...num {
    result *= x
}

     return result
}



print(myadd(3, 5, 6, 6))
print(factorial(num: 5))// 3 * 2 * 1