package edu.ucam.hilos.back;

public enum NombreHilos {
	HILO_1("MiHilo"), HILO_2("MiHilo2");

	private final String nombreHilo;

	private NombreHilos(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public static String[] getNombreHilosArray() {
		NombreHilos[] values = NombreHilos.values();
		String[] nombresHilosArray = new String[values.length];

		for (int i = 0; i < values.length; i++) {
			nombresHilosArray[i] = values[i].getNombreHilo();
		}

		return nombresHilosArray;
	}

}
