const loadPedidos = async () => {
    let tabla = document.getElementById("body");
    let pedidos;
    let res = await fetch("/api/v1/devices/tablet");
    if (res.ok) {
        pedidos= await res.json();
    }
    for(let i=0; i <pedidos.length; i++){

        let newRow = tabla.insertRow(tabla.length);
        let pedidoActual=json2array(pedidos[i]);
        for(let j=0; j<pedidoActual.length; j++){

            let cell = newRow.insertCell(j);
            cell.innerHTML = pedidoActual[j];
        }
    }
}


let json2array=(json)=>{
    let result = [];
    let keys = Object.keys(json);
    keys.forEach(function(key){
        result.push(json[key]);
    });
    return result;
}