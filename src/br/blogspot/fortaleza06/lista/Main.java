package br.blogspot.fortaleza06.lista;


public class Main {

	public static void main(String args[]) {
		
		// declarar o conjunto de dados - C = {35, 10, 14, 22}
		Container a = new Container(35);
		Container b = new Container(10);
		Container c = new Container(14);
		Container d = new Container(22);
		
		// montar conjunto apontando para o pr�ximo nodo
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(null); // �ltimo elemento da lista recebe null
		
		//iterativeImplementantion();	
		recursiveImplementantion();
	}
	
	public static void iterativeImplementantion() {
		// declarar o conjunto de dados - C = {35, 10, 14, 22}
		IterativeList list = new IterativeList();
		list.add(new Container(35)); // elemento raiz
		list.add(new Container(10));
		list.add(new Container(14));
		list.add(new Container(22));
		
		System.out.println("---Lista inicial---");
		System.out.println(list.toString());
		
		System.out.println("\n---Remover indice 2---");
		list.remove(2);
		System.out.println(list.toString());
		
		System.out.println("\n---Adicionar valor 14 no �ndice 1---");
		list.add(1, new Container(14));
		System.out.println(list.toString());
		
		System.out.println("\n---Substituir Container no �ndice 2 por outro com para 66---");
		list.set(2, new Container(66));
		System.out.println(list.toString());
		
		System.out.println("\n---Verificar se valores 14 e 10 est�o contidos---");
		System.out.println(list.contains(14)+" "+list.contains(10));
		
		System.out.println("\n---Retornar elemento no indice 3---");
		System.out.println(list.get(3).getValue());
	}
	
	public static void recursiveImplementantion() {
		// declarar o conjunto de dados - C = {35, 10, 14, 22}
		RecursiveList list = new RecursiveList();
		list.add(new Container(35)); // elemento raiz
		list.add(new Container(10));
		list.add(new Container(14));
		list.add(new Container(22));
		
		System.out.println("---Lista inicial---");
		System.out.println(list.toString());
		
		System.out.println("\n---Remover indice 2---");
		list.remove(2);
		System.out.println(list.toString());
		
		System.out.println("\n---Adicionar valor 14 no �ndice 1---");
		list.add(1, new Container(14));
		System.out.println(list.toString());
		
		System.out.println("\n---Substituir Container no �ndice 2 por outro com para 66---");
		list.set(2, new Container(66));
		System.out.println(list.toString());
		
		System.out.println("\n---Verificar se valores 14 e 10 est�o contidos---");
		System.out.println(list.contains(14)+" "+list.contains(10));
		
		System.out.println("\n---Retornar elemento no indice 3---");
		System.out.println(list.get(3).getValue());
		
	}
	
	
}
