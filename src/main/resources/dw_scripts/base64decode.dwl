%dw 2.0

import fromBase64 from dw::core::Binaries
import java!com::example::dw::javaspringdw::models::Base64Request
output application/json
var ip = "test"
var pload = read(payload,"application/json")
---
{
    response : fromBase64(pload.inputString) as String
}