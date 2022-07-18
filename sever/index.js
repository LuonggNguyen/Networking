const express = require('express')
const fs = require('fs')
const sev = require('./sever')
const app = express()
const port = 8888
app.get('/bai1', (req, res) => {
    let rs 
    let name = (""+req.query.name)
    let score =(""+req.query.score)
    rs = sev.result(name,score)
    res.json(rs)
})
app.post('/bai2', (req, res) => {
  let rs 
  let a = parseInt(req.query.a)
  let b = parseInt(req.query.b)
  rs = sev.hinhhoc(a,b)
  res.json(rs)
})
app.post('/bai3', (req, res) => {
  let rs 
  let canh = parseInt(req.query.canh)
  rs = sev.thetich(canh)
  res.json(rs)
})
app.post('/bai4', (req, res) => {
  let rs 
  let a = parseInt(req.query.a)
  let b = parseInt(req.query.b)
  let c = parseInt(req.query.c)
  rs = sev.ptb2(a,b,c)
  res.json(rs)
})
//Lab3

app.get('/all_contacts', function(req, res){
  fs.readFile('./contacts/json_data.json', 'utf-8', function(err, jsonStr){
      if(err){
          res.statusCode(404);
      }else{
          const data = JSON.parse(jsonStr);
          res.json(data);
      }
  })
})

app.get('/all_contacts1', function(req, res){
  fs.readFile('./contacts/person_array.json', 'utf-8', function(err, jsonStr){
      if(err){
          res.statusCode(404);
      }else{
          const data = JSON.parse(jsonStr);
          res.json(data);
      }
  })
})

app.get('/all_contacts2', function(req, res){
  fs.readFile('./contacts/person_object.json', 'utf-8', function(err, jsonStr){
      if(err){
          res.statusCode(404);
      }else{
          const data = JSON.parse(jsonStr);
          res.json(data);
      }
  })
})

app.get('/androids', function(req, res){
  fs.readFile('./contacts/jsonandroid.html', 'utf-8', function(err, data){
      if(err){
          res.statusCode(404);
      }else{
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.write(data);
        return res.end();
      }
  })
})

app.get('/adr', function(req, res){
  fs.readFile('./contacts/adr.json', 'utf-8', function(err, jsonStr){
      if(err){
          res.statusCode(404);
      }else{
          const data = JSON.parse(jsonStr);
          res.json(data);
      }
  })
})
app.get('/data', function(req, res){
  fs.readFile('./contacts/json_data.json', 'utf-8', function(err, jsonStr){
      if(err){
          res.statusCode(404);
      }else{
          const data = JSON.parse(jsonStr);
          res.json(data);
      }
  })
})




app.listen(port, () => {
  console.log(`Example app listening on port http://localhost:${port}/`)
})