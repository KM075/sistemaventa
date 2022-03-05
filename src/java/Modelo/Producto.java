/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Aprendiz
 */
public class Producto {

    private int id;
    private String nom;
    private double precio;
    private int stock;
    private String es;

    public Producto() {
    }
    
    

    public Producto(int id, String nom, double precio, int stock, String es) {
        this.id = id;
        this.nom = nom;
        this.precio = precio;
        this.stock = stock;
        this.es = es;
    }

  
    public int getId() {
        return id;
    }

  
    public void setId(int id) {
        this.id = id;
    }

  
    public String getNom() {
        return nom;
    }

 
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    public double getPrecio() {
        return precio;
    }

   
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    public int getStock() {
        return stock;
    }

   
    public void setStock(int stock) {
        this.stock = stock;
    }

   
    public String getEs() {
        return es;
    }

   
    public void setEs(String es) {
        this.es = es;
    }





   

}
