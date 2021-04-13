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
		
		if(livello == N) {
			// caso terminale
			//System.out.println(parziale);
			this.soluzione = new ArrayList<>(parziale);
			
			return true;
		}
		else {
			for(int colonna = 0; colonna < N; colonna ++) {
				// if la mossa nella casella [livello] [colonna] è valida
				// se sì, aggiungi a parziale e fai ricorsione
				
				if(posValida(parziale, colonna)) {
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
		
		int livello = parziale.size();
		
		// controlla se colonna vuota 
		if(parziale.contains(colonna))
			return false;
		
		// controllo se diagonale libera 
		for(int r = 0; r<livello; r++) {
			int c = parziale.get(r);
			
			if(r+c == livello+colonna || r-c == livello-colonna)
				return false;
		}
		
		
		return true;
	}
}
