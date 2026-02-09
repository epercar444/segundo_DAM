from odoo import models, fields

class HospitalEspecialidad(models.Model):
    _name = "Hospital.especialidad" 
    _description = "Especialidad médica"
    _order = "name asc"

    name = fields.Char(string="Especialidad",required=True,index=True)
    description = fields.Text(string="Descripción")

    historial_id = fields.One2Many (
        comodel_name="hospital.historial",
        inversed_name = "especialidad_id",
        string ="Historiales"
    )