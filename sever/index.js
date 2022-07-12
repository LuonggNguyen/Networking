const express = require('express')
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
app.listen(port, () => {
  console.log(`Example app listening on port http://localhost:${port}/`)
})