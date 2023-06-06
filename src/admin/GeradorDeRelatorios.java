package admin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import passageiro.Corrida;
import passageiro.Passageiro;
import usuario.Usuario;

public class GeradorDeRelatorios {

	public void obterSolicitacoesDeCorrida(CentralDeInformacoes informacoes) {

		Document doc = new Document(PageSize.A4);
		Date data = new Date();
		String solicitacaoHora = new SimpleDateFormat("HH:mm:ss").format(data);
		String solicitacaoData = new SimpleDateFormat("dd/MM/yyyy").format(data);

		try {

			OutputStream os = new FileOutputStream("relatorio.pdf");
			PdfWriter.getInstance(doc, os);

			doc.open();

			Paragraph p = new Paragraph(new Phrase("Relatório"));
			p.setAlignment(Element.ALIGN_CENTER);

			PdfPCell celula = new PdfPCell(p);
			celula.setColspan(2);

			Paragraph horarioSoliticacao = new Paragraph("Horário da solicitação: " + solicitacaoHora);
			Paragraph dataSolicitacao = new Paragraph("Data: " + solicitacaoData);

			PdfPTable tabela = new PdfPTable(2);
			PdfPCell cabecalhoPassageiro = new PdfPCell(new Paragraph("Passageiro"));
			PdfPCell cabecalhoCorrida = new PdfPCell(new Paragraph("N° Corridas"));
			// cabecalho.setColspan(1);
			cabecalhoPassageiro.setBackgroundColor(BaseColor.GREEN);
			cabecalhoCorrida.setBackgroundColor(BaseColor.YELLOW);

			tabela.addCell(celula);
			tabela.addCell(cabecalhoPassageiro);
			tabela.addCell(cabecalhoCorrida);

			int numeroCorridas;
			for (Usuario ps : informacoes.getTodosOsUsuarios()) {//alteracao feita aq

				numeroCorridas = informacoes.recuperarCorridasDeUmPassageiro(ps.getEmail()).size();
				tabela.addCell(ps.getNome());
				tabela.addCell(String.valueOf(numeroCorridas));

			}

			doc.add(tabela);
			doc.add(horarioSoliticacao);
			doc.add(dataSolicitacao);

			doc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException c) {
			c.printStackTrace();
		}
	}

	public static void obterSolicitacaoDeCorrida(Passageiro passageiro) {

		Document doc = new Document(PageSize.A4);
		Date data = new Date();
		String solicitacaoHora = new SimpleDateFormat("HH:mm:ss").format(data);
		String solicitacaoData = new SimpleDateFormat("dd/MM/yyyy").format(data);

		try {

			OutputStream os = new FileOutputStream("relatorioPassageiro.pdf");
			PdfWriter.getInstance(doc, os);

			doc.open();

			Paragraph p = new Paragraph(new Phrase("Relatório de " + passageiro.getNome()));
			p.setAlignment(Element.ALIGN_CENTER);

			PdfPCell celula = new PdfPCell(p);
			celula.setColspan(3);

			Paragraph horarioSoliticacao = new Paragraph("Horário da solicitação: " + solicitacaoHora);
			Paragraph dataSolicitacao = new Paragraph("Data: " + solicitacaoData);

			PdfPTable tabela = new PdfPTable(3);

			PdfPCell cabecalhoPassageiro = new PdfPCell(new Paragraph("ID"));
			PdfPCell cabecalhoCorrida = new PdfPCell(new Paragraph("Rota"));
			PdfPCell cabecalhoCorrida2 = new PdfPCell(new Paragraph("Data / hora"));

			// cabecalho.setColspan(1);
			cabecalhoPassageiro.setBackgroundColor(BaseColor.GREEN);
			cabecalhoCorrida.setBackgroundColor(BaseColor.YELLOW);
			cabecalhoCorrida2.setBackgroundColor(BaseColor.GREEN);

			tabela.addCell(celula);
			tabela.addCell(cabecalhoPassageiro);
			tabela.addCell(cabecalhoCorrida);
			tabela.addCell(cabecalhoCorrida2);

			Persistencia per = new Persistencia();
			CentralDeInformacoes central = per.recuperarCentral();

			//int numeroCorridas;
			for (Corrida corrida : central.recuperarCorridasDeUmPassageiro(passageiro.getEmail())) {

				tabela.addCell(String.valueOf(corrida.getId()));
				tabela.addCell(corrida.getEnderecoPartida() + " para " + corrida.getEnderecoDestino());

				String horario = new SimpleDateFormat("hh:MM:ss").format(corrida.getDadosSolicitacao());
				String dia = new SimpleDateFormat("dd/MM/yyyy").format(corrida.getDadosSolicitacao());

				tabela.addCell(dia + " " + horario);

			}

			doc.add(tabela);
			doc.add(horarioSoliticacao);
			doc.add(dataSolicitacao);

			doc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException c) {
			c.printStackTrace();
		}

	}

}
