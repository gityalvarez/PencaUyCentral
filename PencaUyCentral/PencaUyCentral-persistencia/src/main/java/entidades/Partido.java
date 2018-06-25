package entidades;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "Partidos" database table.
 *
 */
@Entity
@Table(name="\"Partidos\"")
@NamedQuery(name="Partido.findAll", query="SELECT p FROM Partido p")
public class Partido implements Serializable {

	private static final long serialVersionUID = 1L;
	public enum estados {NOJUGADO,JUGANDO,JUGADO};

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="\"Id\"")
	private Integer id;

	@Column(name="\"Estado\"")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="\"Fecha\"")
	private Date fecha;
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Column(name="\"Hora\"")
	private String hora;

	@Column(name="\"GolesEquipoLocal\"")
	private Integer golesEquipoLocal;

	@Column(name="\"GolesEquipoVisita\"")
	private Integer golesEquipoVisita;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="\"EquipoGanadorId\"")
	private Equipo equipoGanador;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="\"EquipoVisitaId\"")
	private Equipo equipoVisita;

	//bi-directional many-to-one association to Equipo
	@ManyToOne
	@JoinColumn(name="\"EqupoLocalId\"")
	private Equipo equipoLocal;

	//bi-directional many-to-one association to Grupo
	@ManyToOne
	@JoinColumn(name="\"GrupoId\"")
	private Grupo grupo;

	public Partido() {
		this.estado = "";
		this.fecha = null;
		this.golesEquipoLocal = -1;
		this.golesEquipoVisita = -1;
		this.equipoGanador = null;
		this.equipoVisita = null;
		this.equipoLocal = null;
		this.grupo = null;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getGolesEquipoLocal() {
		return this.golesEquipoLocal;
	}

	public void setGolesEquipoLocal(Integer golesEquipoLocal) {
		this.golesEquipoLocal = golesEquipoLocal;
	}

	public Integer getGolesEquipoVisita() {
		return this.golesEquipoVisita;
	}

	public void setGolesEquipoVisita(Integer golesEquipoVisita) {
		this.golesEquipoVisita = golesEquipoVisita;
	}

	public Equipo getEquipoGanador() {
		return this.equipoGanador;
	}

	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}

	public Equipo getEquipoVisitante() {
		return this.equipoVisita;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisita = equipoVisitante;
	}

	public Equipo getEquipLocal() {
		return this.equipoLocal;
	}

	public void setEquipLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}