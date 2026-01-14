import pandas as pd
import datapane as dp

#empezamos haciendo una lectura del fichero CSV con el que vamos a trabajas
fichero_csv = "DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)

#definimos los atributos que debe tener el resumen general
titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
) 

#imagen
imagen = dp.Media(file='DI_U05_A02_PP_E_02.jpg')

#total número de ventas 
total_ventas_numero = df["Ventas"].sum()
total_ventas = dp.BigNumber(
    heading="Número total de ventas",
    value=total_ventas_numero
) 

#para conseguir el año con mayor número de ventas, sacamos las ventas de cada año y nos quedamos con la más grande
ventas_por_anyo = df.groupby("Año")["Ventas"].sum()
anyo_mayor_ventas = ventas_por_anyo.idxmax()
anyo_mayorVenta = dp.BigNumber(
    heading="El año con mayor número de ventas es:",
    value=anyo_mayor_ventas
) 

#resumen
texto = dp.HTML("<p>Estos datos permiten a la dirección evaluar la evolución global de las ventas a lo largo de los años e identificar los periodos de mayor rendimiento. Con esta información se pueden detectar tendencias, optimizar la planificación comercial y apoyar la toma de decisiones estratégicas basadas en resultados reales.</p>")

#filtra las ventas por año y hace la comparación
datos_2021 = df[df['Año'] == 2021]
unidades_2021 = datos_2021['Ventas'].sum()

datos_2020 = df[df['Año'] == 2020]
unidades_2020 = datos_2020['Ventas'].sum()

unidades = dp.BigNumber( 
    heading='Comparación 2020/2021', #titulo
    value=unidades_2021, #valor
    change=abs(unidades_2021 - unidades_2020), #diferencia con el valor anterior, colocamos el abs para que en la pantalla no salga --411
    is_upward_change=unidades_2021 > unidades_2020 #indica mejora o deterioramiento
)

#posibilidad de descargar el ficheor csv
fichero = dp.Attachment(file='DI_U05_A02_PP_E_01.csv') 

#creamos la tabla interactiva con la que accederemos a la información necesaria
table = dp.Table(df)
data_table = dp.DataTable(df)

#resumen general
resumen = dp.Report(
    titulo,
    imagen,
    total_ventas,
    anyo_mayorVenta,
    texto,
    unidades,
    data_table,
    fichero
)
resumen.save(path='DI_U05_A02_PP_E_01.html', open=True) #hacemos que haga un informe para acceder a la interfaz
