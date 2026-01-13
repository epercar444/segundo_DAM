import pandas as pd
import datapane as dp

#empezamos haciendo una lectura del fichero CSV con el que vamos a trabajas
fichero_csv = "DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)

table = dp.Table(df) #creamos la tabla interactiva con la que accederemos a la información necesaria
data_table = dp.DataTable(df)

report = dp.Report(table, data_table)

#resumen ejecutivo
total_ventas = df["Ventas"].sum()

ventas_por_anyo = df.groupby("Año")["Ventas"].sum()
anyo_mayor_ventas = ventas_por_anyo.idxmax()
max_ventas_anyo = ventas_por_anyo.max()

#resumen
resumen = dp.HTML("<p>Estos datos permiten a la dirección evaluar la evolución global de las ventas a lo largo de los años e identificar los periodos de mayor rendimiento. Con esta información se pueden detectar tendencias, optimizar la planificación comercial y apoyar la toma de decisiones estratégicas basadas en resultados reales.</p>")

#resumen_ejecutivo = dp.Report(
    #total_ventas,
    #max_ventas_anyo,
    #resumen
#)


#definimos los atributos que debe tener el resumen general
titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
) 

#filtra y suma
datos_2021 = df[df['Año'] == 2021]
unidades_2021 = datos_2021['Ventas'].sum()

datos_2020 = df[df['Año'] == 2020]
unidades_2020 = datos_2020['Ventas'].sum()

unidades = dp.BigNumber( 
    heading='Comparación 2020/2021', #titulo
    value=datos_2021, #valor
    change=datos_2021 - datos_2020, #diferencia con el valor anterior
    is_upward_change=datos_2021 > datos_2020 #indica mejora o deterioramiento
)

#imagen
imagen = dp.Media(file='DI_U05_A02_PP_E_02.png')

#posibilidad de descargar el ficheor csv
fichero = dp.Attachment(file='DI_U05_A02_PP_E_01.csv') 

#resumen general
resumen = dp.Report(
    titulo,
    imagen,
    unidades,
    data_table,
    fichero
)
report.save(path='DI_U05_A02_PP_E_01.html', open=True) #hacemos que haga un informe para acceder a la interfaz
