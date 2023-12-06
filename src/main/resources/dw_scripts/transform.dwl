%dw 2.0
output application/json
---

var inpString = read(jsonString,"application/json")

{
    "output" : inpString
}