%dw 2.0
output application/json

---
var foo = read(jsonString,"application/json")
{
    "message": payload,
    "foo": foo.v1

}