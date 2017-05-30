package factory;

import java.util.ArrayList;

public interface DAOfactory {
	public void insert(Object object);
	public void update(Object object);
	public void delete(Long id);
	public Object findById(Long id);
	public ArrayList<Object> findAll();
	
}
