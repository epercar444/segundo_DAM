const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.render("escuelas", { 
        escuelas: [
            { id: '01', nombre: 'Alumno1', direccion: 'Calle Inventada1', telefono: '123456789' },
            { id: '02', nombre: 'Alumno2', direccion: 'Calle Inventada2', telefono: '987654321' }
        ]
    });
});

module.exports = router;