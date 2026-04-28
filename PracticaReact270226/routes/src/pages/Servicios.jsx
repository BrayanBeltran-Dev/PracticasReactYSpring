import serviciosImagen from '../assets/image.png'

function Servicios (){
    return(<>
<div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
    <div className="card" style={{width: '18rem'}}>
  <img src={serviciosImagen} className="card-img-top" alt=""/>
  <div className="card-body">
    <h5 className="card-title">Servicios</h5>
    <p className="card-text">Te ofrecemos los siguientes servicios</p>
    <a href="#" className="btn btn-primary">Detalles</a>
  </div>
</div>
</div>
    </>)
}
export default Servicios