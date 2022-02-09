package Main;

import java.util.LinkedList;

public class Vertex {
	private int V;
	private LinkedList<Integer> children;

	public Vertex(int[] hijos, int id) 
	{
		this.V = id;
		children = new LinkedList<Integer>();
		for (int i = 0; i < hijos.length; i++) 
		{
			children.add(hijos[i]);
		}
	}

	public int getV() {
		return V;
	}

	public LinkedList<Integer> getChildren() {
		return children;
	}

}
