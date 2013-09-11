package nosso.br.edu.ifes.sr.poo2.service.generic;

import java.util.List;

import nosso.br.edu.ifes.sr.poo2.model.ModelBanco;

public interface CRUDGenerics <T extends ModelBanco> {

	public void save (T t);
	
	public void delete (long id);
	
	public T find(long id);
	
	public List<T>findAll ();
	
}
