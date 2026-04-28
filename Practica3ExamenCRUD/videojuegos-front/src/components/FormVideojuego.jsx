import { useState } from "react";

function FormVideojuego() {
    // Estado inicial del formulario extraído para reutilizarlo al limpiar
    const estadoInicialForm = {
        titulo: '',
        genero: '',
        plataforma: '',
        anioLanzamiento: '',
        estudio: '',
        duracionHoras: '',
        jugadoresMaximos: '',
        idioma: ''
    };

    const [form, setForm] = useState(estadoInicialForm);
    const [videojuegos, setVideojuegos] = useState([]);
    const [mensaje, setMensaje] = useState('');
    const [error, setError] = useState('');

    // Nuevo estado para saber qué ID estamos editando (null significa que estamos creando uno nuevo)
    const [editandoId, setEditandoId] = useState(null);

    const listar = async () => {
        const response = await fetch('http://localhost:8080/api/videojuegos');
        const data = await response.json();
        setVideojuegos(data);
    };

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Validación
        if (form.titulo === '' || form.genero === '' || form.plataforma === ''
            || form.anioLanzamiento === '' || form.estudio === '' || form.duracionHoras === ''
            || form.jugadoresMaximos === '' || form.idioma === '') {
            setError('Faltan campos obligatorios');
            return;
        }
        setError('');

        if (editandoId) {
            // Lógica para ACTUALIZAR (PUT)
            const response = await fetch(`http://localhost:8080/api/videojuegos/${editandoId}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(form)
            });

            if (response.ok) {
                setMensaje('Videojuego actualizado correctamente');
            }
        } else {
            // Lógica para REGISTRAR (POST)
            const response = await fetch('http://localhost:8080/api/videojuegos', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(form)
            });

            if (response.ok) {
                setMensaje('Videojuego registrado correctamente');
            }
        }

        // Limpiamos el formulario y actualizamos la tabla después de guardar
        limpiarFormulario();
        listar();
    };

    // Nueva función para ELIMINAR
    const eliminar = async (id) => {
        const response = await fetch(`http://localhost:8080/api/videojuegos/${id}`, {
            method: 'DELETE'
        });
        if (response.ok) {
            setMensaje('Videojuego eliminado');
            listar();
        }
    };

    // Nueva función para cargar los datos en el form antes de EDITAR
    const cargarParaEditar = (videojuego) => {
        setEditandoId(videojuego.id);
        setForm({
            titulo: videojuego.titulo,
            genero: videojuego.genero,
            plataforma: videojuego.plataforma,
            anioLanzamiento: videojuego.anioLanzamiento,
            estudio: videojuego.estudio,
            duracionHoras: videojuego.duracionHoras,
            jugadoresMaximos: videojuego.jugadoresMaximos,
            idioma: videojuego.idioma
        });
        setMensaje('');
        setError('');
    };

    const limpiarFormulario = () => {
        setForm(estadoInicialForm);
        setEditandoId(null);
    };

    const handleReset = (e) => {
        e.preventDefault();
        limpiarFormulario();
        setMensaje('');
        setError('');
        setVideojuegos([]);
    };

    return (
        <div className="container mt-4">
            <h4 className="mt-4 text-center">
                {editandoId ? 'Editar Videojuego' : 'Registrar Videojuego'}
            </h4>

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
                    <button type="submit" className={editandoId ? "btn btn-warning mt-5" : "btn btn-primary mt-5"}>
                        {editandoId ? 'Actualizar' : 'Registrar'}
                    </button>
                    <button type="button" className="btn btn-secondary mt-5 ms-3" onClick={limpiarFormulario}>
                        Cancelar / Limpiar
                    </button>
                    <button type="button" className="btn btn-info mt-5 ms-3" onClick={listar}>
                        Listar Todos
                    </button>
                    {/* El botón reset original lo he modificado a tipo 'button' para manejarlo manualmente con limpiarFormulario */}
                </div>
            </form>

            <table className="table text-center mt-5">
                <thead className="table-dark">
                <tr>
                    <th>Titulo</th>
                    <th>Genero</th>
                    <th>Plataforma</th>
                    <th>Año de lanzamiento</th>
                    <th>Acciones</th> {/* Nueva columna para botones */}
                </tr>
                </thead>
                <tbody>
                {videojuegos.map(e => (
                    <tr key={e.id}>
                        <td>{e.titulo}</td>
                        <td>{e.genero}</td>
                        <td>{e.plataforma}</td>
                        <td>{e.anioLanzamiento}</td>
                        <td>
                            <button
                                className="btn btn-warning btn-sm me-2"
                                onClick={() => cargarParaEditar(e)}
                            >
                                Editar
                            </button>
                            <button
                                className="btn btn-danger btn-sm"
                                onClick={() => eliminar(e.id)}
                            >
                                Eliminar
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default FormVideojuego;