package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Pencas" database table.
 * 
 */
@Entity
@Table(name="\"Pencas\"")
@NamedQuery(name="Penca.findAll", query="SELECT p FROM Penca p")
public class Penca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="\"Id\"")
	private Integer id;

	//bi-directional many-to-one association to Participante
	@OneToMany(mappedBy="penca")
	private List<Participante> participantes;

	//bi-directional many-to-one association to Organizacione
	@ManyToOne
	@JoinColumn(name="\"OrganizacionId\"")
	private Organizacione organizacion;

	public Penca() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Participante> getParticipantes() {
		return this.participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public Participante addParticipante(Participante participante) {
		getParticipantes().add(participante);
		participante.setPenca(this);

		return participante;
	}

	public Participante removeParticipante(Participante participante) {
		getParticipantes().remove(participante);
		participante.setPenca(null);

		return participante;
	}

	public Organizacione getOrganizacion() {
		return this.organizacion;
	}

	public void setOrganizacion(Organizacione organizacion) {
		this.organizacion = organizacion;
	}

}