const express = require('express')
const app = express()
const port = 3000

// motor de plantillas 
app.set('view engine', 'ejs');
// carpeta de las vistas
app.use('views', express.static(__dirname + '/views'));
// para poder usar la carpeta donde tengamos ficheros (middleworld)
app.use(express.static(__dirname + '/public'))

app.use('/nuestrasEscuelas', require('./router/escuelas'));
app.use('/peques', require('./router/peques'));


app.get('/', (req, res) => {
  res.sendFile(__dirname + '/public/moe.jpg');
});

app.get('/inicio', (req, res) => {
  res.render('inicio')
})

app.get('/quienesSomos', (req, res) => {
  res.render('aboutUs.ejs')
})

app.get('/contacto', (req, res) => {
  res.render('contact.ejs')
})












app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})