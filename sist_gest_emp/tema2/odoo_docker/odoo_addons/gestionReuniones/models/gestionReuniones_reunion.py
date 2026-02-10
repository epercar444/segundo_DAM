from odoo import models, fields, api

class Reunion(models.Model):
    _name = "gestionReuniones.Reunion" 
    _description = "Reunión"
    _order = "name asc"

    name = fields.Char(string="Especialidad", required=True, index=True)
    fecha = fields.Date(string="Fecha", default=fields.Date.context_today, required=True)
    duracion = fields.Integer(string="Duracion")
    asientos = fields.Integer(string="Asientos")
    
    sala = fields.Many2one(
        comodel_name="gestionReuniones.salaReuniones",
        string="Sala",
        required=True
    )

    responsable = fields.Many2one(
        comodel_name="hr.employee",
        string="Responsable",
        required=True
    )

    asistentes = fields.Many2many(
        comodel_name="res.partner",
        string="Asistentes"
    )

    porcentaje_ocupacion = fields.Float(
        string="Porcentaje de Ocupación",
        compute="_compute_porcentaje_ocupacion"
    )

    @api.depends('asientos', 'asistentes')
    def _compute_porcentaje_ocupacion(self):
        for record in self:
            if record.asientos > 0:
                record.porcentaje_ocupacion = (len(record.asistentes) / record.asientos) * 100
            else:
                record.porcentaje_ocupacion = 0.0