package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Problema2 {

	private Vertex[] grafo;

	public boolean cicloPrestamos()
	{
		Vertex [] vertices = grafo;
		int n = grafo.length;
		boolean autoprestamo = false;
		
		for (Vertex vertice: vertices)
		{
			if (!autoprestamo)
			{
				boolean[] visitado = new boolean[n];
				Arrays.fill(visitado, false);
				Stack <Vertex> stack = new Stack <Vertex> ();
				stack.push(vertice);
				visitado[vertice.getV()] = true;
				while (stack.size() > 0 ) 
				{
					Vertex sig = stack.pop();
					LinkedList<Integer> prestamosDirectos = sig.getChildren();
					for ( Integer prestado : prestamosDirectos)
					{
						if( grafo[prestado] == vertice)
						{
							autoprestamo = true;
							break;
						}
						if( !visitado[prestado])
						{
							stack.push(grafo[prestado]);
							visitado[prestado] = true;
						}
					}
				}
			}
		}

		return autoprestamo;
	}

	public Problema2 ( ArrayList<int[]> nodos)
	{
		grafo = new Vertex[nodos.size()];

		for (int i = 0; i < nodos.size(); i++) 
		{
			grafo[i] = new Vertex( nodos.get(i), i);
		}
	}

}
