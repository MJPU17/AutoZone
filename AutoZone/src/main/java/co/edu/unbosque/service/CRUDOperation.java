package co.edu.unbosque.service;

import java.util.List;

public interface CRUDOperation<T> {
	
	public void create(T data);
	
	public List<T> getAll();
	
	public void deleteById(Long id);
	
	public boolean exist(Long id);

}
