import {useState} from "react";

function FormRestaurante(){
    const [form, setForm] = useState({
        nombre : '',
        tipoCocina: '',
        telefono: '',
        anioApertura: '',
        calle: '',
        ciudad:'',
        codigoPostal:'',
        capacidadMesas:''
    })
    const [id, setId] = useState('')
    const [restaurantes, setRestaurantes] = useState([])
    const [mensaje, setMensaje] = useState('')
    const [error, setError] = useState('')
    const [errorBuscar, setErrorBuscar] = useState('')
    const buscarPorId = async () => {
        if(id === ''){
            setErrorBuscar('Error con el id')
            return
        }
        setErrorBuscar('')
        const response = await fetch(`http://localhost:8080/api/restaurantes/${id}`)
        const data = await response.json()
        setRestaurantes([data])
    }

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        if(form.nombre === '' || form.tipoCocina === '' || form.telefono === ''
            || form.anioApertura === '' || form.calle === '' || form.ciudad === ''
        || form.codigoPostal === '' || form.capacidadMesas === ''){
            setError('Faltan campos obligatorios')
            return
        }
        setError('')
        const response = await fetch('http://localhost:8080/api/restaurantes', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(form)
        })
        if (response.ok) {
            setMensaje('Restaurante registrado correctamente')
        }
        setForm({
            nombre : '',
            tipoCocina: '',
            telefono: '',
            anioApertura: '',
            calle: '',
            ciudad:'',
            codigoPostal:'',
            capacidadMesas:''
        })

    }
    const handleReset = (e) => {
        e.preventDefault()
        setForm({
            nombre : '',
            tipoCocina: '',
            telefono: '',
            anioApertura: '',
            calle: '',
            ciudad:'',
            codigoPostal:'',
            capacidadMesas:''
        })
        setMensaje('')
        setError('')
        setRestaurantes([])
    }
    return (
        <div className="container mt-4">
            <h4 className="mt-4 text-center">Registrar Restaurante:</h4>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label className="form-label">Nombre:</label>
                    <input className="form-control" name="nombre"
                           value={form.nombre} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Tipo de Cocina:</label>
                    <input className="form-control" name="tipoCocina"
                           value={form.tipoCocina} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Telefono:</label>
                    <input className="form-control" name="telefono"
                           value={form.telefono} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Año apertura:</label>
                    <input type="number" className="form-control" name="anioApertura"
                           value={form.anioApertura} onChange={handleChange} />
                </div>

                <h4 className=" mt-4 mb-4 text-center">Detalles del restaurante:</h4>

                <div className="mb-3">
                    <label className="form-label">Calle:</label>
                    <input className="form-control" name="calle"
                           value={form.calle} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Ciudad:</label>
                    <input className="form-control" name="ciudad"
                           value={form.ciudad} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">C.P.:</label>
                    <input className="form-control" name="codigoPostal"
                           value={form.codigoPostal} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Capacidad Mesas:</label>
                    <input type="number" className="form-control" name="capacidadMesas"
                           value={form.capacidadMesas} onChange={handleChange} />
                </div>
                {mensaje && <p className="text-success">{mensaje}</p>}
                {error && <p className="text-danger">{error}</p>}



                <div className="container-md-3 justify-content-center text-center">
                    <button type="submit" className="btn btn-primary mt-5 justify-content-center ms-5">Registrar</button>
                    <button type="reset" className="btn btn-primary mt-5 justify-content-center ms-5" onClick={handleReset}>Limpiar</button>
                </div>

            </form>

            <div className="mb-3 mt-3">
                <label className="form-label">Buscar por ID:</label>
                <input className="form-control" value={id}
                       onChange={(e) => setId(e.target.value)} />
            </div>
            {errorBuscar && <p className="text-danger">{errorBuscar}</p>}
            <div className="mb-3 justify-content-center text-center">
            <button type="button" className="btn btn-primary mt-5 ms-5 " onClick={buscarPorId}>buscar</button>
            </div>
            <table className="table text-center">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Tipo Cocina</th>
                    <th>Telefono</th>
                    <th>Año Apertura</th>
                </tr>
                </thead>
                <tbody>
                {restaurantes.map(e => (
                    <tr key={e.id}>
                        <td>{e.nombre}</td>
                        <td>{e.tipoCocina}</td>
                        <td>{e.telefono}</td>
                        <td>{e.anioApertura}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
            )
}
export default FormRestaurante;