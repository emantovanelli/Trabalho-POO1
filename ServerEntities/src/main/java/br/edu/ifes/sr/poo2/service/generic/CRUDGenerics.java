package br.edu.ifes.sr.poo2.service.generic;

import java.util.List;

import br.edu.ifes.sr.poo2.model.Model;

public interface CRUDGenerics <T extends Model> {

	public void save (T t);
	
	public void delete (long id);
	
	public T find(long id);
	
	public List<T>findAll ();
	
}
