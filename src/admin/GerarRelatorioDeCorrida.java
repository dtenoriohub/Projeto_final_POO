package admin;

public class GerarRelatorioDeCorrida {

	public static void gerarRelatorioDeCorrida() {

		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral();

		GeradorDeRelatorios gerador = new GeradorDeRelatorios();
		gerador.obterSolicitacoesDeCorrida(central);
		System.out.println("Relatório gerado!!");

	}
}
