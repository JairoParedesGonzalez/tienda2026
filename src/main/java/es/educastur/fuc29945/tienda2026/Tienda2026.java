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
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author 1dawd27
 */
public class Tienda2026 {
    
    private static Scanner sc=new Scanner(System.in);
    private ArrayList<Pedido> pedidos;
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public HashMap<String, Articulo> getArticulos() {
        return articulos;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
    
    public Tienda2026() {
        pedidos = new ArrayList();
        articulos= new HashMap();
        clientes = new HashMap();
    }
    
    public static void main(String[] args) {
        Tienda2026 t2026=new Tienda2026();
        t2026.cargaDatos();
        t2026.menu();
        //t2026.uno();
        //t2026.dos();
        //t2026.tres();
        //t2026.cuatro();
        //t2026.cinco();
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
        (List.of(new LineaPedido(articulos.get("1-11"),3),new LineaPedido(articulos.get("4-22"),3)))));                                                                                                                                                               
       pedidos.add(new Pedido("80580845T-002/2025",clientes.get("80580845T"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido(articulos.get("4-11"),3),new LineaPedido(articulos.get("4-22"),2),new LineaPedido(articulos.get("4-33"),4)))));
       pedidos.add(new Pedido("36347775R-001/2025",clientes.get("36347775R"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido(articulos.get("4-22"),1),new LineaPedido(articulos.get("2-22"),3)))));
       pedidos.add(new Pedido("36347775R-002/2025",clientes.get("36347775R"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido(articulos.get("4-33"),3),new LineaPedido(articulos.get("2-11"),3)))));
       pedidos.add(new Pedido("63921307Y-001/2025",clientes.get("63921307Y"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido(articulos.get("2-11"),5),new LineaPedido(articulos.get("2-33"),3),new LineaPedido(articulos.get("4-33"),2)))));
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
            System.out.println("\t\t\t\t4 - LISTADOS CON STREAMS");
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
                case 4:{
                    listadosStreams();
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
            System.out.println("\n\n\n\n\n\t\t\t\tMENU CLIENTES\n");
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
        System.out.println("Ingrese su nombre");
        String nombre=sc.next().toUpperCase();
        String dni;
        do {            
            System.out.println("Ingrese su dni");
            dni=sc.next().toUpperCase();
        } while (!MetodosAuxiliares.validarDNI(dni));
        System.out.println("El dni correcto es "+dni);
        System.out.println("Ingrese su nº de telefono");
        String telefono=sc.next();
        System.out.println("Ingrese su email");
        String email=sc.next().toLowerCase();
        clientes.put(dni,new Cliente(dni,nombre,telefono,email));
    }
    private void bajaCliente() {
        
    }
    private void modificarCliente() {
        String dni,nombre,telefono,email;
        do {         
            System.out.println("Introduzca el dni del cliente que quiere modificar");
            dni=sc.next();
        } while (!clientes.containsKey(dni)||!MetodosAuxiliares.validarDNI(dni));
        System.out.println("Introduzca el nombre del usuario");
        nombre=sc.next().toUpperCase();
        System.out.println("Introduzca el telefono");
        telefono=sc.next();
        System.out.println("Introduzca el email");
        email=sc.next().toLowerCase();
        clientes.replace(dni,new Cliente(dni,nombre,telefono,email));
    }
    private void listarCliente() {
        clientes.values().stream().forEach(c->System.out.println(c));
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="PEDIDO">
    private void nuevoPedido() {
        String idCliente;
        do {            
            System.out.println("DNI CLIENTE");
            idCliente=sc.next().toUpperCase();
            if (!clientes.containsKey(idCliente)) {
                System.out.println("No es cliente de la tienda..."+"Desea darse de alta como cliente o quiere continuar como invitado");
            }
        } while (!MetodosAuxiliares.validarDNI(idCliente));
        
        ArrayList<LineaPedido> cestaCompra=new ArrayList();
        String idArticulo;
        int unidades=0;            
        System.out.println("Teclee el ID del articulo deseado (Fin para terminar la compra)");
        idArticulo=sc.next();
        while (!idArticulo.equalsIgnoreCase("FIN")){
            System.out.println("\nTeclee las unidades deseadas");
            unidades=sc.nextInt();
            try {
                stock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(articulos.get(idArticulo),unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            }
            catch(StockInsuficiente ex){
                System.out.println(ex.getMessage());
                System.out.println("Si quiere puede proseguir con la compra de estas unidades, teclee la Si o NO para finalizar la compra de este articulo");
                String respuesta=sc.next();
                if (respuesta.equalsIgnoreCase("Si")) {
                    cestaCompra.add(new LineaPedido(articulos.get(idArticulo),articulos.get(idArticulo).getExistencias()));
                }
            }
            System.out.println("Teclee el ID del articulo deseado (Fin para terminar la compra)");
            idArticulo=sc.next();
        }       
        if (!cestaCompra.isEmpty()) {
            System.out.println("Este es tu pedido");
            double precioTotal=0;
            for (LineaPedido l: cestaCompra) {
                double pvpPorArticulo=0;
                pvpPorArticulo=l.getArticulo().getPvp()*l.getUnidades();
                System.out.println(l.getArticulo().getDescripcion()+" - "
                        +l.getUnidades()+" - "+l.getArticulo().getPvp()+" - "+pvpPorArticulo);
                precioTotal+=pvpPorArticulo;
            }
            System.out.println("El precio total de la operacion es "+precioTotal);
            System.out.println("Si quiere finalizar la compra teclee Si en caso contrario teclee No");
            String respuesta=sc.next();
            if (respuesta.equalsIgnoreCase("Si")) {
                pedidos.add(new Pedido(generarIdPedido(idCliente), clientes.get(idCliente), LocalDate.now(), cestaCompra));
                for (LineaPedido l: cestaCompra) {
                    l.getArticulo().setExistencias(l.getArticulo().getExistencias()-l.getUnidades());
                }
            } 
        }    
    }
    private void listarPedido() {
        System.out.println("Listado de Pedidos");
        for (Pedido p : pedidos) {
            System.out.println(p+"- Total: "+totalPedido(p));
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    private String generarIdPedido(String idCliente){
        int contador=0;
        String nuevoId;
        for (Pedido p : pedidos) {
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                contador++;
            }
        }
        contador++;
        nuevoId = idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }
    public double totalPedido (Pedido p){
        double total=0;
        for (LineaPedido l : p.getCestaCompra()) {
            total+=l.getArticulo().getPvp()*l.getUnidades();
        }
        return total;
    }
    private void stock(String idArticulo, int unidades)throws StockCero,StockInsuficiente{
        if (articulos.get(idArticulo).getExistencias()==0) {
            throw new StockCero("0 unidades disponibles de: "+articulos.get(idArticulo).getDescripcion());
        }
        if (articulos.get(idArticulo).getExistencias()<unidades) {
            throw new StockInsuficiente("No tenemos "+unidades+" disponibles"+" solo nos quedan "
                    +articulos.get(idArticulo).getExistencias()
                    +" unidades de "+articulos.get(idArticulo).getDescripcion());
        }
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="LISTADOS CON STREAMS">
    private void listadosStreams (){
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tSTREAMS\n");
            System.out.println("\t\t\t\t1 - PRECIO TOTAL DE PEDIDOS ORDENADOS DE MAYOR A MENOR");
            System.out.println("\t\t\t\t2 - PEDIDOS MAYORES DE 1000 EUROS");
            System.out.println("\t\t\t\t3 - ARTICULOS MENORES DE 100 EUROS");
            System.out.println("\t\t\t\t4 - ARTICULOS ENTRE 10 Y 100 EUROS");
            System.out.println("\t\t\t\t5 - CONTABILIZA LOS PEDIDOS DE UN CLIENTE");
            System.out.println("\t\t\t\t6 - CONTABILIZA LOS PEDIDOS POR CLIENTE");
            System.out.println("\t\t\t\t99 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    pedidos.stream().sorted(Comparator.comparingDouble(p->totalPedido((Pedido)p)).reversed())
                        .forEach(p->System.out.println(p+"- Total: "+totalPedido(p)));
                    break;
                }    
                case 2:{
                    pedidos.stream().filter(p->totalPedido((Pedido)p)>1000)
                        .forEach(p->System.out.println(p+"- Total: "+totalPedido(p)));
                    break;
                } 
                case 3:{
                    articulos.values().stream().filter(a->a.getPvp()<100)
                        .sorted(Comparator.comparing(Articulo::getPvp).reversed()).forEach(a->System.out.println(a));
                    break;
                } 
                case 4:{
                    articulos.values().stream().filter(a->a.getPvp()<100 && a.getPvp()>10)
                        .sorted(Comparator.comparing(Articulo::getPvp).reversed()).forEach(a->System.out.println(a));
                    break;
                } 
                case 5:{
                    System.out.println("Introduce el dni del cliente");
                    String dni=sc.next();
                    long numPedidos=pedidos.stream().filter(p->p.getClientePedido().getIdCliente().matches(dni)).count();
                    System.out.println(clientes.get(dni).getNombre()+" tiene "+numPedidos);
                    break;
                }
                case 6:{
                    Map<Cliente, Long>numPedidosPorCliente=
                    pedidos.stream().collect(Collectors.groupingBy(Pedido::getClientePedido,Collectors.counting()));
                    System.out.println(numPedidosPorCliente);
                    break;
                }
            }
        }while (opcion != 99);
    
    }
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="EXAMEN">
    private void uno(){
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tSECCION\n");
            System.out.println("\t\t\t\t1 - PERIFERICOS");
            System.out.println("\t\t\t\t2 - ALMACENAMIENTO");
            System.out.println("\t\t\t\t3 - IMPRESORAS");
            System.out.println("\t\t\t\t4 - MONITORES");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            ArrayList<Articulo> articulosAux= new ArrayList(articulos.values());
            switch (opcion){
                case 1:{
                    articulosAux.stream().filter(a->a.getIdArticulo().startsWith("1"))
                            .forEach(a->System.out.println(a));
                    break;
                }    
                case 2:{
                    articulosAux.stream().filter(a->a.getIdArticulo().startsWith("2"))
                            .forEach(a->System.out.println(a));
                    break;
                } 
                case 3:{
                    articulosAux.stream().filter(a->a.getIdArticulo().startsWith("3"))
                            .forEach(a->System.out.println(a));
                    break;
                } 
                case 4:{
                    articulosAux.stream().filter(a->a.getIdArticulo().startsWith("4"))
                            .forEach(a->System.out.println(a));
                    break;
                } 
            }
        }while (opcion != 9);
    }
    private void dos(){
        ArrayList<Articulo> articulosAux= new ArrayList(articulos.values());
        System.out.println("PERIFERICOS");
        articulosAux.stream().filter(a->a.getIdArticulo().startsWith("1"))
                            .forEach(a->System.out.println(a));
        System.out.println("ALMACENAMIENTO");
        articulosAux.stream().filter(a->a.getIdArticulo().startsWith("2"))
                            .forEach(a->System.out.println(a));
        System.out.println("IMPRESORAS");
        articulosAux.stream().filter(a->a.getIdArticulo().startsWith("3"))
                            .forEach(a->System.out.println(a));
        System.out.println("MONITORES");
        articulosAux.stream().filter(a->a.getIdArticulo().startsWith("4"))
                            .forEach(a->System.out.println(a));
    }
    private void tres(){
        System.out.println("Introduzca el DNI del cliente");
        String idCliente=sc.next();
        System.out.println("Pedidos del cliente "+clientes.get(idCliente).getNombre());
        double precioTotal=0;
        for (Pedido p:pedidos) {
            double precioPedido=0;
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)) {
                for (LineaPedido l : p.getCestaCompra()) {
                    precioPedido+=l.getUnidades()*l.getArticulo().getPvp();
                    
                }
                System.out.println(p+" - "+precioPedido);
                precioTotal+=precioPedido;
            }     
        }
        System.out.println("Total gastado: "+precioTotal);
    }
    private void cuatro(){
        articulos.values().stream().sorted(Comparator.comparing(a->unidadesPorArticulo((Articulo)a)).reversed())
                .forEach(a->System.out.println(a.getDescripcion()+"- Total: "+unidadesPorArticulo(a)));
    }
    private void cinco(){
        int contador;
        ArrayList<Cliente> clienteNuncaPedido= new ArrayList();
        for (Cliente c : clientes.values()) {
            contador=0;
            for (Pedido p : pedidos) {
                if (c.getIdCliente().equalsIgnoreCase(p.getClientePedido().getIdCliente())) {
                    contador++;
                }
            }
            if (contador==0) {
            clienteNuncaPedido.add(c); 
            }
        }
        System.out.println("Listado de clientes sin pedido: ");
        System.out.println(clienteNuncaPedido);
    }
    private int unidadesPorArticulo(Articulo a){
        int total=0;
        for (Pedido p : pedidos) {
            for (LineaPedido l : p.getCestaCompra()) {
                if (l.getArticulo().equals(a)) {
                    total+=l.getUnidades();
                }
            }        
        }
        
        return total;
    }
//</editor-fold>
}
