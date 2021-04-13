package it.polito.it.regine.model;

import java.util.List;

public class TestRegine {

	public static void main(String args[]) {
		Regine r = new Regine() ;
		
		List<Integer> soluzioni ;
		soluzioni = r.risolvi(6);
		System.out.println(soluzioni) ;

	}
}
