function limpiarcampos(ruta) {
    window.location= ruta;
    return ruta;
}
let btn_clean_cliente = document.querySelector(".btn-clean-cliente");

btn_clean_cliente.addEventListener("click",()=>{
    limpiarcampos('/mg/listarcliente');
})