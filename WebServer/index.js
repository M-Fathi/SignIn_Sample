const express = require('express')
const bodyParser = require("body-parser");
const app = express()
const port = 4200
const sampleAccessToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1laWRlbnRpZmllciI6IjIiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiYWRtaW4iLCJBc3BOZXQuSWRlbnRpdHkuU2VjdXJpdHlTdGFtcCI6IjdjZGU4OWQwLTQ5OWUtNDA0Yi00MjExLTM5ZTY3ODY4NDJiYiIsImh0dHA6Ly9zY2hlbWFzLm1pY3Jvc29mdC5jb20vd3MvMjAwOC8wNi9pZGVudGl0eS9jbGFpbXMvcm9sZSI6IkFkbWluIiwiaHR0cDovL3d3dy5hc3BuZXRib2lsZXJwbGF0ZS5jb20vaWRlbnRpdHkvY2xhaW1zL3RlbmFudElkIjoiMSIsInN1YiI6IjIiLCJqdGkiOiIwZjJmNmNjYS04OTRkLTQ5ZTktYmY4ZS1jNGI4ZWNiY2Y3ZGUiLCJpYXQiOjE2MDY1NTM5NDgsInRva2VuX3ZhbGlkaXR5X2tleSI6IjcwNDJlYWFkLWNhNDMtNDNlOC05OWQzLTMzMjBhYzZlZmI1OCIsInVzZXJfaWRlbnRpZmllciI6IjJAMSIsIm5iZiI6MTYwNjU1Mzk0OCwiZXhwIjoyMTQ3NDgzNjQ3LCJpc3MiOiJTRVBBZXhwcmVzcyIsImF1ZCI6IlNFUEFleHByZXNzIn0.Xa1v3O_168ZjNuGgE4o3CgAiKip4VvQHPNdy2sxCKrA"

app.use(bodyParser.json());


app.get('/', (req, res) => {
  res.send('welcome to Api Server ')
})

app.get('/createUser', (req, res) => {
    res.send('Hello World!')
})

app.post('/api/TokenAuth/Authenticate', (req, res) => {
    //console.log("username",req.body.usernameOrEmailAddress, "Password", req.body.password);
 
    var response = {
        "userId": "54ec97e451d3dd4ae63dfccd9b2a49e2",        
        "userName": req.body.username,
        "accessToken": sampleAccessToken , 
        "expirationDate" : new Date(Date.now() + ( 3600 * 1000 * 24 * 365))
        
    };

    res.send(response) ;
})


app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})