import {useState} from "react";

function FormDirector() {
    const [form, setForm] = useState({
        nombre : '',
        nacionalidad: '',
        titulo: '',
        anio: '',
        genero: ''
    })
    const [directores, setDirectores] = useState([])
    const [mensaje, setMensaje] = useState('')
    const [error, setError] = useState('')
    const listar = async () => {
        const response = await fetch('http://localhost:8080/api/directores')
        const data = await response.json()
        setDirectores(data)
    }

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        if(form.nombre === '' || form.nacionalidad === '' || form.titulo === ''
        || form.anio === '' || form.genero === ''){
            setError('Faltan campos obligatorios')
            return
        }
        setError('')
        const response = await fetch('http://localhost:8080/api/directores', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(form)
        })
        if (response.ok) {
            setMensaje('Director Registrado correctamente')
        }
        setForm({
            nombre: '',
            nacionalidad: '',
            titulo: '',
            anio: '',
            genero: ''
        })

    }
    const handleReset = (e) => {
        e.preventDefault()
        setForm({
            nombre: '',
            nacionalidad: '',
            titulo: '',
            anio: '',
            genero: ''
        })
        setMensaje('')
        setError('')
        setDirectores([])
    }
    return (
        <div className="container mt-4">
            <h4 className="mt-4 text-center">Registrar Director</h4>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label className="form-label">Nombre:</label>
                    <input className="form-control" name="nombre"
                           value={form.nombre} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Nacionalidad:</label>
                    <input className="form-control" name="nacionalidad"
                           value={form.nacionalidad} onChange={handleChange} />
                </div>

                <h4 className=" mt-4 mb-4 text-center">Informacion de Peliculas</h4>

                <div className="mb-3">
                    <label className="form-label">Titulo:</label>
                    <input className="form-control" name="titulo"
                           value={form.titulo} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Año:</label>
                    <input type="number" className="form-control" name="anio"
                           value={form.anio} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Genero:</label>
                    <input className="form-control" name="genero"
                           value={form.genero} onChange={handleChange} />
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
                    <th>Nombre</th>
                    <th>Nacionalidad</th>
                </tr>
                </thead>
                <tbody>
                {directores.map(e => (
                    <tr key={e.id}>
                        <td>{e.nombre}</td>
                        <td>{e.nacionalidad}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}

export default FormDirector;