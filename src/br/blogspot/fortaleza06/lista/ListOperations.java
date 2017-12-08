package br.blogspot.fortaleza06.lista;

public interface ListOperations {

	public void add(Container e);
	public void add(int i, Container e);
	public default Container get(int i) {return null;};
	public void set(int i, Container e);
	public void remove(int i);
	public default boolean contains(int value) {return false;};
	public int size();
	
}
