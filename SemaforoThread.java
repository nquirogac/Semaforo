public class SemaforoThread extends Thread{
    public SemaforoThread(int numero, Carretera carretera, long initialTime, boolean go) {
	this.numero = numero;
	this.carretera = carretera;
	this.initialTime = initialTime;
        this.go = go;
	}

    private int numero;
    private Carretera carretera;
    private long initialTime;
    private boolean go;

    @Override
    public void run() {

	System.out.println("El semaforo " + this.numero + " corresponde a la carretera " 
                            + this.carretera.getNombre()); 

	for (int i = 0; i < this.carretera.getCarros().length;) { 
            if (go == true){
                
                System.out.println("El semaforo "+this.getNumero()+" esta en: VERDE");
                System.out.println("Paso el carro " + (i + 1) + " paso por el semaforo " + this.getNumero() +" en el segundo -> " 
                                    + ((System.currentTimeMillis() - this.initialTime) / 1000));
                this.esperar(1); 
                i++;
                if (i%5==0){
                    go = false;
                    System.out.println("El semaforo "+this.getNumero()+" esta en: AMARILLO"+" en el segundo -> " 
                                    + ((System.currentTimeMillis() - this.initialTime) / 1000));
                    this.esperar(1);
                    
                }
            }
            else{
                System.out.println("El semaforo "+this.getNumero()+" esta en: ROJO"+" en el segundo -> " 
                                    + ((System.currentTimeMillis() - this.initialTime) / 1000));
                this.esperar(5);
                System.out.println("El semaforo "+this.getNumero()+" esta en: AMARILLO"+" en el segundo -> " 
                                    + ((System.currentTimeMillis() - this.initialTime) / 1000));
                this.esperar(1);
                go = true;
            }
            
	}
    }

    private void esperar(int segundos) {
        try {
		Thread.sleep(segundos * 1000);
	} 
        catch (InterruptedException ex) {
       		Thread.currentThread().interrupt();
	}
    }
    

    
    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Carretera getCarretera() {
        return this.carretera;
    }

    public void setCarretera(Carretera carretera) {
        this.carretera = carretera;
    }

    public long getInitialTime() {
        return this.initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public boolean isGo() {
        return this.go;
    }

    public void setGo(boolean go) {
        this.go = go;
    }
    
}
