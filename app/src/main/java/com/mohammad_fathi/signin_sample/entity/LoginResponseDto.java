package com.mohammad_fathi.signin_sample.entity;

import com.google.gson.annotations.SerializedName;

public class LoginResponseDto {
    @SerializedName("result")
    public LoginResponseResultDto result;
    @SerializedName("error")
    public LoginResponseErrorDto error;
    public String  targetUrl;
    public Boolean  success;
    public String  unAuthorizedRequest;
}
//https://www.journaldev.com/13639/retrofit-android-example-tutorial
//https://stackoverflow.com/questions/46932169/retrofit-response-500-internal-server-error

//Success sample json response
//{
//        "result": {
//           "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjEiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiYWRtaW4iLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6ImI2ODE4MWMwLTg0ZDEtZTU1Ny1jNDZlLTM5Zjc3MGUxNGFkNSIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IkFkbWluIiwic3ViIjoiMSIsImp0aSI6ImJhYWVlN2U4LWU5N2MtNGU5ZC1iMTY2LTg0MDE1ZDY4MDA2NyIsImlhdCI6MTYwNTMwNjM1MiwibmJmIjoxNjA1MzA2MzUyLCJleHAiOjE2MDUzOTI3NTIsImlzcyI6IkJpdGlyYW4iLCJhdWQiOiJCaXRpcmFuIn0.igGOs_eWZHCzL9QrVjpcV9YahwJ8E5ytUfpFzLK5AHA",
//           "encryptedAccessToken": "wNYmO41/48SHNstaLVXxHCCre29BZQl1NhC6NM3R3rzpXtPQxVzH6jEzA/QhXFN5tu6Fk7pO53uppm1mVXMZgxbyRVz26dnepi/FyB6axBY+6gq1GL+uRQgoiFUCjRN2p8w6LevViwKlHyWZZJZO1DGVSjAi1m2U+og9pkHw9/QR4Nl/DPnoP9JYDMpZ1zxx09u6s0GZ9/Q5Sjk+L0UfcSCbl38X8he5w9UIn/Hvxh7ysM1CiPLsoOwtbiieSRVmrmt0JjnipAn4/K283F8GrGwzwgehWsqefmUnM0ckMwP9ZAdwQxWDhxv0IqNw4tDhwUYs/1SYdYozdNzgByhgNOBPzQDObNLlWc4vV5VMOiZUxolE10PPpyG+NXKoT7TYfHu6nUHuXAmmrDQj5nGI4E5MDXuR/yNMPq5lcil8O49ixTebWpjbk9PNct2fPKUJhdmeAeQ5jHA69jAWTvZGF9a6B3dtqWLqOdiwa0gJWuCFgiZEs2X2looTbCpGrzubekFLAneM4FL5Rxx1UNhdOcVGxKXobtpl5Y2q7sY7J2RrZn48SMgVTYhHWGwiDblFzaW2cLuwYsma857LDz5WclbMEwlxxhOU6w9dCNBKTxAdfnIxdQyyPmxDCn9ctY7uuDrhji52CC8yr6kbj/wQynE2KeNocDboqqbls2Kzstd9WSGvmtTvCKoh2OGPFCXfJiBNjEtfawqWpM92VGEiO55yfd2bwwimCggk1R9ZSDDinZ5bhECmb59EpA87hxnQXwIYyuk4J/DR2N+xwi1wI1ovRfWXIfvwmjOOQ61rbDGarWDJQLwEVpa32UEokBJWtgBDZBRmZhOVW8tZ7B2fTJkDtsVs+pEcW5ck+wBLA/k=",
//           "expireInSeconds": 86400,
//           "userId": 1
//        },
//        "targetUrl": null,
//        "success": true,
//        "error": null,
//        "unAuthorizedRequest": false,
//        "__abp": true
//        }

//Error  sample json response
//{
//        "result": null,
//        "targetUrl": null,
//        "success": false,
//        "error": {
//           "code": 0,
//           "message": "Your request is not valid!",
//           "details": "The following errors were detected during validation.\r\n - Unexpected character encountered while parsing value: U. Path '', line 0, position 0.\r\n",
//           "validationErrors": [{ "message": "Unexpected character encountered while parsing value: U. Path '', line 0, position 0.", "members": [""] }]
//        },
//        "unAuthorizedRequest": false,
//        "__abp": true
//        }
