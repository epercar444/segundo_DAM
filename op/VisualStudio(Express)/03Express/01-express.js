const express = require('express')
const app = express()
const port = 3000
app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {
  res.send('Ya somos unos cracks en Node+Express!')
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})

app.get('/contacto.html',(req,res) => {
  res.send("Estás en contacto")
  console.log(__dirname)
})

app.get('/aboutUs',(req,res) => {
  res.send("Estás en aboutUs")
    console.log(__dirname)
})


//error instalando nodemon