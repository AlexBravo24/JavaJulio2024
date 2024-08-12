package com;

public class Memoria {
	
	private String marca;
	private String modelo;
	private double capacidad;
	
	//constructor vacio
	public Memoria () {}
	
	//Consturcor con todos los par�metros

	public Memoria(String marca, String modelo, double capacidad) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.capacidad = capacidad;
	}
	
	//Getter y setters

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	
	//to String

	@Override
	public String toString() {
		return "Memoria [marca=" + marca + ", modelo=" + modelo + ", capacidad=" + capacidad + "]";
	}
	

}