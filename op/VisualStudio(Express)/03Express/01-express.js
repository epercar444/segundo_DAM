const express = require('express')
const app = express()
const port = 3000

//Conexión a base de datos
const mongoose = require('mongoose');
//Variables que tendremos siempre:
//Lo correcto será declararlas EN VARIABLES DE ENTORNO
//para que nadie vea directamente nuestras credenciales
const user = 'eva_db_user';
const password = 'XNWWBF';
const dbname = 'pokemon';
const uri = `mongodb+srv://${user}:${password}@evaperezcluster1.pksd3qw.mongodb.net/${dbname}?retryWrites=true&w=majority`;
mongoose.connect(uri)
  .then(() => console.log('Base de datos conectada'))
  .catch(e => console.log(e))

// motor de plantillas 
app.set('view engine', 'ejs');

// carpeta de las vistas
app.use('views', express.static(__dirname + '/views'));

// para poder usar la carpeta donde tengamos ficheros (middleworld)
app.use(express.static(__dirname + '/public'))

// llamamos al fichero de las rutas
app.use('/', require('./router/rutas'));
app.use('/pokemon', require('./router/pokemon'));


app.get('/pruebas', (req, res) => {
    //console.log(__dirname + '/public') // pinta la ruta de donde estamos
  res.render('pruebas', {titulo:'Título dinámico'})
})

/*
app.get('/public/html/contacto.html', (req, res) => {
  res.send('Estás en contacto')
})

app.get('/public/html/about_us.html', (req, res) => {
  res.send('Estás en about us')
})

app.get('/public/html/productos.html', (req, res) => {
  res.send('Estás en productos')
})

app.use((req, res) => {
  res.status(404).sendFile(__dirname + "/public/html/404.html")
})
  */

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})