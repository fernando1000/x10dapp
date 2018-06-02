package br.com.x10d.app.util;

import java.io.File;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class GeraPDF {
	
	private Font font_titulo;
	protected Font font_conteudo;
	private float TAMANHO_FONTE_TITULO = 13;
	private float TAMANHO_FONTE_CONTEUDO = 12;
	private TextoContratos textoContratos;

	public GeraPDF(){
		textoContratos = new TextoContratos();
		font_titulo = new Font(FontFamily.TIMES_ROMAN, TAMANHO_FONTE_TITULO, Font.BOLD);
		font_conteudo = new Font(FontFamily.TIMES_ROMAN, TAMANHO_FONTE_CONTEUDO);
	}
	
	public void criaPDF(String SRC_CONTRATO, String comodosDaCasa, String ruaNumeroCasa, 
			String nomeCompleto, String rg, String cpf,
			String dataInicioLocacao, String dataTerminoLocacao,
			String diaPagamentoAluguel, String valorAluguel) throws Exception {
    	
    	File file = new File(SRC_CONTRATO);
    	
    	if(!file.exists()){
    		file.getParentFile().mkdirs();  	
    	}
    	     
    	float margemEsquerda = 30;
    	float margemDireita = 60;
    	float margemEmCima = 60;
    	float margemEmBaixo = 40;
    	
    	Document document = new Document();
    			 document.setMargins(margemEsquerda, margemDireita, margemEmCima, margemEmBaixo);
    	
    	PdfWriter.getInstance(document, new FileOutputStream(SRC_CONTRATO));
    			  
        document.open();    
	        	
        document.add(devolveTitulo("CONTRATO DE LOCAÇÃO RESIDENCIAL\r\n"));
        document.add(devolveConteudo(textoContratos.devolveContratoPadrao(comodosDaCasa, ruaNumeroCasa, nomeCompleto, rg, cpf, dataInicioLocacao, dataTerminoLocacao, diaPagamentoAluguel, valorAluguel)));
        document.add(devolveData());	
    
        document.close();        
    }
			
    private Paragraph devolveConteudo(String conteudo){
    	
    	Paragraph paragraph_conteudo1 = new Paragraph(conteudo, font_conteudo);
				  paragraph_conteudo1.setAlignment(Element.ALIGN_JUSTIFIED);
     return paragraph_conteudo1;
    }
    
    private Paragraph devolveTitulo(String titulo){
		
    	Paragraph paragraph_tituloPrincipal = new Paragraph(titulo, font_titulo);
		  		  paragraph_tituloPrincipal.setAlignment(Element.ALIGN_CENTER);			  
       return paragraph_tituloPrincipal;
    }

    private Paragraph devolveData(){

    	Paragraph paragraph_dataAtual = new Paragraph(textoContratos.devolveDataAtualFormatada() + "\n\n\n\n\n", font_conteudo);
		 		  paragraph_dataAtual.setAlignment(Element.ALIGN_RIGHT);    	
	  return paragraph_dataAtual;	 		  
    }
    
}
