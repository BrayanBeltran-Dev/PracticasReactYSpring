import { useEffect, useState } from "react";
import CardProducto from "../components/CardProducto";
function Productos(){
    const [productos, setProductos] = useState([])
    useEffect(
        ()=> {
            //ejecutar cunado se monte mi componente
            const obtenerProductos = async ()=>{
             try{   const data = await fetch('https://fakestoreapi.com/products')
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
    return(<>
        <div className="container">
            <div className="row">
                <div className="col-12">
                    <h1>Productos</h1>
                </div>
            </div>
            <div className="row">
                    {productos.map(
                        (producto)=>{
                            return(<div className="col-4" key={producto.id}>
                            <CardProducto key={producto.id} producto={producto}/>
                            </div>
                            )
                        }
                    )}
            </div>
        </div>
    </>);

}
export default Productos;