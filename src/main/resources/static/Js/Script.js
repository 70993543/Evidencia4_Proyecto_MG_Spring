let btn_clean = document.querySelector(".btn-clean");

btn_clean.addEventListener("click",()=>{
    limpiarcampos('/mg/listarproducto')
})

function limpiarcampos(ruta) {
    window.location= ruta;
    return ruta;
}

