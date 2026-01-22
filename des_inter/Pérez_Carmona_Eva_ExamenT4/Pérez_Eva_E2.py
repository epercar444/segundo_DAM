# Eva Pérez Carmona
import datapane as dp
import pandas as pd

#en esta línea, leemos el csv de donde sacaremos la información
fichero_csv = pd.read_csv ("uso_servicios_municipales.csv")

#generamos el título correspondiente
titulo = dp.HTML('<p style="Font-size:30px; text-align:center;color=#FFFFFF;background-color=#4d4d4d">Resumen ejecutivo – Uso de servicios municipales</p>')

#generamos el breve texto
texto = dp.Text("Este servicio es importante para nuestro ayuntamiento ya que ayuda a la recopilación de información de nuestro municipio a lo largo de los años.Además ofrece una visión general de la evolución del municipio.")

#BigNumber para el número total de usos
total_usos = fichero_csv["numero_usos"].sum()
big_usos = dp.BigNumber(
    heading="Número total de usos",
    value=total_usos
)

# Filtramos correctamente los años
anyo_2023 = fichero_csv[fichero_csv["anio"] == 2023]
usos_2023 = anyo_2023["numero_usos"].sum()  # Extraemos el valor escalar

anyo_2022 = fichero_csv[fichero_csv["anio"] == 2022] # <-- Cambiado a 2022
usos_2022 = anyo_2022["numero_usos"].sum()

# Calculamos la diferencia
diferencia = usos_2023 - usos_2022

big_comparacion = dp.BigNumber(
    heading="Comparación 2023/2022",
    value=usos_2023,
    change=diferencia,
    # La flecha es positiva si el año actual es mayor al anterior
    is_upward_change=usos_2023 > usos_2022 
)

#construimos nuestro informe 
report = dp.Report(
    titulo,
    texto,
    big_usos,
    big_comparacion
)

#generemos el html y abrimos la interfaz
report.save(path = "Pérez_Eva_E2_resumen.html",open = True)