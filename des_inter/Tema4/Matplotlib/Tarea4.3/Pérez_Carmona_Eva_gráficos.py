import pandas as pd
import datapane as dp

# Cargar los datos desde el CSV
df = pd.read_csv("DI_U05_A02_PP_E_01.csv")

#GRÁFICO POR SECTORES
# Agrupar por tipo de producto y sumar (para obtener los totales)
tipo_producto = df.groupby(["Tipo de producto"]).sum()
# Crear el gráfico de sectores (tarta)
grafico_tarta = tipo_producto.plot.pie(
    y="Ventas",
    legend=False,
    ylabel=""
)
# Adaptar el gráfico para Datapane
grafico_final = dp.Plot(grafico_tarta)


#GRÁFICO DE LÍNEAS
#Obtenemos el límite de los dos últimos años
ultimos_dos_anyos = sorted(df['Año'].unique())[-2:]
#Filtramos en el Datapane para quedarnos con el valor de esos dos años
df_filtrado = df[df['Año'].isin(ultimos_dos_anyos)]
# Agrupar los datos por año y sumar por ventas
ventas_anyo = df_filtrado.groupby(["Año"], sort=True).sum()
# Crear el gráfico de líneas (Matplotlib a través de Pandas)
grafico_lineas = ventas_anyo.plot(y="Ventas")
# Adaptar el gráfico para Datapane
grafico_definitivo = dp.Plot(grafico_lineas)


#GRÁFICO DE BARRAS
# Agrupar los datos por país y sumar las ventas
ventas_pais = df.groupby(["Región"]).sum()
# Crear el gráfico de barras (Pandas usa Matplotlib internamente)
grafico_barras = ventas_pais.plot.bar(y="Ventas")
# Adaptar el gráfico para Datapane
grafico_ultimo = dp.Plot(grafico_barras)







# Crear el informe Datapane
reporte = dp.Report(
    dp.Text("# *Diseño y elaboración de gráficos*"),
    grafico_final,
    grafico_definitivo,
    grafico_ultimo
)

reporte.save("informe_gráficos.html", open=True)