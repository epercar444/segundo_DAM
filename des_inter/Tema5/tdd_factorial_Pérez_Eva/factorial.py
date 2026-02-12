def factorial(n):
    if not isinstance(n, int): 
        raise TypeError("Debe ser entero")
    if n < 0: 
        raise ValueError("No debe ser negativo")
    
    # Lógica general que satisface 0, 1 y 5
    res = 1
    for i in range(2, n + 1):
        res *= i
    return res