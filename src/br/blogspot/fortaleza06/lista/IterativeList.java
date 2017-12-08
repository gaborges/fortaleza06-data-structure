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
		// itera até o último elemento da lista encadeada
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
		// itera até encontrar o elemento i passado pro parâmetro - implementação com while
		Container currentElement = root;
		int currentIndex = 0;
		while(currentElement.getNext() != null) {
			if((currentIndex+1) == i) {
				e.setNext(currentElement.getNext()); // adiciona o próximo Contailer elemento atual para o sendo adicionado
				currentElement.setNext(e); 	// adiciona o novo Container como próximo no elemento atual
				return;	 					// termina a execução do método
			}
			currentElement = currentElement.getNext();
			currentIndex++; 				// após cada next incrementa, pois o vetor começa em 0
		}
		/*
		// itera até encontrar o elemento i passado pro parâmetro - implementação com for
		// implementação necessita do tamanho do vetor de forma prévia
		for(currentIndex = 0; currentIndex < this.lenght; currentIndex++) {
			if(currentIndex == i) {
				e.setNext(currentElement.getNext()); // adiciona o próximo Contailer do elemento atual para o sendo adicionado
				currentElement.setNext(e); 	// adiciona o novo Container como próximo no elemento atual
				return;	 					// termina a execução do método
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
		// para substituir um elemento é necessário a referência do anterior
		// então vamos comparar com o indice do próximo
		while(currentElement.getNext() != null) {
			if((currentIndex+1) == i) {
				e.setNext(currentElement.getNext().getNext()); // adiciona o próximo Contailer dois íncides do elemento atual
				currentElement.setNext(e); 	// adiciona o novo Container como próximo no elemento atual
				return;	 					// termina a execução do método
			}
			currentElement = currentElement.getNext();
			currentIndex++; 				// após cada next incrementa, pois o vetor começa em 0 
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
		// para substituir um elemento é necessário a referência do anterior
		// então vamos comparar com o indice do próximo
		while(currentElement.getNext() != null) {
			if((currentIndex+1) == i) {
				// adiciona o próximo Contailer dois indices de distância do atual como próximo do elemento atual
				// desta forma, o próximo elemento fica sem referência e é excluído
				currentElement.setNext(currentElement.getNext().getNext());
				lenght--;
				return;	 					// termina a execução do método
			}
			currentElement = currentElement.getNext();
			currentIndex++; 				// após cada next incrementa, pois o vetor começa em 0 
		}
	}
	
	@Override
	public Container get(int i) {
		Container currentElement = root;
		int currentIndex = 0;
		// iterar até encontrar o indice buscado
		while(currentElement != null) {
			if(currentIndex == i) {
				return currentElement;	// retorna o elemento encontrado
			}
			currentElement = currentElement.getNext();
			currentIndex++; 			// após cada next incrementa, pois o vetor começa em 0 
		}
		return null; // retorna null se não encontrado;
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
		return false; // retorna false se não encontrado;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lenght;
	}
	
	private int count() {
		this.lenght = 0;
		// itera até o último elemento da lista encadeada
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
