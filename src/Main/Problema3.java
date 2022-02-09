package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Problema3 {


	public class Partition{
		private int[] p;
		private int[] rankings;	

		public Partition (int n)
		{
			p = new int[n];
			rankings = new int[n];
			for ( int i = 0 ; i <n ;i++) 
			{
				p[i] = i;
				rankings[i] = 1;
			}
		}

		public int find(int v)
		{
			if(p[v] == v) return v;
			int r = find(p[v]);
			p[v] = r;
			return r;
		}

		public void union (int v1, int v2)
		{

			int s1 = find(v1);
			int s2 = find(v2);
			if( rankings[s1] > rankings[s2]){
				p[s2] = s1;
			}
			else
			{
				p[s1] = s2;
				if ( rankings[s1] == rankings[s2])
				{
					(rankings[s2])++ ;
				}
			}
		}
	}

	private Edge[] ejes;
	private Partition particion;

	public Problema3 (ArrayList<Integer> nodos, ArrayList<Edge> ejes) 
	{
		this.ejes = new Edge[ejes.size()];
		for (int i =0 ; i< ejes.size(); i++) {this.ejes[i] = ejes.get(i);}
		this.particion = new Partition(nodos.size());
	}

	class ComparatorEdges implements Comparator<Edge>{

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.getCosto() - o2.getCosto()> 0 ? 1 : o1.getCosto() - o2.getCosto() < 0 ?  -1 : 0;
		}
	}
	public boolean definirCarreteras()
	{
		ArrayList<Edge> resultado = new ArrayList<Edge>();
		Arrays.sort(ejes, new ComparatorEdges());
		for( Edge eje : ejes)
		{
			int ini = eje.getInicio();
			int fin = eje.getFin();
			if( particion.find(ini) != particion.find(fin))
			{
				particion.union(ini, fin);
				resultado.add(eje);
			}
		}
		
		for(Edge ejeccito : resultado)
		{
			System.out.println(ejeccito.getInicio() + " - " + ejeccito.getFin());
		}
		
		return false;
	}


}
