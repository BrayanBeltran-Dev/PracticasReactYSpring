import { BrowserRouter, Routes , Route} from 'react-router-dom'
import Home from './pages/Home'
import Servicios from './pages/Servicios'
import Productos from './pages/Productos'
import Navbar from './components/Navbar'
import DetalleProducto from './pages/DetalleProducto'
import 'bootstrap/dist/css/bootstrap.min.css'


function App() {

  return (
      <BrowserRouter>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/servicios" element={<Servicios/>}/>
        <Route path="/productos" element={<Productos/>}/>
        <Route path="/productos/:id" element={<DetalleProducto/>}/>
      </Routes>
      </BrowserRouter>
  )
}

export default App
