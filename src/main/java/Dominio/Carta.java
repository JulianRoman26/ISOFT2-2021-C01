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
			
		case "nachos":
			
			Ingrediente nachos = new Ingrediente("nacho",7);
			Ingrediente guacamole = new Ingrediente("guacamole",2);
			Ingrediente chilli = new Ingrediente("chilli",2);
			ingredientes.add(nachos);
			ingredientes.add(guacamole);
			ingredientes.add(chilli);
			break;
		
		case "rollitos":
			
			Ingrediente aceite = new Ingrediente("aceite",2);
			Ingrediente queso_rollito = new Ingrediente("queso",2);
			Ingrediente jamon_rollito = new Ingrediente("jamon",2);
			Ingrediente rucula = new Ingrediente("rucula",1);
			ingredientes.add(aceite);
			ingredientes.add(queso_rollito);
			ingredientes.add(queso_rollito);
			ingredientes.add(jamon_rollito);
			ingredientes.add(rucula);
			
		case "falafel":
			Ingrediente garbanzos = new Ingrediente("garbanzo",5);
			Ingrediente ajo = new Ingrediente("ajo",3);
			Ingrediente cebolla = new Ingrediente("cebolla",2);
			Ingrediente perejil = new Ingrediente("perejil",1);
			Ingrediente comino = new Ingrediente("comino",2);
			Ingrediente sal = new Ingrediente("sal",1);
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
			
		case "paella":
			
			Ingrediente arroz = new Ingrediente("arroz",2);
			Ingrediente gambas=new Ingrediente("gambas",6);
			Ingrediente aceitunas=new Ingrediente("aceitunas",8);
			ingredientes.add(arroz);
			ingredientes.add(gambas);
			ingredientes.add(aceitunas);
			p.setIngredientes(ingredientes);
			break; 
			
		case "espaguetis_con_carne":
			Ingrediente espagueti = new Ingrediente("espaguettis",1);
			Ingrediente chorizo=new Ingrediente("chorizo",4);
			Ingrediente tomate_espagueti=new Ingrediente("tomate ",1);
			ingredientes.add(espagueti);
			ingredientes.add(chorizo);
			ingredientes.add(tomate_espagueti);
			p.setIngredientes(ingredientes);
			break;
			
		case "almejas_a_la_marinera":
			Ingrediente almejas = new Ingrediente("almejas",1);
			Ingrediente limon=new Ingrediente("limon",1);
			Ingrediente salsa_marinera=new Ingrediente("salsa marinera",1);
			ingredientes.add(almejas);
			ingredientes.add(limon);
			ingredientes.add(salsa_marinera);
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
		
		case "Albondigas":
			
			Ingrediente carne_picada = new Ingrediente("carne picada",1);
			Ingrediente perejil=new Ingrediente("perejil",1);
			ingredientes.add(carne_picada);
			ingredientes.add(perejil);
			p.setIngredientes(ingredientes);
			break;
			
		case "Pizza":
			
			Ingrediente masa = new Ingrediente("masa",1);
			Ingrediente tomate_pizza=new Ingrediente("tomate ",2);
			Ingrediente queso_pizza=new Ingrediente("queso ",3);
			ingredientes.add(masa);
			ingredientes.add(tomate_pizza);
			ingredientes.add(queso_pizza);
			p.setIngredientes(ingredientes);
			break;
			
		case "Calamares_en_su_tinta":
			
			Ingrediente calamares = new Ingrediente("calamares",2);
			Ingrediente tinta=new Ingrediente("tinta",1);
			Ingrediente zanahoria=new Ingrediente("zanahoria",2);
			ingredientes.add(calamares);
			ingredientes.add(tinta);
			ingredientes.add(zanahoria);
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
		
	case "helado":
		
		Ingrediente nata_helado = new Ingrediente("nata", 1);
		Ingrediente azucar = new Ingrediente("azucar",2);
		ingredientes.add(nata_helado);
		ingredientes.add(azucar);
		p.setIngredientes(ingredientes);
		
		break;
		
	case "cafe":
		
		Ingrediente leche = new Ingrediente("leche", 1);
		Ingrediente granos_cafe = new Ingrediente("granos de cafe",2);
		ingredientes.add(leche);
		ingredientes.add(granos_cafe);
		p.setIngredientes(ingredientes);
		
		break;
		
	case "mus":
		
		Ingrediente chocolate = new Ingrediente("chocolate", 3);
		Ingrediente mantequilla = new Ingrediente("mantequilla",2);
		Ingrediente azucar_mus = new Ingrediente("azucar",2);
		ingredientes.add(chocolate);
		ingredientes.add(mantequilla);
		ingredientes.add(azucar_mus);
		p.setIngredientes(ingredientes);
		
		break;
		
	case "fresas_con_chocolate_y_nata":
		
		Ingrediente fresa = new Ingrediente("fresa", 4);
		Ingrediente chocolate_fresa = new Ingrediente("chocolate",2);
		Ingrediente nata_fresa = new Ingrediente("nata",2);
		ingredientes.add(fresa);
		ingredientes.add(chocolate_fresa);
		ingredientes.add(nata_fresa);
		p.setIngredientes(ingredientes);
		
		break;
		
		

		
	}
	return p;

}
	
}
