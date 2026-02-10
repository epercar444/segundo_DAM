import pytest
import cartera

def test_saldo_inicial():
    mi_cartera = cartera.Cartera()
    assert mi_cartera.saldo == 0

def test_tipo_incorrecto():
    mi_cartera = cartera.Cartera("Hola")
    assert mi_cartera.saldo == 0

def test_saldo_negativo():
    mi_cartera = cartera.Cartera(-100)
    assert mi_cartera.saldo == 0

def test_saldo_valido():
    mi_cartera = cartera.Cartera(500)
    assert mi_cartera.saldo == 500

def test_suma_correcta():
    mi_cartera = cartera.Cartera(100)
    mi_cartera.ingresar(50)
    assert mi_cartera.saldo == 150

def test_resta_correcta():
    mi_cartera = cartera.Cartera(100)
    mi_cartera.gastar(30)
    assert mi_cartera.saldo == 70 

def test_gastar_excesivo():
    mi_cartera = cartera.Cartera(50)
    mi_cartera.gastar(100)
    assert mi_cartera.saldo == 50