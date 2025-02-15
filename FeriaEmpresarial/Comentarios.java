public class Comentarios {

	private Visitantes visitanteComentario;

	private Stands standComentario;

	private Date fechaVisita;

	private int calificacion;

	private String textoComentario;

	public Comentarios (Visitantes visitanteComentarios, Stands standComentario, Date fechaVisita, int calificacion, String textoComentario) {
		this.visitanteComentario = visitanteComentarios;
		this. standComentario = standComentario;
		this.fechaVisita = fechaVisita;
		this.calificacion = calificacion;
		this.textoComentario = textoComentario;
	}

	public void DejarComentarios() {

	}

	public void ConsultarComentarios() {

	}

}
