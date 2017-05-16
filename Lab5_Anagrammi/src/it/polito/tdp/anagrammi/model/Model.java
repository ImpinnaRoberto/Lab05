package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.TreeMap;


public class Model {
	String momentaneo="";
	String pr;
	public Model() {
		
	}

	public TreeMap<String, Integer> cercaDoppie(char [] vett){
		TreeMap<String, Integer> doppie= new TreeMap<String, Integer>();		
		int cont=0;
		for(int l=0; l<vett.length; l++){
			for(int k=0; k<vett.length; k++){
				if(vett[l]==( vett[k])){
					//System.out.println("Sono unguali "+vett[l]+" e "+vett[k]);
					cont++;
					doppie.put(""+vett[l], cont);
					
				}
			}
			
			cont=0;
		}
		return doppie;
	}
	
	public LinkedList<String> calcola(String parola){
		char [] vett =parola.toCharArray();
		//System.out.println("INIZIALEMNTE PER é "+vett[0]+vett[1]+vett[2]+vett[3]);
		
		TreeMap<String, Integer> doppie1= cercaDoppie(vett);		

		//System.out.println("Le doppie sono "+doppie1.toString());
		int partenza=parola.length()-1;
		int livello=0;
		
		boolean flag=false;
		
		LinkedList<String> lista= new LinkedList<String>();
		while(partenza>=0){
		permuta(vett, livello, partenza, lista, parola, flag, doppie1);
		//System.out.println("QQQQQQQQQQQQQQQQQQ");
		partenza-=2;
		livello+=2;
		}
		return lista;
	}
	
	
	public void permuta(char [] vet, int livello, int partenza, LinkedList<String> lista, String parola, boolean flag, TreeMap<String, Integer> doppie1){
		if(partenza>=0){
			
			for(int i=0; i<parola.length(); i++){
				
				vet[partenza]=parola.charAt(i);
				
				//AGGIUNGO
				String s="";
					for(int j=0; j<vet.length; j++){
						s=s+vet[j];
					}
					
					
					
					boolean flag2=false;
					if(!lista.contains(s)){
						TreeMap<String, Integer> doppie= cercaDoppie(vet);		
						for(int f=0; f<vet.length; f++)
						{
							if(doppie.get(""+vet[f])!=doppie1.get(""+vet[f])){
								//System.out.println(vet[f]+" "+doppie.get(""+vet[f])+" "+doppie1.get(""+vet[f]));
								flag2=true;
							
							}else{
								//System.out.println("SONO UGUALI"+vet[f]+" "+doppie.get(""+vet[f])+" "+doppie1.get(""+vet[f]));

							}
							
						}
						if(flag2==false){
							//System.out.println(s);
							lista.add(s);
							
						}else{
							flag2=false;
						}
						
					}
				
				
				if(livello>0){
					partenza++;
					livello--;
					permuta(vet, livello, partenza, lista, parola, flag, doppie1);
					partenza--;
					livello++;
					
				}
				
			}
			
			
		}
		if(flag==false){
		flag=true;
		partenza--;
		livello++;
		permuta(vet, livello, partenza, lista, parola, flag, doppie1);
		}else{
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	public void calcolaPermutazioni(String parola, LinkedList<String> elenco, String momentaneo, int livello){
		char [] vett =parola.toCharArray();
		for (char c : vett) {
			String p;
			momentaneo=momentaneo+c;
			System.out.println(momentaneo);
			if(parola.length()>1){
				p=parola.substring(1, parola.length());
				System.out.println("Rimasta parola "+p);
				calcolaPermutazioni(p, elenco, momentaneo, livello+1);
				String f=momentaneo.substring(0,  momentaneo.length()-1);
				momentaneo=f;
				
			}else{
				System.out.println("SONO QUI");
				elenco.add(momentaneo);	
			}
		}
		parola=pr;
	}
	

	
	public LinkedList<String> calcola(String parola){
		LinkedList<String> elenco= new LinkedList<String>();
		int lunghezza=parola.length();
		int livello=0;
		pr=parola;
		calcolaPermutazioni(parola, elenco, momentaneo, livello);
		return elenco;
		}
		*/
	}

