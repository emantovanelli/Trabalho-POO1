package br.edu.ifes.sr.poo2.api.generic;

import java.util.List;

public interface API <T> {

	public boolean isWorking();
	
	public int adicionar(T t) throws Exception;
	
	public T get (int i) throws Exception;
	
	public List<T> getAll() throws Exception;
}
