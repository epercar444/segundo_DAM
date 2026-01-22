# Eva Pérez Carmona
import pandas as pd
import datapane as dp

#en esta línea, leemos el csv de donde sacaremos la información
fichero_csv = pd.read_csv ("uso_servicios_municipales.csv")

#grafico de sectores
servicios = fichero_csv.groupby(["servicio"],sort=False).sum()
grafico_sectores = servicios.plot.pie(y="numero_usos",legend=False,ylabel="")
grafico_sectores_final = dp.Plot (grafico_sectores)

#grafico de lineas
anyos = fichero_csv.groupby(["anio"],sort=False).sum()
grafico = anyos.plot(y="numero_usos")
grafico_definitivo = dp.Plot(grafico)

#grafico de barras
distritos = fichero_csv.groupby(["distrito"],sort=False).sum()
grafico_barras = distritos.plot.bar(y="numero_usos")
grafico_ultimo = dp.Plot(grafico_barras)

#construimos nuestro informe 
report = dp.Report(
    grafico_sectores_final,
    grafico_definitivo,
    grafico_ultimo
)
#generemos el html y abrimos la interfaz
report.save(path = "Pérez_Eva_E3_graficos.html",open = True)