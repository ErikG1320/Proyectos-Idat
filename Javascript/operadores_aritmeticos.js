// operadores aritmeticos
// const total =4*2+(5/2)-2;
// console.log(total);

const Suma = (a, b) => a + b;
const Resta = (a, b) => a - b;
const Multiplicacion = (a, b) => a * b;
const Division = (a, b) => a / b;
const Residuo = (a, b) => a % b;

const resultado_suma = Suma(1, 2);
const resultado_resta = Resta(1, 2);
const resultado_multiplicacion = Multiplicacion(1, 2);
const resultado_division = Division(2, 2);
const resultado_residuo = Residuo(1, 2);
const resordenado =`el resultado de la suma es : ${resultado_suma},
    el resultado de la resta es : ${resultado_resta},
    el resultado de la multiplicacion es : ${resultado_multiplicacion},
    el resultado de la division es : ${resultado_division},
    el resultado de la residuo es : ${resultado_residuo}`;
    console.log(resordenado);
