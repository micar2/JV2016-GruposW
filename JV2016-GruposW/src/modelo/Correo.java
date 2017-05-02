/** 
 * Proyecto: Juego de la vida.
 * Implementa el concepto de dirección de correo electrónico según el modelo 2.
 * Se hace validación de datos pero no se gestionan todavía los errores correspondientes. 
 * @since: prototipo1.2
 * @source: Correo.java 
 * @version: 2.2 - 2017.05.02
 * @author: jomahym,judcsaura,johndayne
 */

package modelo;

import java.io.Serializable;
import util.Formato;
import modelo.ModeloException;

public class Correo implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private String texto;
	
	public Correo(String texto) throws ModeloException {
		setTexto(texto);
	}

	public Correo() throws ModeloException {
		this("correo@correo.com");
	}

	public Correo(Correo correo) throws ModeloException {
		this(correo.texto);
	}
	
	public void setTexto(String texto) throws ModeloException {
		if (direccionValida(texto)){
		this.texto = texto;
		return;
		}
	throw new ModeloException ("El correo:"+ texto + "no es v�lido");
	}
	
	/**
	 * Comprueba validez de una dirección de correo.
	 * @param texto.
	 * @return true si cumple.
	 */
	private boolean direccionValida(String texto) {
		if (texto != null 
				&& util.Formato.validar(texto, Formato.PATRON_CORREO)
				&& correoAutentico(texto)) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba que una dirección de correo existe.
	 * @return true si cumple.
	 */
	public boolean correoAutentico(String texto) {
		// Comprueba que el correo no es falso
		// --Pendiente--
		return true;
	}

	public String getTexto() {
		return texto;
	}
	
	@Override
	public String toString() {
		return texto;
	}
	
	/**
	 * hashcode() complementa al método equals y sirve para comparar objetos de forma 
	 * rápida en estructuras Hash. 
	 * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
	 * primero invoca al método hashcode y luego el equals.
	 * @return un número entero de 32 bit.
	*/
	@Override
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		result = primo * result + ((texto == null) ? 0 : texto.hashCode());
		return result;
	}

	/**
	 * Dos objetos son iguales si: 
	 * Son de la misma clase.
	 * Tienen los mismos valores en los atributos; o son el mismo objeto.
	 * @return falso si no cumple las condiciones.
	*/
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (texto.equals(((Correo) obj).texto)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Genera un clon del propio objeto realizando una copia profunda.
	 * @return el objeto clonado.
	*/
	@Override
	public Object clone() {
		Object clon = null;
		try {
			clon = new Correo(this);
		} catch (ModeloException e) {}
			return clon;
	}
} //class
