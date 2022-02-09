package Main;


class Edge {

	private int inicio;
	private int fin;
	private double costo;

	public int getInicio(){
		return inicio;
	}


	public int getFin() {
		return fin;
	}


	public double getCosto() {
		return costo;
	}

	public Edge (int inicio, int fin, double costo)
	{
		this.inicio = inicio;
		this.fin = fin;
		this.costo = costo;
	}


}
