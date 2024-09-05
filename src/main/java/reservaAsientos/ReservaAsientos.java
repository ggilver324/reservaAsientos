package reservaAsientos;

import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args){

        //declaración de variables
        char asientos[][] = new char[10][10];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila=0, asiento=0;
        String respuesta;
        String verMapa;

        //cargamos la matriz
        for(int f = 0 ; f < 10; f++){
            for(int c = 0; c < 10; c++){
                asientos[f][c] = 'L';
            }
        }

        //
        System.out.println("----------------- BIENVENIDOS AL SISTEMA DE RESERVAS -----------------");

        while(bandera != true) {
            System.out.println("¿Desea ver los asientos disponibles? S: si, Cualquier tecla No.");
            //acá vamos a llamar el metodo
            verMapa = teclado.next();

            if (verMapa.equalsIgnoreCase("S")){
            dibujarMapa(asientos);
            }

            boolean estaOk = false;
            while (estaOk != true){
            System.out.println("");
            System.out.println("Ingrese Fila y Asiento a reservar");
            System.out.print("Fila (entre 0 y 9):");
            fila = teclado.nextInt();

            System.out.print("Asiento (entre 0 y 9):");
            asiento = teclado.nextInt();

                if (fila <= 9 && fila >= 0){
                    if(asiento <= 9 && asiento >= 0){
                        estaOk = true;
                    } else {
                        System.out.println("El número de asiento no es valido");
                    }
                } else {
                    System.out.println("El número de fila no es valido");
                }

            }

            if (asientos[fila][asiento] == 'L'){
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento ha sido reservado correctamente");
            } else {
                System.out.println("El asiento esta ocupado, por favor elija otro");
            }

            System.out.println("¿Desea finalizar la reserva? S: si, Cualquier otra letra No.");
            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("S")){
                bandera = true;
            }

        }

    }

    public static void dibujarMapa(char asientos[][]){
        for(int f = 0 ; f < 10; f++){
            System.out.print(f + "=> ");
            for(int c = 0; c < 10; c++){
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }

    }
}
