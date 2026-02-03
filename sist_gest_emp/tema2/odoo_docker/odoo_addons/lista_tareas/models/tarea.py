# lista_tareas/models/tarea.py
from odoo import models, fields, api
from odoo.exceptions import ValidationError
from datetime import date

class Tarea(models.Model):
    _name = 'mi_modulo_tareas.tarea'
    _description = 'Tarea'

    name = fields.Char(string="Nombre", required=True)
    descripcion = fields.Text(string="Descripción")
    fecha_limite = fields.Date(string="Fecha límite")
    prioridad = fields.Selection(
        [('alta','Alta'),('media','Media'),('baja','Baja')],
        string="Prioridad", default='media'
    )
    estado = fields.Selection(
        [('pendiente','Pendiente'),('completada','Completada')],
        string="Estado", default='pendiente'
    )

    @api.constrains('fecha_limite')
    def _check_fecha_limite(self):
        for record in self:
            if record.fecha_limite and record.fecha_limite < date.today():
                raise ValidationError("La fecha límite no puede ser pasada")

    def marcar_como_completada(self):
        for record in self:
            record.estado = 'completada'
