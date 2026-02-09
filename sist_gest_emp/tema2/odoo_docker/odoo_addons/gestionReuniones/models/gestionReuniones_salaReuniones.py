from odoo import models, fields

class SalaReuniones(models.Model):
    _name = "gestionReuniones.salaReuniones" 
    _description = "En este apartado se gestionarán las salas dónde se llevarán a cabo distintas reuniones"
    _order = "name desc"

    name = fields.Char(string="Sala Reuniones",required=True,index=True)
    description = fields.Text(string="Descripción")

    reuniones = fields.One2Many (
        comodel_name="gestionReuniones.Reunion",
        inversed_name = "sala",
        string ="Reuniones"
    )