package View;

import java.util.concurrent.Semaphore;

import Controller.carroCruzamento;

public class Main {

	public static void main(String[] args) {
		String[] sentidos = { "Norte para o Sul", "Leste para o Oeste", "Oeste para o Leste", "Sul para o Norte" };
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		for (int idcarro = 1; idcarro <= 4; idcarro++) {
		carroCruzamento carro = new carroCruzamento(sentidos[idcarro - 1], idcarro, semaforo);
			carro.start();
		}

}
}