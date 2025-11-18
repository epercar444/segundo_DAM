const express = require('express')
const app = express()
const port = 3000
app.set('view engine','ejs')
app.set('views', __dirname + '/views') 
app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {
  res.send('Ya somos unos cracks en Node+Express!')
})
app.get('/indexEJS', (req, res) => {
  res.render('indexEJS',{titulo: "Titulo dinamico"})
})
app.get('/contacto.html',(req,res) => {
  res.send("Estás en contacto")
  console.log(__dirname)
})

/*app.use((req,res)=> {
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})*/

app.get('/aboutUs',(req,res) => {
  res.send("Estás en aboutUs")
    console.log(__dirname)
})

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})




//error instalando nodemon