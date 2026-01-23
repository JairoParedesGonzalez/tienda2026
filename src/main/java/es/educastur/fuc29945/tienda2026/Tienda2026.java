/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package es.educastur.fuc29945.tienda2026;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 1dawd27
 */
public class Tienda2026 {
    
    private static Scanner sc=new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
    public Tienda2026() {
        pedidos = new ArrayList();
        articulos= new HashMap();
        clientes = new HashMap();
    }
    
    public static void main(String[] args) {
        Tienda2026 t2026=new Tienda2026();
        t2026.cargaDatos();
        t2026.menu();
    }
    //<editor-fold defaultstate="collapsed" desc="CARGA DATOS">
    public void cargaDatos(){
       clientes.put("80580845T",new Cliente("80580845T","ANA ","658111111","ana@gmail.com"));
       clientes.put("36347775R",new Cliente("36347775R","LOLA","649222222","lola@gmail.com"));
       clientes.put("63921307Y",new Cliente("63921307Y","JUAN","652333333","juan@gmail.com"));
       clientes.put("02337565Y",new Cliente("02337565Y","EDU","634567890","edu@gmail.com"));
              
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",9,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",0,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",5,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
       articulos.put("4-33",new Articulo("4-33","SAMSUNG ODISSEY G5",12,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("80580845T-001/2025",clientes.get("80580845T"),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-11",3),new LineaPedido("4-22",3)))));                                                                                                                                                               
       pedidos.add(new Pedido("80580845T-002/2025",clientes.get("80580845T"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-11",3),new LineaPedido("4-22",2),new LineaPedido("4-33",4)))));
       pedidos.add(new Pedido("36347775R-001/2025",clientes.get("36347775R"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("4-22",1),new LineaPedido("2-22",3)))));
       pedidos.add(new Pedido("36347775R-002/2025",clientes.get("36347775R"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("4-33",3),new LineaPedido("2-11",3)))));
       pedidos.add(new Pedido("63921307Y-001/2025",clientes.get("63921307Y"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-11",5),new LineaPedido("2-33",3),new LineaPedido("4-33",2)))));
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="MENU">
    private void menu(){
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tTIENDA\n");
            System.out.println("\t\t\t\t1 - ARTICULOS");
            System.out.println("\t\t\t\t2 - CLIENTES");
            System.out.println("\t\t\t\t3 - PEDIDOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    menuArticulos();
                    break;
                }    
                case 2:{
                    menuClientes();
                    break;
                } 
                case 3:{
                    menuPedidos();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuArticulos() {
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU ARTICULOS\n");
            System.out.println("\t\t\t\t1 - ALTA");
            System.out.println("\t\t\t\t2 - BAJA");
            System.out.println("\t\t\t\t3 - REPOSICION");
            System.out.println("\t\t\t\t4 - LISTAR");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    altaArticulos();
                    break;
                }    
                case 2:{
                    bajaArticulos();
                    break;
                } 
                case 3:{
                    reposicionArticulos();
                    break;
                } 
                case 4:{
                    listarArticulos();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuClientes() {
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU ARTICULOS\n");
            System.out.println("\t\t\t\t1 - ALTA");
            System.out.println("\t\t\t\t2 - BAJA");
            System.out.println("\t\t\t\t3 - MODIFICAR");
            System.out.println("\t\t\t\t4 - LISTAR");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    altaCliente();
                    break;
                }    
                case 2:{
                    bajaCliente();
                    break;
                } 
                case 3:{
                    modificarCliente();
                    break;
                } 
                case 4:{
                    listarCliente();
                    break;
                } 
            }
        }while (opcion != 9);
    }

    private void menuPedidos() {
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU PEDIDOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PEDIDO");
            System.out.println("\t\t\t\t2 - LISTADO DE PEDIDOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    nuevoPedido();
                    break;
                }    
                case 2:{
                    listarPedido();
                    break;
                } 
            }
        }while (opcion != 9);
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ARTICULO">
    private void altaArticulos() {
        String idArticulo, descripcion, existencias, pvp;
        System.out.println("Alta del articulo nuevo");
        do {            
            System.out.println("Dame el id del articulo nuevo");
            idArticulo=sc.nextLine();
        } while (!idArticulo.matches("[1-5][-][0-9][0-9]")||articulos.values().equals(idArticulo));
        System.out.println("Introduzca la descripcion del articulo");
        descripcion=sc.nextLine();
        do {            
            System.out.println("Introduzca las existencias de articulo nuevo");
            existencias=sc.nextLine();
        } while (!MetodosAuxiliares.esInt(existencias));
        do {            
            System.out.println("Introduzca el precio de articulo");
            pvp=sc.nextLine();
        } while (!MetodosAuxiliares.esDouble(pvp));
        Articulo a =new Articulo(idArticulo, descripcion, Integer.parseInt(existencias),Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
    }

    private void bajaArticulos() {
    }

    private void reposicionArticulos() {
        
    }

    private void listarArticulos() {
        System.out.println("Listado de Articulos");
        for (Articulo a : articulos.values()) {
            System.out.println(a);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="CLIENTE">
    private void altaCliente() {
    }

    private void bajaCliente() {
        
    }

    private void modificarCliente() {
       
    }

    private void listarCliente() {
        System.out.println("Listado de Clientes");
        for (Cliente c : clientes.values()) {
            System.out.println(c);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PEDIDO">
    private void nuevoPedido() {
    }

    private void listarPedido() {
        System.out.println("Listado de Pedidos");
        for (Pedido p : pedidos) {
            System.out.println(p);
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="LISTADOS CON STREAMS">
    
//</editor-fold>
    
}
