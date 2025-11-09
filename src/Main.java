import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char opcion = '1';
        double paraConvertir = 0.0;

        //Darle formato a la salida de mi conversión
        DecimalFormat df = new DecimalFormat("####0.00");

        Conversor conversor = new Conversor();
        Scanner sc = new Scanner(System.in); // Crea un objeto Scanner
        while(opcion != '9'){
            //Desplegar el menu
            System.out.println("Bienvenido al sistema de converisón de moneas");
            System.out.println("1.- Dolar Estadounidense[USD] -> Peso Argentino[ARS]");
            System.out.println("2.- Peso Argentino[ARS] -> Dolar Estadounidense[USD]");
            System.out.println("3.- Dolar Estadounidense[USD] -> Real Brasileño[BRL]");
            System.out.println("4.- Real Brasileño[BRL] -> Dolar Estadounidense[USD]");
            System.out.println("5.- Dolar Estadounidense[USD] -> Peso Colombiano[COP]");
            System.out.println("6.- Peso Colombiano[COP] -> Dolar Estadounidense[USD]");
            System.out.println("7.- Dolar Estadounidense[USD] -> Peso Mexicano[MXN]");
            System.out.println("8.- Peso Mexicano[MXN] -> Dolar Estadounidense[USD]");
            System.out.println("9.- Salir");
            System.out.println("Seleccione una opción:");
            String entrada = sc.next(); // Lee la entrada completa como una cadena
            opcion = entrada.charAt(0); // Obtiene el primer carácter de la cadena
            int ascii = (int) opcion;
            if(ascii >= 49 && ascii <= 56){
                System.out.println("Ingrese el valor para convertir: ");
                paraConvertir = sc.nextDouble();
                conversor.upodateData(Request.getConversiones());
            }
            switch(opcion){
                case '1':
                    System.out.println("El valor " + paraConvertir + "[USD] equivale a -> " + df.format(conversor.getFromUSDtoARS(paraConvertir)) + "[ARS]");
                    break;
                case '2':
                    System.out.println("El valor " + paraConvertir + "[ARS] equivale a -> " + df.format(conversor.getFromARStoUSD(paraConvertir)) + "[USD]");
                    break;
                case '3':
                    System.out.println("El valor " + paraConvertir + "[USD] equivale a -> " + df.format(conversor.getFromUSDtoBRL(paraConvertir)) + "[BRL]");
                    break;
                case '4':
                    System.out.println("El valor " + paraConvertir + "[BRL] equivale a -> " + df.format(conversor.getFromBRLtoUSD(paraConvertir)) + "[USD]");
                    break;
                case '5':
                    System.out.println("El valor " + paraConvertir + "[USD] equivale a -> " + df.format(conversor.getFromUSDtoCOP(paraConvertir)) + "[COP]");
                    break;
                case '6':
                    System.out.println("El valor " + paraConvertir + "[COP] equivale a -> " + df.format(conversor.getFromCOPtoUSD(paraConvertir)) + "[USD]");
                    break;
                case '7':
                    System.out.println("El valor " + paraConvertir + "[USD] equivale a -> " + df.format(conversor.getFromUSDtoMXN(paraConvertir)) + "[MXN]");
                    break;
                case '8':
                    System.out.println("El valor " + paraConvertir + "[MXN] equivale a -> " + df.format(conversor.getFromMXNtoUSD(paraConvertir)) + "[USD]");
                    break;
                case '9':
                    System.out.println("Muchas gracias por usar el sistema, adios");
                    break;
                default:
                    System.out.println("Opción incorrecta, favor de ingresar un número del 1 al 9");
            }

        }
        sc.close();


    }
}