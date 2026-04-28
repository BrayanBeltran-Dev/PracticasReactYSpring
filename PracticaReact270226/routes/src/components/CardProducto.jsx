import { useNavigate } from "react-router-dom";
function CardProducto ({producto}){
    const navigate = useNavigate();
    return(
    <>
    <div className="card">
  <img src={producto.image} className="card-img-top" alt="..."/>
  <div className="card-body">
    <h5 className="card-title">{producto.title}</h5>
    <p className="card-text">{producto.description}</p>
    <p>${producto.price}</p>
    <button className="btn btn-primary" onClick={ () => navigate(`/productos/${producto.id}`) } >
			              Ver detalle
						</button>
  </div>
</div>
    </>
    )
}
export default CardProducto