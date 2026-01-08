const express = require('express');
const router = express.Router();
const Libro = require('../models/libro');

router.get('/', async (req, res) => {
    try {
        const arrayLibroDB = await Libro.find();
        console.log(arrayLibroDB);
        res.render("libro", { 
            arrayLibro: arrayLibroDB
        })
    } catch (error) {
        console.error(error)
    }
})

router.get('/crear', (req, res) =>{
    res.render('crear') //Nueva vista que debemos crear
})

router.post('/', async (req, res) => {
    const body = req.body //Gracias al body parser, de esta forma
    //podremos recuperar todo lo que viene del body
    console.log(body) //Para comprobarlo por pantalla
    try {
        const libroDB = new Libro(body) 
        await libroDB.save() //Lo guardamos con .save(), gracias a Mongoose
        res.redirect('/libro') //Volvemos al listado
    } catch (error) {
        console.log('error', error)
    }
})

router.get('/:id', async(req, res) => { //El id vendrá por el GET (barra de direcciones)
    const id = req.params.id
    //a este campo pokemon.id, por eso lo llamados con params.id
    try {
        const libroDB = await Libro.findOne({ _id: id }) //_id porque así lo indica Mongo
							//Esta variable “Pokemon” está definida arriba con el “require”
        //Buscamos con Mongoose un único documento que coincida con el id indicado
        console.log(libroDB) //Para probarlo por consola
        res.render('detalle', { //Para mostrar el objeto en la vista "detalle", que tenemos que crear
            libro: libroDB,
            error: false
        })
    } catch (error) { //Si el id indicado no se encuentra
        console.log('Se ha producido un error', error)
        res.render('detalle', { //Mostraremos el error en la vista "detalle"
            error: true,
            mensaje: 'Libro no encontrado!'
        })
    }
})

module.exports = router;