package br.blogspot.fortaleza06.lista;

public class RecursiveList implements ListOperations {

	private Container root;
	private int lenght;
	
	public RecursiveList() {
		this.root = null;
		this.lenght = 0;
	}
	
	public RecursiveList(Container root) {
		this.root = root;
		this.count();
	}
	
	@Override
	public void add(Container e) {
		if(root == null) {
			root = e;
			return;
		}
		// percorre recursivamente toda a lista encadeara até o último elemento
		add(e,root);
	}
	
	private void add(Container e, Container currentElement){
		if(currentElement.getNext() == null) { 	// caso base
			currentElement.setNext(e);
			this.lenght++;
		} else {
			add(e,currentElement.getNext()); 	// chamada recursiva
		}
	}

	@Override
	public void add(int i, Container e) {
		if(i==0) { // se indice for root
			e.setNext(root); // adiciona o próximo Container elemento atual para o sendo adicionado
			root = e; 		 // adiciona o novo Container como raiz
			return;
		}
		add(e,i,0,root);
	}
	
	private void add(Container e, int i,int currentIndex,Container currentElement){
		if(i == (currentIndex+1)) { 	 // caso base
			e.setNext(currentElement.getNext()); // adiciona o próximo Container elemento atual para o sendo adicionado
			currentElement.setNext(e); 			 // adiciona o novo Container como próximo no elemento atual
			this.lenght++;
		} else {						 // chamada recursiva		
			add(e,i,currentIndex++,currentElement.getNext());
		}
	}

	@Override
	public void set(int i, Container e) {
		// se i for root
		if(i==0){
			e.setNext(root.getNext());
			root = e;
			return;
		}
		set(e,i,0,root);	
	}
	
	private void set(Container e, int i,int currentIndex,Container currentElement){
		if(i == (currentIndex+1)) { 	 // caso base
			e.setNext(currentElement.getNext() 
					.getNext()); 				 // adiciona o próximo Contailer dois íncides do elemento atual
			currentElement.setNext(e); 			 // adiciona o novo Container como próximo no elemento atual
		} else {						 // chamada recursiva		
			currentIndex=currentIndex+1;
			set(e,i,currentIndex,currentElement.getNext());
		}
	}


	@Override
	public void remove(int i) {
		// se i for root
		if(i==0){
			root = root.getNext();
			lenght--;
			return;
		}
		remove(i, 0, root);
	}
	
	private void remove(int i,int currentIndex,Container currentElement){
		if(i == (currentIndex+1)) { 	 // caso base
			// adiciona o próximo Contailer dois indices de distância do atual como próximo do elemento atual
			// desta forma, o próximo elemento fica sem referência e é excluído
			currentElement.setNext(currentElement.getNext().getNext());
			lenght--;
		} else {						 // chamada recursiva
			currentIndex=currentIndex+1;
			remove(i,currentIndex,currentElement.getNext());
		}
	}
	
	
	@Override
	public Container get(int i) {
		return get(i,root);
	}
	
	private Container get(int i, Container currentElement){
		if(i == 0) {
			return currentElement;
		} else {
			i = i-1;
			return get(i,currentElement.getNext());
		}
	}

	@Override
	public boolean contains(int value) {
		return contains(value,root);
	}
	
	private boolean contains(int value, Container currentElement){
		if(value == currentElement.getValue()) { 		// caso base 1
			return true;
		} else if(currentElement.getNext() == null) {	// caso base 2
			return false;
		} else {										// chamada recursiva
			return contains(value,currentElement.getNext());
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lenght;
	}
	
	private int count() {
		this.lenght = 0;
		return count(root);
	}
	
	private int count(Container currentElement) {
		if(currentElement == null) {
			return this.lenght;
		} else {
			this.lenght++;
			return count(currentElement.getNext());
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[index-value-next");
		Container currentElement = root;
		int currentIndex = 0;
		// iterar até encontrar o indice buscado
		while(currentElement != null) {
			sb.append("\n   "+currentIndex+"  - "+currentElement.getValue()+"  -  "+currentElement.getNext());
			if(currentElement.getNext()!=null) {
				sb.append(",");
			}
			currentElement = currentElement.getNext();
			currentIndex++; 			// após cada next incrementa, pois o vetor começa em 0 
		}
		sb.append("]");
		return sb.toString();
	}
}