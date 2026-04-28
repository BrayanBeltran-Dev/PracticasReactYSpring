import { useEffect, useState } from "react";

import {useParams }from"react-router-dom";

function DetalleProducto() {
	const { id }=useParams();
	const [productos, setProductos] = useState([])
	 useEffect(
			()=> {
				//ejecutar cunado se monte mi componente
				const obtenerProductos = async ()=>{
				 try{   const data = await fetch(`https://fakestoreapi.com/products/${id}`)
						const productos = await data.json()
						console.log("Productos obtenidos: ", productos)
						setProductos(productos)
				 }catch(error){
					console.log("Error al obtener productos:", error)
				 }
				}
				obtenerProductos()
			},
			[]
		)
	return (
		<div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
				<div className="card" style={{width: '18rem'}}>
					<img src={productos.image} className="card-img-top" alt="..."/>
		  <div className="card-body">
			<h5 className="card-title">Detalle del producto</h5>
			<p className="card-text">{productos.description}</p>
			<p className="card-text">ID del producto : {id}</p>
		  </div>
		</div>
		</div>
	  );
}

export default DetalleProducto;