package TipoExamen.MaquinaExpendedora;

import java.util.ArrayList;
import java.util.Scanner;

public class MaquinaExpendedora {
    // Variables
    private ArrayList<Articulo> articulos;

    // Constructor
    public MaquinaExpendedora(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    // Getters & setters
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    // Metodos
    public void load() {
        articulos.add(new Juguete("juguete", "J", 1.23));
        articulos.add(new Tabaco("tabaco", "T", 1.23));
        articulos.add(new Salado("salado", "S", 1.23, 100));
        articulos.add(new Dulce("dulce", "D", 1.23, 200));
        articulos.add(new Bebida("bebida", "B", 1.23, 0, 0));
    }

    public void start() {
        int eleccion = -1;
        
        do {
           eleccion = menu();
        } while (eleccion != 0);
        System.out.println("Gracias por su compra!");
    } 
    
    public int menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("### Bienvenido a Mercadona ###");
        System.out.println("1. Ver articulos");
        System.out.println("2. Comprar articulo");
        System.out.println("3. Introducir articulo");
        System.out.println("4. Poner al dia");
        System.out.println("5. Caducar consumibles");
        System.out.println("0. Salir");

        System.out.println("Introduzca una opcion:");
        int eleccion = sc.nextInt();

        if(eleccion == 1) {
            verArticulos(articulos);
        } else if(eleccion == 2) {
            comprarArticulo();
        } else if(eleccion == 3) {
            insertarArticulo();
        } else if(eleccion == 4) {
            actualizarArticulos();
        } else if(eleccion == 5) {
            comprobarArticulos();
            System.out.println("Se han comprobados los articulos");
            verArticulos(articulos);
        }

        return eleccion;
    }

    public void verArticulos(ArrayList<Articulo> articulos) {
        for(Articulo a : articulos) {
            System.out.println(a);
        }
    }

    public void comprarArticulo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que articulo quieres comprar: ");
        int articuloCompra = sc.nextInt();

        System.out.println("Cuanto dinero tienes: ");
        double dineroComprador = sc.nextInt();

        if(dineroComprador >= articulos.get(articuloCompra - 1).getPrecio()) {
            double aux = articulos.get(articuloCompra - 1).getPrecio() - dineroComprador;
            System.out.println(articulos.get(articuloCompra - 1).usar());

            articulos.remove(articulos.get(articuloCompra - 1));
        } else {
            System.out.println("No tienes dinero suficiente.");
        }
    }

    public void insertarArticulo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Que tipo de articulo es: ");
        System.out.println("1. Juguete");
        System.out.println("2. Tabaco");
        System.out.println("3. Salado");
        System.out.println("4. Dulce");
        System.out.println("5. Bebida");

        System.out.println("Introduzca una opcion:");
        int eleccion = sc.nextInt();
        
        if(eleccion == 1) {
            System.out.println("Nombre: ");
            String nombre = sc.next();

            System.out.println("Codigo: ");
            String codigo = sc.next();

            System.out.println("Precio: ");
            double precio = sc.nextDouble();

            articulos.add(new Juguete(nombre, codigo, precio));

        } else if (eleccion == 2) {
            System.out.println("Nombre: ");
            String nombre = sc.next();

            System.out.println("Codigo: ");
            String codigo = sc.next();

            System.out.println("Precio: ");
            double precio = sc.nextDouble();

            articulos.add(new Tabaco(nombre, codigo, precio));
        } 
        else if(eleccion == 3) {
            System.out.println("Nombre: ");
            String nombre = sc.next();

            System.out.println("Codigo: ");
            String codigo = sc.next();

            System.out.println("Precio: ");
            double precio = sc.nextDouble();

            System.out.println("Nutrientes: ");
            double nutrientes = sc.nextDouble();

            articulos.add(new Salado(nombre, codigo, precio, nutrientes));

        } else if(eleccion == 4) {
            System.out.println("Nombre: ");
            String nombre = sc.next();

            System.out.println("Codigo: ");
            String codigo = sc.next();

            System.out.println("Precio: ");
            double precio = sc.nextDouble();

            System.out.println("Nutrientes: ");
            double grasas = sc.nextDouble();

            articulos.add(new Dulce(nombre, codigo, precio, grasas));

        } else if(eleccion == 5) {
            System.out.println("Nombre: ");
            String nombre = sc.next();

            System.out.println("Codigo: ");
            String codigo = sc.next();

            System.out.println("Precio: ");
            double precio = sc.nextDouble();

            System.out.println("Nutrientes: ");
            double nutrientes = sc.nextDouble();

            System.out.println("Nutrientes: ");
            double grasas = sc.nextDouble();

            articulos.add(new Bebida(nombre, codigo, precio, nutrientes, grasas));
        }
    }

    public void actualizarArticulos() {
        for(Articulo a : articulos) {
            if(a instanceof Bebida) {
                Bebida b = (Bebida)a;
                if (b.isCaducado() == true) {
                    articulos.remove(b);
                }

            } else if(a instanceof Salado) {
                Salado s = (Salado)a;
                if (s.isCaducado() == true) {
                    articulos.remove(s);
                }
                
            } else if(a instanceof Dulce) {
                Dulce d = (Dulce)a;
                if (d.isCaducado() == true) {
                    articulos.remove(d);
                }
            }
        }
    }

    public void comprobarArticulos() {
        for(Articulo a : articulos) {
            if(a instanceof Bebida) {
                Bebida b = (Bebida)a;
                b.caducar();

            } else if(a instanceof Salado) {
                Salado s = (Salado)a;
                s.caducar();
                
            } else if(a instanceof Dulce) {
                Dulce d = (Dulce)a;
                d.caducar();
            }
        }
    }
    
}
