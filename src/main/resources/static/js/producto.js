let btn_clean_producto = document.querySelector(".btn-clean-producto");


btn_clean_producto.addEventListener("click",()=>{
    limpiarcampos('/mg/listarproducto');
})



function limpiarcampos(ruta) {
    window.location= ruta;
    return ruta;
}

// function multiplesEventsListeners(elem, events, func) {
//     events.split().forEach(e => elem.addEventListener(e, func, false))
// }
//
// multiplesEventsListeners(btn_clean_producto, 'click', limpiarcampos('/mg/login'))