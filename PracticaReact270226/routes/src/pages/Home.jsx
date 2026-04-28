import homeImagen from '../assets/depositphotos_157969704-stock-illustration-bienvenido-welcome-in-spanish.jpg'
function Home (){
    return(<>
    <div style={{ display: "flex", justifyContent: "center", marginTop: "20px" }}>
            <div className="card" style={{width: '18rem'}}>
  <img src={homeImagen} className="card-img-top" alt=""/>
  <div className="card-body">
    <h5 className="card-title">Inicio</h5>
    <p className="card-text">Bienvenid@</p>
  </div>
</div>
</div>
    </>
    )
}
export default Home