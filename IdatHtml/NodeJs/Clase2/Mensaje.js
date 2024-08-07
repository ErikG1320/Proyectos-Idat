const saludo =(nombre)=>{
    return `Hola ${nombre}, bienvenido al curso de NodeJs`;
}
document.addEventListener('DOMContentLoaded',()=>{
    const nombre = prompt('Ingrese su nombre');
    const saludoElemento = document.getElementById('saludo');
    saludoElemento.textContent = saludo(nombre);
});