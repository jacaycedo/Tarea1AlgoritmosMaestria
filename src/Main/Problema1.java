package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problema1 {


	private Vertex[] grafo;

	public boolean evaluarSeisGrados()
	{
		Vertex [] vertices = grafo;
		int n = grafo.length;
		boolean valido = true;
		int revisados = 0;
		while( valido && revisados < n)
		{
			for ( Vertex vertice : vertices) 
			{
				revisados++;
				if(valido)
				{
					int [] nivel = new int [n];
					int contador = 1;
					Arrays.fill( nivel, -1);
					Queue <Vertex> cola = new LinkedList<Vertex>();
					cola.add(vertice);
					nivel [vertice.getV()] = 0;
					while ( cola.size() > 0)
					{
						Vertex v = (Vertex)cola.poll();
						LinkedList<Integer> hijos = v.getChildren();
						for ( Integer w : hijos )
						{
							if ( nivel[w] < 0) 
							{
								nivel[w] = nivel[v.getV()] + 1;
								cola.add(grafo[w]);
								contador++;
							}
							if (nivel[w] > 6)
							{
								valido = false;
								break;
							}
						}
					}
					if ( contador != n)
					{
						valido = false;
					}

				}
				else break;
			}
		}
		return valido;
	}

	public Problema1 ( ArrayList<int[]> nodos)
	{
		grafo = new Vertex[nodos.size()];

		for (int i = 0; i < nodos.size(); i++) 
		{
			grafo[i] = new Vertex( nodos.get(i), i);
		}
	}

}
