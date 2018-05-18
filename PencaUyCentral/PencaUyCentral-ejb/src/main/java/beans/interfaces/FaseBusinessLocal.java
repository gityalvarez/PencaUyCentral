package beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import entidades.Fase;

@Local
public interface FaseBusinessLocal {
	public boolean agregarFase(String nombre,int torneoId);
    public Fase obtenerFase(int id);
    public boolean eliminarFase(int id);
    public List<Fase> obtenerFasesPorTorneo(int id);
    public Fase obtenerFasePorNombreYTorneo(int id,String nombre);
}
