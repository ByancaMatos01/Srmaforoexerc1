package Controller;

import java.util.concurrent.Semaphore;

public class carroCruzamento extends Thread {

	private int idCarro;
	private String sentido;
	private Semaphore semaforo;

	public carroCruzamento(String sentido,  int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	public void run() {
		 carrocorre();
		 
		 //inicio da seção critica
		 try {
			 semaforo.acquire();
			 carrocruza();
		 }catch (Exception e) {
			 e.printStackTrace();
		 }finally {
			 //obriga a rodar
			 semaforo.release();
			//fim da seção critica
		 }
		 carropassando();
	}
	
	public void carrocorre() {
		int tempo = 1000;
		int distanciapercorrida = 0;
		
		while(distanciapercorrida < 100) {
			distanciapercorrida += (int) ((Math.random() * 5) + 10);
			try {
				Thread.sleep(tempo);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O Carro " + idCarro + " ja percorreu " + distanciapercorrida + " metros");
		}
	}
	
	private void carrocruza() {
		
		System.out.println("O carro " +idCarro +" parou no cruzamento");
		
		}
	
	private void carropassando() {
		System.out.println("O Carro cruzou do sentido " + sentido);
	

	}

}