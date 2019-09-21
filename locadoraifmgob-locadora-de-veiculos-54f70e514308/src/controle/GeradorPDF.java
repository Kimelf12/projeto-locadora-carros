package controle;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dataAcess.DaoCarro;
import dataAcess.DaoDespesa;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.*;


/**
 * @author Augusto
 */

public abstract class GeradorPDF {
    
    public static void relatorioDiario (int dia, int mes, int ano) {
        try {
            gerarPDF("Relatorio" + ano + "-" + mes + "-" + dia + ".pdf", 
                     "Relatório - " + dia + "/" + mes + "/" + ano, 
                     DaoDespesa.getByDia(dia, mes, ano), 
                     DaoCarro.getList());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void relatorioMensal (int mes, int ano) {
        try {
            gerarPDF("Relatorio" + ano + "-" + mes + "-00.pdf", 
                     "Relatório - " + mes + "/" + ano, 
                     DaoDespesa.getByMes(mes, ano), 
                     DaoCarro.getList());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void relatorioAnual (int ano) {
        try {
            gerarPDF("Relatorio" + ano + "-00-00.pdf", 
                     "Relatório - " + ano, 
                     DaoDespesa.getByAno(ano), 
                     DaoCarro.getList());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private static void gerarPDF (String endereco, String titulo, ArrayList<Despesa> despesas, ArrayList<Carro> carros) throws Exception{
        Document doc = new Document(PageSize.A3, 72, 72, 72, 72);
        OutputStream os = new FileOutputStream(endereco);
        PdfWriter.getInstance(doc, os);
        doc.open();

        Paragraph p1 = new Paragraph(titulo + "\n\n\n");
        p1.setAlignment(Element.ALIGN_CENTER);
        doc.add(p1);

        //Despesas
        if (!despesas.isEmpty()) {
            PdfPTable table = new PdfPTable(6);

            Paragraph tit = new Paragraph("Despesas");
            tit.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cabecalho = new PdfPCell(tit);
            cabecalho.setColspan(6);
            table.addCell(cabecalho);

            table.addCell("ID");
            table.addCell("Descrição");
            table.addCell("Valor");
            table.addCell("Pago");
            table.addCell("Vencimento");
            table.addCell("Data de pagamento");

            float valorPago = 0, valorRestante = 0;

            for (int i = 0; i < despesas.size(); i++) {
                table.addCell(String.valueOf(despesas.get(i).getId()));
                table.addCell(despesas.get(i).getDescricao());
                table.addCell(String.valueOf(despesas.get(i).getValor()));
                table.addCell(despesas.get(i).isPago() ? "Sim" : "Não");
                table.addCell(Formatacao.formatarData(despesas.get(i).getVencimento()));
                table.addCell(despesas.get(i).isPago() ? Formatacao.formatarData(despesas.get(i).getDataPagamento()) : "-");
                valorPago += despesas.get(i).isPago() ? despesas.get(i).getValor() : 0;
                valorRestante += despesas.get(i).isPago() ? 0 : despesas.get(i).getValor();
            }
            doc.add(table);

            Paragraph p = new Paragraph("\nValor Pago: R$" + valorPago + ".\n");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

            p = new Paragraph("Valor restante: R$" + valorRestante + ".\n\n\n");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);

        } else {
            Paragraph p = new Paragraph("Não há despesas\n\n");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
        }

        //Carros
        if (!carros.isEmpty()) {
            PdfPTable table = new PdfPTable(6);

            Paragraph tit = new Paragraph("Carros");
            tit.setAlignment(Element.ALIGN_CENTER);
            PdfPCell cabecalho = new PdfPCell(tit);
            cabecalho.setColspan(6);
            table.addCell(cabecalho);

            table.addCell("Placa");
            table.addCell("Marca");
            table.addCell("Cor");
            table.addCell("Modelo");
            table.addCell("Ano");
            table.addCell("Valor Hora");

            for (int i = 0; i < carros.size(); i++) {
                table.addCell(String.valueOf(carros.get(i).getPlaca()));
                table.addCell(carros.get(i).getMarca());
                table.addCell(carros.get(i).getCor());
                table.addCell(carros.get(i).getModelo());
                table.addCell(String.valueOf(carros.get(i).getAno()));
                table.addCell(String.valueOf(carros.get(i).getValorHora()));
            }

            doc.add(table);
        } else {
            Paragraph p = new Paragraph("Não há carros alugados\n\n");
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
        }

        doc.close();
    }
    
}
