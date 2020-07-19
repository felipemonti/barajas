package cl.novandi.barajas.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 3, message = "El nombre del usuario debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 250)
	private String nombre;

	@Column(name = "password", nullable = false, length = 50)
	private String password;
	
	@Email
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_perfil", nullable = false, foreignKey = @ForeignKey(name="FK_usuario_perfil"))
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false, foreignKey = @ForeignKey(name="FK_usuario_estado"))
	private Estado estado;

	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_coleccion"
			, joinColumns = @JoinColumn(name="id_usuario", referencedColumnName = "id")
			, inverseJoinColumns = @JoinColumn(name="id_coleccion", referencedColumnName = "id"))
	*/
	@OneToMany(mappedBy = "usuario", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Coleccion> colecciones;

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	


	public List<Coleccion> getColecciones() {
		return colecciones;
	}


	public void setColecciones(List<Coleccion> colecciones) {
		this.colecciones = colecciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
}
