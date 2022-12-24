package modelo;

import java.time.LocalDate;

public class Socios {
	// atributos con mismo nombre que la bbdd
	private int id_socio;
	private String nombre;
	private String apellido;
	private String direccion;
	private String localidad;
	private LocalDate fnac;
	private String email;
	private String telefono;
	private boolean active;
	
	// Constructor
	public Socios(int id_socio, String nombre, String apellido, String direccion,
			String localidad, LocalDate fnac, String email, String telefono, boolean active) {
		super();
		this.id_socio = id_socio;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.localidad = localidad;
		this.fnac = fnac;
		this.email = email;
		this.telefono = telefono;
		this.active = active;
	}

	// Getters & Setters

	public int getId_socio() {
		return id_socio;
	}
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
		
	public LocalDate getFnac() {
		return fnac;
	}

	public void setFnac(LocalDate fnac) {
		this.fnac = fnac;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	
}
