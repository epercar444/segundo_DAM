from odoo import models, fields

class Reunion(models.Model):
    _name = "gestionReuniones.Reunion" 
    _description = "Reunión"
    _order = "name asc"

    name = fields.Char(string="Especialidad",required=True,index=True)
    fecha = fields.Date(string="Fecha",default=fields.Date.context_today,required=True)
    duracion = fields.Integer(string="Duracion")
    asientos = fields.Integer(string="Asientos")
    asientos_ocupados = fields.Float(string="Asientos Ocupados")

    sala = fields.Many2One (
        comodel_name="gestionReuniones.salaReuniones",
        string="Sala",
        required = True,
        ondelette="restrict"
    )

    responsable = fields.Many2One (
        comodel_name ="hr.employee",
        string="Responsable",
        required=True,
        ondelette="restrict"
    )

    asistentes = fields.Many2One (
        comodel_name ="res.partner",
        string="Asistentes",
        required=True,
        ondelette="restrict"
    )

       