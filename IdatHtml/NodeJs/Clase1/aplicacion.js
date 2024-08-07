const saludo = require ("./program.js")
const areas = require ("./formulas.js")
const server = require ("./serverhttp.js")

// console.log(saludo("${nombre}"))
console.log("Area del circulo: " + areas.areacirculo(5))
console.log("Area del rectangulo: " + areas.areacuadrado(5, 10))

server.iniciaServidor(3000)
