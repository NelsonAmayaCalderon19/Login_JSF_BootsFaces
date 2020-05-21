package mensajeJsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import primerjpa.dao.MensajeDao;
import primerjpa.entities.Mensaje;
import primerjpa.entities.Usuario;

@ManagedBean
@SessionScoped
public class MensajeBean {
	MensajeDao mdao = new MensajeDao();
	
	List<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	public List<Mensaje> getMensajes(){
		return mdao.list();
	}

	
	
}
