package cl.novandi.barajas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "valoracion")
@IdClass(ValoracionPK.class)
public class Valoracion {

	@Id
	private Usuario usuario;
	
	@Id
	private Baraja baraja;
	
	
	@Column(name = "valor", nullable = false)
	private Integer valor;
	
	private LocalDateTime fecha;
	
	@Size(max = 3, message = "El comentario debe tener maximo 250 caracteres")
	@Column(name = "comentario", nullable = true, length = 250)
	private String comentario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Baraja getBaraja() {
		return baraja;
	}

	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
}
