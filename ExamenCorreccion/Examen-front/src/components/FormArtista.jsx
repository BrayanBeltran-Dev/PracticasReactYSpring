import {useState} from "react";

function FormArtista(){
    const [form, setForm] = useState({
        nombre: '',
        nacionalidad: '',
        generoMusical: '',
        anioDebut: '',
        disquera: '',
        albumsProducidos: '',
        premiosGanados: '',
    })
    const [enActivo, setEnActivo] = useState(false)
    const [mensaje, setMensaje] = useState('')
    const [error, setError] = useState('')

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value })
    }

    const handleSubmit = async (e) => {
        e.preventDefault()
        if (form.nombre === '' || form.nacionalidad === '' || form.generoMusical=== ''
            || form.anioDebut === '' || form.disquera === '' || form.albumsProducidos === '' || form.premiosGanados === '') {
            setError('Faltan campos obligatorios')
            return
        }
        setError('')
        const response = await fetch('http://localhost:8080/api/artistas', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({...form, enActivo})
        })
        if (response.ok) {
            setMensaje('Artista registrado correctamente')
        }
    }
    return (
        <div className="container mt-4">
            <h4 className="mt-4 text-center">Registrar Artista</h4>
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

                <div className="mb-3">
                    <label className="form-label">Género Musical:</label>
                    <input className="form-control" name="generoMusical"
                           value={form.generoMusical} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Año Debut:</label>
                    <input type="number" className="form-control" name="anioDebut"
                           value={form.anioDebut} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Disquera:</label>
                    <input className="form-control" name="disquera"
                           value={form.disquera} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Álbums Producidos:</label>
                    <input type="number" className="form-control" name="albumsProducidos"
                           value={form.albumsProducidos} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <label className="form-label">Premios Ganados:</label>
                    <input type="number" className="form-control" name="premiosGanados"
                           value={form.premiosGanados} onChange={handleChange} />
                </div>
                <div className="form-check">
                    <input
                        type="checkbox"
                        className="form-check-input"
                        checked={enActivo}
                        onChange={(e) => setEnActivo(e.target.checked)}
                    />
                    <label className="form-label" >
                        En Activo
                    </label>
                </div>
                {mensaje && <p className="text-success">{mensaje}</p>}
                {error && <p className="text-danger">{error}</p>}

                <button type="submit" className="btn btn-primary mt-5">Registrar</button>
            </form>
        </div>
    )
}
export default FormArtista;