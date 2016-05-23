import java.util.List;

class Chomsky{

private List<Character> nTa;
private List<Character> T;
private nTerminal inicial;

	public Chomsky(List<Character> nTerminais, List<Character> terminais){
		nTa = nTerminais;
		T = terminais;
		inicial = null;
	}

	class nTerminal{

		
		nTerminal prox;		
		Derivacoes inicial;
		char nT;
		

		public nTerminal(char s){
			nT = s;
			inicial = null;
			prox = null;
		}
		
		class Derivacoes{
			Derivacoes prox;
			String producao;

			public Derivacoes(String s){
				prox = null;
				producao = s;
				
			}
			
			public void analisa(nTerminal n){

				int cont = 0;
				List<Character> aux= new List<Character>();
				String aux2="";
				boolean b;
				for(int i = 0; i < producao.length() ; i++){
					b = nTa.contains(new Character(producao.charAt(i)));
					if(b) {cont++; aux.add(new Character(producao.charAt(i)));} else aux2+=producao.charAt(i);
				}
				switch(b) {
					case 0: break;
					case 1: umNT(aux, n, aux2); REMOVE this; break;
					case 2: break;
					case default: muNT(aux, n, aux2);  REMOVE this; break;
				}
			}
			
		}

		public void adicionaD(String s){
			Derivacoes d = new Derivacoes(s);
			
			Derivacoes aux = inicial;

			if(inicial == null) {inicial = d; return;}
			
			while(aux.prox != null) aux = aux.prox;
			
			aux.prox = d;	
		}

		
		public void umNT(List<Character> l, nTerminal n, String resto) {
			
			for(Character aux:l) {
				nTerminal jose = procura(aux.charValue());
				if(jose==null) {System.out.println("DEU MERDA VIADO - 1"); return;}
				Derivacoes auxiliarDeJose = jose.inicial;
				while(auxiliarDeJose!=null) {
					n.adicionaD(auxiliarDeJose.producao+resto);
					REMOVE NODO;
				}
				REMOVE NODO;
			}
		}
		
		public void mumNT(List<Character> l, nTerminal n, String resto) {
			
			for(Character aux:l) {
				nTerminal jose = procura(aux.charValue());
				if(jose==null) {System.out.println("DEU MERDA VIADO - 1"); return;}
				Derivacoes auxiliarDeJose = jose.inicial;
				while(auxiliarDeJose!=null) {
					n.adicionaD(auxiliarDeJose.producao+resto);
					REMOVE NODO;
				}
				REMOVE NODO;
			}
		}			

	}

	

	public nTerminal procura(char c){
		nTerminal aux = inicial;
		
		while(aux != null){
			
			if(c == aux.nT) return aux;
			
			aux = aux.prox;
		}
		
		return null;
	}

	public void adicionaN(char c){
		nTerminal n = new nTerminal(c);

		nTerminal aux = inicial;

		if(inicial == null) {inicial = n; return;}
	
		while(aux.prox != null)aux = aux.prox;
			
	        aux.prox = n;	
	}

	

}