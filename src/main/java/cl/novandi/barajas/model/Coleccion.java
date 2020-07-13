package cl.novandi.barajas.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "coleccion")
public class Coleccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_tipo_coleccion", nullable = false, foreignKey = @ForeignKey(name="FK_coleccion_tipo_coleccion"))
	private TipoColeccion tipoColeccion;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name="FK_coleccion_usuario"))
	private Usuario usuario;
	
	@Size(min = 3, message = "El nombre de la coleccion debe tener minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "coleccion_baraja"
			, joinColumns = @JoinColumn(name="id_coleccion", referencedColumnName = "id")
			, inverseJoinColumns = @JoinColumn(name="id_baraja", referencedColumnName = "id"))
	private List<Baraja> barajas;

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoColeccion getTipoColeccion() {
		return tipoColeccion;
	}

	public void setTipoColeccion(TipoColeccion tipoColeccion) {
		this.tipoColeccion = tipoColeccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Baraja> getBarajas() {
		return barajas;
	}

	public void setBarajas(List<Baraja> barajas) {
		this.barajas = barajas;
	}
	
	
		
	
}
