/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PR_Usuarios;

/**
 *
 * @author pikar
 */
public class Usuarios {
    
    private String nombre;
    private int nivel1;
    private int nivel2;
    private int nivel3;

    public Usuarios() {
    }

    public Usuarios(String nombre) {
        this.nombre = nombre;
        this.nivel1 = 0;
        this.nivel2 = 0;
        this.nivel3 = 0;
    }

    public Usuarios(String nombre, int nivel1, int nivel2, int nivel3) {
        this.nombre = nombre;
        this.nivel1 = nivel1;
        this.nivel2 = nivel2;
        this.nivel3 = nivel3;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel1() {
        return nivel1;
    }

    public int getNivel2() {
        return nivel2;
    }

    public int getNivel3() {
        return nivel3;
    }

    public void setNivel1(int nivel1) {
        this.nivel1 = nivel1;
    }

    public void setNivel2(int nivel2) {
        this.nivel2 = nivel2;
    }

    public void setNivel3(int nivel3) {
        this.nivel3 = nivel3;
    }

    public int calcularProgresoGeneral() {
        return nivel1 + nivel2 + nivel3;
    }
}