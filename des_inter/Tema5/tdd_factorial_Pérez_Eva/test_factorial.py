from factorial import factorial
import pytest

def test_factorial_uno():
    assert factorial(1) == 1

def test_factorial_cinco():
    assert factorial(5) == 120

def test_factorial_negativo():
    with pytest.raises(ValueError):
        factorial(-1)

def test_factorial_no_entero():
    with pytest.raises(TypeError):
        factorial(5.5)