
public class Carretera {
    public Carretera(String Nombre,int[] carros){
        super();
        this.Nombre = Nombre;
        this.Carros = carros;
    }
    private String Nombre;
    private int[] Carros;
    
    public String getNombre(){
        return Nombre;
    }
    public void setNombre(String nombre){
        this.Nombre = nombre;
    }
    public int[] getCarros(){
        return Carros;
    }
    public void setCarros(int[] carros){
        this.Carros = carros;
    }
}
