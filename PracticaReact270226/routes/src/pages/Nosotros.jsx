import nosotrosImagen from '../assets/pagina-acerca-de-nosotros.jpg'
function Nosotros (){
    return(<>
<div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
        <div className="card" style={{width: '18rem'}}>
  <img src={nosotrosImagen} className="card-img-top" alt=""/>
  <div className="card-body">
    <h5 className="card-title">Nosotros</h5>
    <p className="card-text">Somos una empresa de desarrollo de software</p>
    <a href="#" className="btn btn-primary">Saber mas...</a>
  </div>
</div>
</div>
    </>)
}
export default Nosotros