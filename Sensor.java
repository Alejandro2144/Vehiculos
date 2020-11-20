import java.util.ArrayList;
public class Sensor{

    //fields
    private String tipo;
    private double valor;
    public static Sensor[] sensores = new Sensor[8];
    public static int tamano = 8;
    public static int posAnadir = 0;

    //constructors
    public Sensor(){
        this.sensores[this.posAnadir] = this;
        this.posAnadir ++;
    }

    public Sensor(int t, double v){
        this.tamano = t;
        this.valor = v;
        this.sensores[this.posAnadir] = this;
        this.posAnadir ++;
    }

    //methods
    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String t){
        this.tipo = t;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double v){
        this.valor = v;
    }

    public String toString(){
        String info = tipo + "," +  String.valueOf(this.valor);
        return info;
    }

    public static String toStringSensores(){
        String infoTotal = "";
        for(Sensor s: sensores){
            if(s != null){
                infoTotal += "[" + s + "]";
            }
        }
        return infoTotal;
    }

    public static int cantidadSensores(){
        return posAnadir;
    }

    public static ArrayList<Sensor> getSensoresTemperatura(){
        ArrayList<Sensor> resultado = new ArrayList<Sensor>();
        for(int i = 0; i < posAnadir; i++){
            if(sensores[i].getTipo().equals("temperatura")){
                resultado.add(sensores[i]);
            }
        }
        return resultado;
    }

    public static ArrayList<Sensor> metodo666(){
        ArrayList<Sensor> ordenado = Sensor.getSensoresTemperatura();
        Sensor temp;
        for(int i = 0; i < ordenado.size(); i++){
            for(int j = i + 1; j < ordenado.size(); j++){
                if(ordenado.get(i).getValor() > ordenado.get(j).getValor()){
                    temp = ordenado.get(i);
                    ordenado.set(i,ordenado.get(j));
                    ordenado.set(j,temp);
                }
            }
        }
        return ordenado;
    }
}