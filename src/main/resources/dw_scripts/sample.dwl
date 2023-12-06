%dw 2.0
output application/json


---
{
    //"result_1": payload.inputString,
    //"result_2": payload.secondString,
    //"result_3": payload.thirdString,
    "combined" : payload.inputString ++ ' '++ payload.secondString ++ ' '++ payload.thirdString.a ++ ' '++ payload.thirdString.b
}