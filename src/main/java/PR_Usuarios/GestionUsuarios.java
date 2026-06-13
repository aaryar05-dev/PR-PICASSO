/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PR_Usuarios;

import java.io.*;
import java.util.ArrayList;

public class GestionUsuarios {
    
    private ArrayList<Usuarios> listaUsuarios;
    private final String rutaArchivo = "usuarios.txt";

    public GestionUsuarios() {
        listaUsuarios = new ArrayList<>();
        crearArchivo();
        cargarUsuarios();
    }

    public void crearArchivo() {
        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) archivo.createNewFile();
        } catch (IOException e) {
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    public void cargarUsuarios() {
        listaUsuarios.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 4) {
                    String nombre = datos[0];
                    int nivel1 = Integer.parseInt(datos[1]);
                    int nivel2 = Integer.parseInt(datos[2]);
                    int nivel3 = Integer.parseInt(datos[3]);
                    listaUsuarios.add(new Usuarios(nombre, nivel1, nivel2, nivel3));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en formato de número: " + e.getMessage());
        }
    }

    public void guardarUsuarios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Usuarios u : listaUsuarios) {
                pw.println(u.getNombre() + "," + u.getNivel1() + "," + u.getNivel2() + "," + u.getNivel3());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    public Usuarios buscarUsuario(String nombre) {
        for (Usuarios u : listaUsuarios) {
            if (u.getNombre().equalsIgnoreCase(nombre)) return u;
        }
        
        return null;
    }

    public void agregarUsuario(Usuarios usuario) {
        listaUsuarios.add(usuario);
        guardarUsuarios();
    }

    public void actualizarUsuario(Usuarios usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNombre().equalsIgnoreCase(usuario.getNombre())) {
                listaUsuarios.set(i, usuario);
                guardarUsuarios();
                return;
            }
        }
    }
}
