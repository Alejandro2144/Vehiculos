import java.io.File;
import java.util.Scanner;
class Principal{

    public static void main(String[] args){
        System.out.println("Ingrese 0 para cerrar el programa");
        System.out.println("Ingrese 1 para crear un vehiculo");
        System.out.println("Ingrese 2 para imprimir la informacion de todos los vehiculos almacenados");
        System.out.println("Ingrese 3 para impimir la cantidad de vehiculos almacenados");
        System.out.println("Ingrese 4 para impimir la informacion de vehiculos verdes almacenados");
        System.out.println("Ingrese 5 para impimir la informacion de un vehiculo por id");
        System.out.println("Ingrese 6 para agregar un sensor a un vehiculo por id");
        System.out.println("Ingrese 7 para imprimir la informacion de los sensores de un vehiculo por id");
        System.out.println("Ingrese 8 para imprimir la informacion de todos los sensores de temperatura");
        System.out.println("Ingrese 9 para imprimir la informacion de el vehiculo con mas sensores");
        System.out.println("Ingrese 10 para crear vehiculos con la informacion de un archivo");
        System.out.println("Ingrese 666 para imprimir la informacion de sensores de temperatura organizados de menor a mayor valor");
        Principal.mostrarMenu();
    }

    public static void mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        double valorDoble = 0.0;
        Vehiculo auto;
        Sensor senso;
        String str = "";

        while(true){
            System.out.print("Ingrese un numero:");
            num = scanner.nextInt();
            if(num == 0){
                break;
            }
            if(num == 1){
                auto = new Vehiculo();
                System.out.print("Ingrese un modelo: ");
                num = scanner.nextInt();
                auto.setModelo(num);
                System.out.print("Ingrese una marca: ");
                str = scanner.next();
                auto.setMarca(str);
                System.out.print("Ingrese un valor: ");
                valorDoble = scanner.nextDouble();
                auto.setValorComercial(valorDoble);
                System.out.print("Ingrese un color: ");
                str = scanner.next();
                auto.setColor(str);
                System.out.println("Se ha creado un nuevo vehiculo.");
            }
            else if (num == 2){
                System.out.println("Informacion de todos los vehículos almacenados: ");
                System.out.println(Vehiculo.toStringVehiculos());
            } 
            else if (num == 3){
                System.out.println("Informacion de la cantidad de vehículos almacenados:");
                System.out.println(Vehiculo.cantidadVehiculos());
            }
            else if(num == 4){
                System.out.println("Informacion de los vehículos verdes almacenados:");
                for(Vehiculo v: Vehiculo.getVehiculosVerdes()){
                    System.out.println(v);
                }
            }

            else if (num == 5){
                System.out.print("Ingrese un id: ");
                num = scanner.nextInt();
                if(Vehiculo.cantidadVehiculos() >= num){
                    System.out.println("Informacion del vehiculo " + num);
                    System.out.println(Vehiculo.obtenerVehiculoPorId(num));
                }
                else{
                    System.out.print("No existe un vehiculo con esa id");
                }
            }
            else if (num == 6){ 
                System.out.print("Ingrese un id: ");
                num = scanner.nextInt();
                if(Vehiculo.cantidadVehiculos() >= num){
                    senso = new Sensor();
                    System.out.print("Ingrese un tipo: ");
                    str = scanner.next();
                    senso.setTipo(str);
                    System.out.print("Ingrese un valor: ");
                    valorDoble = scanner.nextDouble();
                    senso.setValor(valorDoble);
                    Vehiculo.obtenerVehiculoPorId(num).anadirSensor(senso);
                    System.out.println("Se le ha añadido un sensor al vehiculo " + num);
                }
                else{
                    System.out.print("No existe un vehiculo con esa id");
                }
            }
            else if(num == 7){
                System.out.print("Ingrese un id: ");
                num = scanner.nextInt();
                if(Vehiculo.cantidadVehiculos() >= num){
                    System.out.println("Información de todos los sensores del vehiculo " + num + ": ");
                    System.out.println(Vehiculo.obtenerVehiculoPorId(num).getSensores());
                }
                else{
                    System.out.print("No existe un vehiculo con esa id");
                }
            }

            else if (num == 8){
                System.out.println("Informacion de sensores de temperatura:");
                for (Sensor s: Sensor.getSensoresTemperatura()){
                    System.out.println(s);
                }
            }
            else if(num == 9){
                System.out.println(Vehiculo.getMaxSensores());
            }
            else if(num == 10){
                Principal.crearVehiculosDesdeArchivo("vehiculos.txt");
                System.out.println("Se han creado nuevos vehiculos segun vehiculos.txt");
            }
            else if(num == 666){
                System.out.println("Informacion de sensores de temperatura organizados de menor a mayor valor:");
                for(Sensor s: Sensor.metodo666()){
                    System.out.println(s);
                }
            }
        }
    }

    public static void crearVehiculosDesdeArchivo(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        Scanner scanner = null;
        String linea;
        String[] datos;
        try{
            scanner = new Scanner(archivo);
            while(scanner.hasNextLine()){
                linea = scanner.nextLine();
                datos = linea.split(",");
                Vehiculo vehiculo = new Vehiculo(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), datos[3]);
            }
        }
        catch(Exception e){
            System.out.println("No se ha encontrado el archivo");
        }
    }
}