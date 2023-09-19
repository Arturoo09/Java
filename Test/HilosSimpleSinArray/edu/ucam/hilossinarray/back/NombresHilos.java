package edu.ucam.hilossinarray.back;

import edu.ucam.hilossinarray.back.NombresHilos;

public enum NombresHilos {
	HILO_1("Hilo1"), HILO_2("Hilo2");

	private final String nombreHilo;

	private NombresHilos(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public static String[] getNombreHilosArray() {
		NombresHilos[] values = NombresHilos.values();
		String[] nombresHilosArray = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			nombresHilosArray[i] = values[i].getNombreHilo();
		}

		return nombresHilosArray;
	}

}
