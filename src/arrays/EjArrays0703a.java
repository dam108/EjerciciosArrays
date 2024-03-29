package arrays;
import java.util.Scanner;

public class EjArrays0703a {
    public static Scanner teclado = new Scanner(System.in);
    public static Parking parking = new Parking();
    public static void main(String[] args) {
        int opcion;
        do {
            
            opcion = pedirOpcion();
            ejecutarOpcion(opcion);

        }while (opcion != 0 );
 
    }   // fin main
    
    public static int pedirOpcion(){
        System.out.println("-------------------------------------------------------");
        System.out.println("MENU PARKING");
        System.out.println("-------------------------------------------------------");
        System.out.println("1.- Aparcar:");
        System.out.println("2.- Consultar las matriculas de los coches aparcados");
        System.out.println("3.- Desaparcar");
        System.out.println("4.- Saber la cantidad de plazas libres");
        System.out.println("0.- Salir: ");
        System.out.println("-------------------------------------------------------");
        int opcion = teclado.nextInt();
        teclado.nextLine();
        return opcion;
        
    }
    public static void ejecutarOpcion(int opcion){
        
        switch(opcion){
            case 1:
                System.out.println("Introduce la matricula: ");
                String matricula = teclado.nextLine();
                boolean plaza = parking.aparcar(matricula);
                if (!plaza)System.out.println("El parking esta lleno\n");
                else {
                    System.out.println("Se a aparcado tu coche con exito.\n");
                    /* imprimimos las plazas ocupadas con las matriculas
                    System.out.println("Estado del parking: ");
                    estadoParking();*/
                }
                break;
             case 2:
                if (parking.plazasOcupadas() == 0) System.out.println("No hay coches en el parking");
                else estadoParking();
                break;
            case 3:
                System.out.println("Vamos a sacar el ultimo coche que entro al garaje");
                String matriculaRetirar = parking.desaparcar();
                if (!matriculaRetirar.equals("")) System.out.println("Se ha retirado el coche con la matricula: "+matriculaRetirar+"\n");
                else System.out.println("No hay ningun coche en el parking\n");
                break;
            case 4:
                int plazasLibres = parking.getPlazasLibres();
                System.out.println("El parking tiene "+plazasLibres+" plazas libres.\n");
                break;
        }
    }
    
    public static void estadoParking(){
        String [] matriculas = parking.getArrayParking();
        for (int i = parking.getPlazas() - 1; i >= 0; i--) {
            int numPlaza = parking.getPlazas() - i;
            String matricula = matriculas[i];
            if ( !matriculas[i].equals("") ) System.out.printf("La plaza %d esta ocupada por el coche %s.\n", numPlaza, matricula );
            //else System.out.printf("La plaza %d no esta ocupada por ningun coche.\n", numPlaza);
        }
        System.out.println("\n");
    }

}       // fin class
