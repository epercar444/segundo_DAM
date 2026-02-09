from odoo import models, fields

class HospitalHistorial(models.Model):
    _name = "Hospital.historial" 
    _description = "Historial médico"
    _order = "fecha desc","id desc"

    name = fields.Char(string="Historial",required=True,index=True)
    fecha = fields.Date(string="Fecha",default=fields.Date.context_today,required=True)
    description = fields.Text(string="Descripción")

    paciente_id = fields.Many2One(
        comodel_name ="res.partner",
        string="Paciente",
        required=True,
        ondelette="restrict"
    )

    medico_id= fields.Many2One(
        comodel_name ="hr.employee",
        string="Médico/a",
        required=True,
        ondelette="restrict"
    )

    especialidad_id = fields.Many2One(
        comodel_name ="hospital.especialidad",
        string="Especialidad",
        required=True,
        ondelette="restrict"
    )

    