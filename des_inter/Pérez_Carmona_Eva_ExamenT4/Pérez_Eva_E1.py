# Eva Pérez Carmona
import datapane as dp
import pandas as pd

#en esta línea, leemos el csv de donde sacaremos la información
fichero_csv = pd.read_csv ("uso_servicios_municipales.csv")

#creamos la tabla interactiva con la información del csv
data_table = dp.DataTable(fichero_csv)

#construimos nuestro informe 
report = dp.Report(data_table)

#generemos el html y abrimos la interfaz
report.save(path = "Pérez_Eva_E1_tabla.html",open = True)