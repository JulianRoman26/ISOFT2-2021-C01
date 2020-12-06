package Dominio;

import java.util.ArrayList;

public interface Carta {
	
	ArrayList<String> ingredientes = new ArrayList<String>();
	ArrayList<Integer> cantidadesIng = new ArrayList<Integer>();

	public static Plato getEntrantes(Plato p) {
	
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
		
		String nombre=p.getNombre();
		
		switch(nombre) {
		
		case "jamon":
			
			Ingrediente jamon=new Ingrediente("jamon",3);
			ingredientes.add(jamon);
			p.setIngredientes(ingredientes);
			
			break;
			
		case "queso":
			
			Ingrediente queso = new Ingrediente("queso", 5);
			ingredientes.add(queso);
			p.setIngredientes(ingredientes);
			
			break;
			
		case "bravas":
			
			Ingrediente patatas = new Ingrediente("patata",7);
			Ingrediente salsa=new Ingrediente("salsa_brava",2);
			ingredientes.add(patatas);
			ingredientes.add(salsa);
			p.setIngredientes(ingredientes);
			break;
			
		}
		
		return p;
		
	
	}
	
	public static Plato getPrimerPlato(Plato p) {
		
		
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
		
		String nombre=p.getNombre();
		
		switch(nombre) {
		
		case "ensalada":
			
			Ingrediente tomate=new Ingrediente("tomate",3);
			Ingrediente lechuga=new Ingrediente("lechuga",5);
			Ingrediente remolacha=new Ingrediente("remolacha",4);
			ingredientes.add(tomate);
			ingredientes.add(lechuga);
			ingredientes.add(remolacha);
			p.setIngredientes(ingredientes);
			
			
			break;
			
		case "crema_de_calabaza":
			
			Ingrediente calabaza = new Ingrediente("calabaza", 2);
			Ingrediente picatoste = new Ingrediente("picatoste",5);
			
			ingredientes.add(calabaza);
			ingredientes.add(picatoste);
			p.setIngredientes(ingredientes);
			
			break;
			
		case "sopa_de_cocido":
			
			Ingrediente fideos = new Ingrediente("fideos",2);
			Ingrediente huevo=new Ingrediente("huevo",4);
			ingredientes.add(fideos);
			ingredientes.add(huevo);
			p.setIngredientes(ingredientes);
			break;
			
		}
		return p;
	
	}
	
public static Plato getSegundoPlato(Plato p) {
		
		ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
		
		String nombre=p.getNombre();
		
		switch(nombre) {
		
		case "cordero":
			
			Ingrediente cordero=new Ingrediente("cordero",1);
			Ingrediente patata=new Ingrediente("patata",5);
			ingredientes.add(cordero);
			ingredientes.add(patata);
			p.setIngredientes(ingredientes);
			
			
			break;
			
		case "lubina":
			
			Ingrediente lubina = new Ingrediente("lubina", 1);			
			ingredientes.add(lubina);
			p.setIngredientes(ingredientes);
			
			break;
			
		case "macarrones":
			
			Ingrediente macarron = new Ingrediente("macarron",2);
			Ingrediente tomate=new Ingrediente("tomate",4);
			Ingrediente atun=new Ingrediente("atun",2);
			ingredientes.add(macarron);
			ingredientes.add(tomate);
			ingredientes.add(atun);
			p.setIngredientes(ingredientes);
			break;
			
		}
		return p;
	
	}

public static Plato getPostre(Plato p) {
	
	ArrayList<Ingrediente> ingredientes= new ArrayList<Ingrediente>();
	
	String nombre=p.getNombre();
	
	switch(nombre) {
	
	case "flan":
		
		Ingrediente huevo=new Ingrediente("huevo",2);
		Ingrediente nata=new Ingrediente("nata",2);
		ingredientes.add(huevo);
		ingredientes.add(nata);
		p.setIngredientes(ingredientes);
		
		
		break;
		
	case "tarta_de_queso":
		
		Ingrediente bizcocho = new Ingrediente("bizcocho", 2);
		Ingrediente queso = new Ingrediente("queso",1);
		ingredientes.add(bizcocho);
		ingredientes.add(queso);
		p.setIngredientes(ingredientes);
		
		break;
		

		
	}
	return p;

}
	
}
