import {useState} from "react";

function FormVideojuego() {
    const [form, setForm] = useState({
        titulo : '',
        genero: '',
        plataforma: '',
        anioLanzamiento: '',
        estudio: '',
        duracionHoras: '',
        jugadoresMaximos:'',
        idioma: ''
    })
    const [videojuegos, setVideojuegos] = useState([])
    const [mensaje, setMensaje] = useState('')
    const [error, setError] = useState('')
    const listar = async () => {
        const response = await fetch('http://localhost:8080/api/videojuegos')
        const data = await response.json()
        setVideojuegos(data)
    }

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        if(form.titulo === '' || form.genero === '' || form.plataforma === ''
            || form.anioLanzamiento === '' || form.estudio === '' || form.duracionHoras === ''
            || form.jugadoresMaximos === '' || form.idioma === '') {
            setError('Faltan campos obligatorios')
            return
        }
        setError('')
        const response = await fetch('http://localhost:8080/api/videojuegos', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(form)
        })
        if (response.ok) {
            setMensaje('Videojuego registrado correctamente')
        }
        setForm({
            titulo : '',
            genero: '',
            plataforma: '',
            anioLanzamiento: '',
            estudio: '',
            duracionHoras: '',
            jugadoresMaximos:'',
            idioma: ''
        })

    }
    const handleReset = (e) => {
        e.preventDefault()
        setForm({
            titulo : '',
            genero: '',
            plataforma: '',
            anioLanzamiento: '',
            estudio: '',
            duracionHoras: '',
            jugadoresMaximos:'',
            idioma: ''
        })
        setMensaje('')
        setError('')
        setVideojuegos([])
    }
    return (
        <div className="container mt-4">
            <h4 className="mt-4 text-center">Registrar Videojuego</h4>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label className="form-label">Titulo:</label>
                    <input className="form-control" name="titulo"
                           value={form.titulo} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Genero:</label>
                    <input className="form-control" name="genero"
                           value={form.genero} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Plataforma:</label>
                    <input className="form-control" name="plataforma"
                           value={form.plataforma} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Año Lanzamiento:</label>
                    <input type="number" className="form-control" name="anioLanzamiento"
                           value={form.anioLanzamiento} onChange={handleChange} />
                </div>

                <h4 className=" mt-4 mb-4 text-center">Detalles del Videojuego:</h4>


                <div className="mb-3">
                    <label className="form-label">Estudio:</label>
                    <input className="form-control" name="estudio"
                           value={form.estudio} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Duracion Horas:</label>
                    <input type="number" className="form-control" name="duracionHoras"
                           value={form.duracionHoras} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Jugadores Maximos:</label>
                    <input type="number" className="form-control" name="jugadoresMaximos"
                           value={form.jugadoresMaximos} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Idioma:</label>
                    <input className="form-control" name="idioma"
                           value={form.idioma} onChange={handleChange} />
                </div>
                {mensaje && <p className="text-success">{mensaje}</p>}
                {error && <p className="text-danger">{error}</p>}



                <div className="container-md-3 justify-content-center text-center">
                    <button type="submit" className="btn btn-primary mt-5">Registrar</button>
                    <button type="reset" className="btn btn-primary mt-5 ms-5" onClick={handleReset}>Limpiar</button>
                    <button type="button" className="btn btn-primary mt-5 ms-5" onClick={listar}>Listar</button>
                </div>
            </form>

            <table className="table text-center">
                <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Genero</th>
                    <th>Plataforma</th>
                    <th>Año de lanzamiento</th>
                </tr>
                </thead>
                <tbody>
                {videojuegos.map(e => (
                    <tr key={e.id}>
                        <td>{e.titulo}</td>
                        <td>{e.genero}</td>
                        <td>{e.plataforma}</td>
                        <td>{e.anioLanzamiento}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default FormVideojuego;