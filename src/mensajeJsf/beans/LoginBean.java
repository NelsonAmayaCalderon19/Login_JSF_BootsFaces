package mensajeJsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Query;

import primerjpa.dao.UsuarioDao;
import primerjpa.entities.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private Usuario usuario;
	
	public LoginBean(){
		this.usuario = new Usuario();
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String login(){
		UsuarioDao uDao = new UsuarioDao();
		Query q = uDao.getEm().createQuery("select u from Usuario u where u.usuario = ?1");
		q.setParameter(1, this.usuario.getUsuario());
		Usuario u = (Usuario) q.getSingleResult();
		//Usuario u = uDao.findByFieldObject(Usuario.class, "usuario", usuario.getUsuario());
		//Usuario u = uDao.find(this.usuario.getUsuario());
		//System.out.println(usuario.getEmail()+ " - " +usuario.getNombre());
		if(u!=null){
	if(u.getClave().contentEquals(this.usuario.getClave())){
			return "home";
	}else{
		return "error";	
	}}else{
			return "error";
		}
	}
}
