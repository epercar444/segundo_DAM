from odoo import models, fields, api

class Reuniones(models.Model):
    _name = 'reuniones'
    _description = 'Reuniones'
    _order = 'name asc'

    name = fields.Char(string = 'Reuniones',required=True, index = True)
    fecha = fields.Date(string = 'Fecha de Inicio', default = fields.Date.context_today, required = True)
    duration = fields.Integer(string = 'duracion', default = 0)
    asientos = fields.Integer(string = 'asientos', default = 0)
    
    # Relación Many2one con Sala
    sala_id = fields.Many2one(
        comodel_name='sala.reuniones',
        string='Sala',
        required=True,
        ondelete='cascade', 
        help='Sala donde se celebra la reunión'
    )
    
    # Relación Many2one con Responsable
    responsable_id = fields.Many2one(
        comodel_name='res.partner',
        string='Responsable',
        required=True,
        help='Persona responsable de la reunión'
    )
    
    # Relación Many2many con Asistentes
    asistentes_ids = fields.Many2many(
        comodel_name='res.partner',
        string='Asistentes',
        help='Personas que asisten a la reunión'
    )
    
    # Campo calculado: Porcentaje de asientos ocupados
    porcentaje_ocupacion = fields.Float(
        string='% Ocupación',
        compute='_compute_porcentaje_ocupacion',
        store=True,
        help='Porcentaje de asientos ocupados'
    )
    
    # Método para calcular el porcentaje de ocupación
    @api.depends('asientos', 'asistentes_ids')
    def _compute_porcentaje_ocupacion(self):
        """
        Calcula el porcentaje de asientos ocupados.
        Porcentaje = (número de asistentes / asientos totales) * 100
        """
        for record in self:
            if record.asientos > 0:
                num_asistentes = len(record.asistente_ids)
                record.porcentaje_ocupacion = (num_asistentes / record.asientos) * 100
            else:
                record.porcentaje_ocupacion = 0.0