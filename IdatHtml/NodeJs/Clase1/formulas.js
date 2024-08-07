const areacirculo = (radio)=>{
    return 3.14* Math.pow(radio, 2);
}
const areacuadrado = (lado=>{
    return Math.pow(lado, 2);
})

module.exports={
    areacirculo,
    areacuadrado
}
