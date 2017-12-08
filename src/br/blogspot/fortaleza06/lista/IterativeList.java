package br.blogspot.fortaleza06.lista;

public class IterativeList implements ListOperations {

	private Container root;
	private int lenght;
	
	public IterativeList() {
		this.root = null;
		this.lenght = 0;
	}
	
	public IterativeList(Container root) {
		this.root = root;
		this.count();
	}
	
	@Override
	public void add(Container e) {
		if(root == null) {
			root = e;
			return;
		}
		// itera at� o �ltimo elemento da lista encadeada
		Container currentElement = root;
		while(currentElement.getNext() != null) {
			currentElement = currentElement.getNext();
		}
		currentElement.setNext(e);
		this.lenght++;
	}

	@Override
	public void add(int i, Container e) {
		if(i == 0) {
			e.setNext(root);
			root = e;
			return;
		}
		// itera at� encontrar o elemento i passado pro par�metro - implementa��o com while
		Container currentElement = root;
		int currentIndex = 0;
		while(currentElement.getNext() != null) {
			if((currentIndex+1) == i) {
				e.setNext(currentElement.getNext()); // adiciona o pr�ximo Contailer elemento atual para o sendo adicionado
				currentElement.setNext(e); 	// adiciona o novo Container como pr�ximo no elemento atual
				return;	 					// termina a execu��o do m�todo
			}
			currentElement = currentElement.getNext();
			currentIndex++; 				// ap�s cada next incrementa, pois o vetor come�a em 0
		}
		/*
		// itera at� encontrar o elemento i passado pro par�metro - implementa��o com for
		// implementa��o necessita do tamanho do vetor de forma pr�via
		for(currentIndex = 0; currentIndex < this.lenght; currentIndex++) {
			if(currentIndex == i) {
				e.setNext(currentElement.getNext()); // adiciona o pr�ximo Contailer do elemento atual para o sendo adicionado
				currentElement.setNext(e); 	// adiciona o novo Container como pr�ximo no elemento atual
				return;	 					// termina a execu��o do m�todo
			}
		}
		*/
	}

	@Override
	public void set(int i, Container e) {
		// se i for root
		if(i==0){
			e.setNext(root.getNext());
			root = e;
			return;
		}
		Container currentElement = root;
		int currentIndex = 0;
		// para substituir um elemento � necess�rio a refer�ncia do anterior
		// ent�o vamos comparar com o indice do pr�ximo
		while(currentElement.getNext() != null) {
			if((currentIndex+1) == i) {
				e.setNext(currentElement.getNext().getNext()); // adiciona o pr�ximo Contailer dois �ncides do elemento atual
				currentElement.setNext(e); 	// adiciona o novo Container como pr�ximo no elemento atual
				return;	 					// termina a execu��o do m�todo
			}
			currentElement = currentElement.getNext();
			currentIndex++; 				// ap�s cada next incrementa, pois o vetor come�a em 0 
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
		Container currentElement = root;
		int currentIndex = 0;
		// para substituir um elemento � necess�rio a refer�ncia do anterior
		// ent�o vamos comparar com o indice do pr�ximo
		while(currentElement.getNext() != null) {
			if((currentIndex+1) == i) {
				// adiciona o pr�ximo Contailer dois indices de dist�ncia do atual como pr�ximo do elemento atual
				// desta forma, o pr�ximo elemento fica sem refer�ncia e � exclu�do
				currentElement.setNext(currentElement.getNext().getNext());
				lenght--;
				return;	 					// termina a execu��o do m�todo
			}
			currentElement = currentElement.getNext();
			currentIndex++; 				// ap�s cada next incrementa, pois o vetor come�a em 0 
		}
	}
	
	@Override
	public Container get(int i) {
		Container currentElement = root;
		int currentIndex = 0;
		// iterar at� encontrar o indice buscado
		while(currentElement != null) {
			if(currentIndex == i) {
				return currentElement;	// retorna o elemento encontrado
			}
			currentElement = currentElement.getNext();
			currentIndex++; 			// ap�s cada next incrementa, pois o vetor come�a em 0 
		}
		return null; // retorna null se n�o encontrado;
	}

	@Override
	public boolean contains(int value) {
		Container currentElement = root;
		// itera procurando o valor procurado
		while(currentElement != null) {
			if(currentElement.getValue() == value) {
				return true;	// retorna o elemento encontrado
			}
			currentElement = currentElement.getNext();
		}
		return false; // retorna false se n�o encontrado;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lenght;
	}
	
	private int count() {
		this.lenght = 0;
		// itera at� o �ltimo elemento da lista encadeada
		Container temp = root;
		while(temp != null) {
			temp = temp.getNext();
			this.lenght++;
		}
		return lenght;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[index-value-next");
		Container currentElement = root;
		int currentIndex = 0;
		// iterar at� encontrar o indice buscado
		while(currentElement != null) {
			sb.append("\n   "+currentIndex+"  - "+currentElement.getValue()+"  -  "+currentElement.getNext());
			if(currentElement.getNext()!=null) {
				sb.append(",");
			}
			currentElement = currentElement.getNext();
			currentIndex++; 			// ap�s cada next incrementa, pois o vetor come�a em 0 
		}
		sb.append("]");
		return sb.toString();
	}
	
}
