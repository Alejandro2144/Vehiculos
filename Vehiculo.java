import java.util.ArrayList;
public class Vehiculo{

    // fields
    public static ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    public static int idActual = 1;
    private int id;
    private int modelo;
    private ArrayList<Sensor> sensores = new ArrayList<Sensor>();
    private String marca;
    private double valorComercial;
    private String color;

    public static int tamano = 10;
    public static int posAnadir = 0;

    // constructors
    public Vehiculo(){
        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;
        this.vehiculos.add(this);
    }

    public Vehiculo(int mo, String ma, double va){
        this(mo, ma, va, "verde");
    }

    public Vehiculo(int mo, String ma, double va, String co){
        this.id = Vehiculo.idActual;
        Vehiculo.idActual++;

        this.modelo = mo;
        this.marca = ma;
        this.valorComercial = va;
        this.color = co;

        this.vehiculos.add(this);
    }

    // methods
    public String toString(){
        String info = String.valueOf(this.id) +"," + String.valueOf(this.modelo) + "," + this.marca + "," + String.valueOf(this.valorComercial) + "," + this.color;
        for(Sensor sensor: this.sensores){
            info = info + "," + "[" +  sensor.toString() + "]";
        }
        return info;
    }

    public int cantidadSensores(){
        return this.sensores.size();
    }

    public void anadirSensor(Sensor s){
        this.sensores.add(s);
    }

    public static String toStringVehiculos(){
        String infototal = "";
        for(Vehiculo v: Vehiculo.vehiculos){
            if(v != null){
                infototal += "[" + v.toString() + "]";
            }
        }
        return infototal;
    }

    public static int cantidadVehiculos(){
        return Vehiculo.vehiculos.size();
    }

    public static int getIdActual(){
        return Vehiculo.idActual;
    }

    public static void setIdActual(int idAct){
        Vehiculo.idActual = idAct;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public ArrayList<Sensor> getSensores(){
        return this.sensores;
    }

    public void setSensores(ArrayList<Sensor> sensores){
        this.sensores = sensores;
    }

    public int getModelo(){
        return this.modelo;
    }

    public void setModelo (int mo){
        this.modelo = mo;
    }

    public String getMarca(){
        return this.marca;
    }

    public void setMarca (String ma){
        this.marca = ma;
    }

    public double getValorComercial(){
        return this.valorComercial;
    }

    public void setValorComercial (double va){
        this.valorComercial = va;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor (String co){
        this.color = co;
    }

    public static ArrayList<Vehiculo> getVehiculosVerdes(){
        String color;
        ArrayList<Vehiculo> resultado = new ArrayList<Vehiculo>();
        for(int i = 0; i < Vehiculo.vehiculos.size(); i++){
            color = Vehiculo.vehiculos.get(i).getColor();
            if(color.equals("verde")){
                resultado.add(vehiculos.get(i));
            }
        }
        return resultado;
    }

    public static Vehiculo obtenerVehiculoPorId(int id){
        return Vehiculo.vehiculos.get(id - 1);
    }

    public static Vehiculo getMaxSensores(){
        int idMax = 1;
        for(int i = 1; i <= Vehiculo.vehiculos.size(); i++){
            if(Vehiculo.obtenerVehiculoPorId(i).cantidadSensores() > Vehiculo.obtenerVehiculoPorId(idMax).cantidadSensores()){
                idMax = i;
            }
        }
        return Vehiculo.obtenerVehiculoPorId(idMax);
    }

}