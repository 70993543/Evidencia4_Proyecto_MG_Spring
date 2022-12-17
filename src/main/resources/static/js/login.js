function limpiarcampos(ruta) {
    window.location= ruta;
    return ruta;
}
let btn_clean_login = document.querySelector(".btn-clean-login");

btn_clean_login.addEventListener("click",()=>{
    limpiarcampos('/mg/login');
})