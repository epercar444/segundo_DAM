{
    'name': "Sala Reuniones",

    'summary': "Salas de reuniones de la empresa",

    'description': """
        Módulo de gestión de salas de reuniones
        ========================================
        
        Este módulo permite:
        * Crear y gestionar salas de reuniones
        * Programar reuniones en las salas
        * Asignar responsables y asistentes
        * Calcular el porcentaje de ocupación de las reuniones
    """,
    'author': "Sala Reuniones",
    'website': "https://www.yourcompany.com",
    'category': 'tools',
    'license': 'LGPL-3',
    'version': '1.0',
    'depends': ['base'],
    'data': [
        'security/ir.model.access.csv',
        'views/sala_reuniones_views.xml',
        'views/reuniones_views.xml',
        
    ],

    'installable': True,
    'application': True,

}

