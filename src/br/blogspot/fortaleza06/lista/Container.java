package br.blogspot.fortaleza06.lista;

public class Container {

	private int value;		 // valor a ser armazenado
	private Container next;	 // próximo Container, por padrão null
	
	public Container(int value) {
		this.value = value;
		this.next = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Container getNext() {
		return next;
	}

	public void setNext(Container next) {
		this.next = next;
	}
	
}
