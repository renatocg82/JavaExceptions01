package entities;

import model.exceptions.AgendaCheiaException;
import model.exceptions.ContatoNaoExisteException;

public class Agenda {
	
	protected Contato[] contatos;
	
	public Agenda() {
		contatos = new Contato[5];
	}
	
	
	public void adicionarContato(Contato c) throws AgendaCheiaException {
		
		boolean cheia = true;
		
		for (int i=0; i<contatos.length; i=i+1) {
			if (contatos[i] == null) {
				contatos[i] = c;
				cheia = false;
				break;
			}
		}
	
		if (cheia) {
			//lançar exception aqui;
			throw new AgendaCheiaException();			
		}
	}
	
	public int consultaContato (String name) throws ContatoNaoExisteException {
		
		for(int i=0 ; i < contatos.length ; i++) {
			if (contatos[i] != null) {
				if (contatos[i].getName().equalsIgnoreCase(name)) {
					return i;					
				}				
			}			
		}
		System.out.println();
		// throw the contact does not exist exception
		throw new ContatoNaoExisteException (name);
	}

	@Override
	
	public String toString() {
		String s = "";		
		for (Contato c : contatos) {
		if (c != null) {
			s = s + c.toString() + "\n";	
		}
	}
		return s;
	}
	
}
