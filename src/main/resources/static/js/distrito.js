function limpiarcampos(ruta) {
    window.location= ruta;
    return ruta;
}
let btn_clean_distrito = document.querySelector(".btn-clean-distrito");

btn_clean_distrito.addEventListener("click",()=>{
    limpiarcampos('/mg/listardistrito');
})
