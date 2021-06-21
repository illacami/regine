package it.polito.it.regine.model;

import java.util.ArrayList;
import java.util.List;

public class Regine {

	
	/**
	 * 	N è il numero di righe e colonne della scacchiera
	 *        (righe e colonne numerate da 0 a N-1
	 *  ad ogni livello posizino una regina in una nuova riga
	 *  
	 *  soluzione parziale: lista delle colonne in cui mettere le regine (prime righe) 
	 *  List<Integer>
	 *  livello: quante righe sono già piene
	 *  livello = 0 -> nessuna riga piena (devo mettere la regina nella riga 0)
	 *  livello = 3 -> righe piene (0, 1, 2)
	 *  [0] 
	 *        [0,2]
	 *                  [0, 2, 1]
	 */
	
	private int N;
	private List<Integer> soluzione;
	
	public List<Integer> risolvi(int N){
		
		this.N = N;
		
		List<Integer> parziale = new ArrayList<Integer>();
		this.soluzione = null;
		
		cerca(parziale, 0);
		
		return this.soluzione;
		
		
	}
	
	private boolean cerca (List<Integer> parziale, int livello) {
	
		// caso terminale
		if(livello == N) {
			this.soluzione = new ArrayList<Integer>(parziale);
			
			return true;
		}
		
		else {
			// if la mossa nella casella [livello] [colonna] è valida
			// se sì, aggiungi a parziale e fai ricorsione
		
			for(int colonna = 0; colonna < N; colonna++) {
			
				if(this.posValida(parziale, colonna)) {
					parziale.add(colonna);
					
					boolean trovato = cerca(parziale, livello+1);
					
					if(trovato)
						return true;
					
					parziale.remove(parziale.size()-1);
				}
			}
			
			return false;
		}		
	
	}

	private boolean posValida(List<Integer> parziale, int colonna) {
		
		// controlla se colonna vuota 
			if(parziale.contains(colonna))
				return false;
		
		// controllo se diagonale libera 
		// due elementi sulla stessa diagonale hanno (colonna-riga) uguale 
		
		int r = 0;
		
		for(Integer c: parziale) {
				if( (r+c) == parziale.size()+colonna || r-c == parziale.size()-colonna)
					return false;
			r++;
		}
		
		return true;
			
	}
}
