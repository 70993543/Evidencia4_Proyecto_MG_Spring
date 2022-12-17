function limpiarcampos(ruta) {
    window.location= ruta;
    return ruta;
}

let btn_clean_categoria = document.querySelector(".btn-clean-categoria");

btn_clean_categoria.addEventListener("click",()=>{
    limpiarcampos('/mg/listarcategoria');
})