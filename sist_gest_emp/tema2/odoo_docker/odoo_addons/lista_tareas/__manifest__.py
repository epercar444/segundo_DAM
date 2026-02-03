# -*- coding: utf-8 -*-
{
    'name': "Lista de tareas",
    'summary': "Gestión básica de tareas",
    'description': """
Módulo para gestionar una lista de tareas con estado, prioridad y fecha límite.
    """,
    'author': "My Company",
    'website': "https://www.yourcompany.com",
    'category': 'Productivity',
    'version': '1.0',

    'depends': ['base'],

    'data': [
        'security/ir.model.access.csv',
        'views/tarea_views.xml',
    ],

    'installable': True,
    'application': True,
}
