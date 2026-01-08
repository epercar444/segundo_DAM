const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.render("escuelas", { 
        escuelas: [
            { id: 'esc01', nombre: 'Escuela1', direccion: 'Calle Inventada1', telefono: '123456789' },
            { id: 'esc02', nombre: 'Escuela2', direccion: 'Calle Inventada2', telefono: '987654321' }
        ]
    });
});

module.exports = router;