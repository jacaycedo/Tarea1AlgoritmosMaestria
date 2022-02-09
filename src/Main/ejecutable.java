package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ejecutable {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Ingresa uno de los numeros para comprobar la implementacion:");
		System.out.println("\t 1. Seis Grados Separacion \n\t 2.Ciclo en prestamos \n\t 5.Vias Ciudad \n");

		int problemaResolver = Integer.parseInt(reader.readLine());
		if(problemaResolver==1) 
		{
			System.out.println("Marca el caso que desead comprobar: \n\t 1.Exito \n\t 2.Falla por longitud \n\t 3.Falla por aislamiento de nodo");

			ArrayList<int[]> nodos = new ArrayList<int[]>();
			int indiceSeleccion = Integer.parseInt(reader.readLine());

			String contenido = "";
			BufferedReader br = new BufferedReader( new FileReader( new File("./datosCarga/p1/p1-"+indiceSeleccion+".txt" )));
			while ((contenido = br.readLine())!= null) {
				contenido = contenido.replace("[", "");
				contenido = contenido.replace("]", "");
				String [] nodoNoP = contenido.split(",");

				int[] nodo = new int[nodoNoP.length];
				for (int i = 0; i < nodoNoP.length; i++) 
				{
					nodo[i] = Integer.parseInt(nodoNoP[i]);
				}
				nodos.add(nodo);
			}
			Problema1 p1 = new Problema1(nodos);
			boolean cumplio = p1.evaluarSeisGrados();

			if(cumplio) System.out.println("Se cumple la teoria de separación los de 6 grados");
			else System.out.println("No se cumple la teoria de separación de los 6 grados");

		}
		if(problemaResolver==2) 
		{
			System.out.println("Marca el caso que deseas comprobar: \n\t 1.No hay autoprestamos \n\t 2.Hay autoprestamos");

			ArrayList<int[]> nodos = new ArrayList<int[]>();
			int indiceSeleccion = Integer.parseInt(reader.readLine());

			String contenido = "";
			BufferedReader br = new BufferedReader( new FileReader( new File("./datosCarga/p2/p2-"+indiceSeleccion+".txt" )));
			while ((contenido = br.readLine())!= null) {
				contenido = contenido.replace("[", "");
				contenido = contenido.replace("]", "");
				String [] nodoNoP = contenido.split(",");

				int[] nodo = new int[nodoNoP.length];
				for (int i = 0; i < nodoNoP.length; i++) 
				{
					nodo[i] = Integer.parseInt(nodoNoP[i]);
				}
				nodos.add(nodo);
			}
			Problema2 p2 = new Problema2(nodos);
			boolean cumplio = p2.cicloPrestamos();

			if(!cumplio) System.out.println("No hay autoprestamo");
			else System.out.println("Hay autopretamos");
		}

		if(problemaResolver == 5)
		{

			System.out.println("Para el ejemplo creado para el ejercicio, el resultado de los ejes que necesitan ser doblevia es: ");
			ArrayList<Integer> nodos = new ArrayList<Integer>();
			ArrayList<Edge> ejes = new ArrayList<Edge>();
			String contenido = "";
			BufferedReader br = new BufferedReader( new FileReader( new File("./datosCarga/p3/p3-1.txt" )));
			while ((contenido = br.readLine())!= null) {
				contenido = contenido.replace("[", "");
				contenido = contenido.replace("]", "");
				String [] nodoNoP = contenido.split(",");
				int inicio = Integer.parseInt(nodoNoP[0]);
				int fin = Integer.parseInt(nodoNoP[1]);
				double costo = Double.parseDouble(nodoNoP[2]);
				ejes.add(new Edge(inicio, fin, costo));
				if(!nodos.contains(inicio)) {nodos.add(inicio);}
				if(!nodos.contains(fin)) {nodos.add(fin);}				
			}
			Problema3 p3 = new Problema3(nodos, ejes);
			p3.definirCarreteras();
		}
	}

}
