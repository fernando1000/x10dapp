package br.com.x10d.app.view;

import java.io.File;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import br.com.x10d.app.util.GeraPDF;
import br.com.x10d.app.util.TelaBuilder;

public class NegociosActivity extends Activity{

	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		context = NegociosActivity.this;
		
		TelaBuilder meusWidgetsBuilder = new TelaBuilder(context);
		
		ScrollView scrollView = new ScrollView(context); 
		scrollView.setBackgroundColor(Color.WHITE);

		LinearLayout llTela = meusWidgetsBuilder.criaLinearLayoutTELA();
		llTela.setBackgroundColor(Color.WHITE);

		final EditText etComodosDaCasa = meusWidgetsBuilder.criaEditText("");
		LinearLayout llLinhaComodosDaCasa = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Comodos Da Casa:", etComodosDaCasa);

        final EditText etRuaNumeroCasa = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaRuaNumeroCasa = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Rua, Número e Casa:", etRuaNumeroCasa);
    	
        final EditText etNomeCompleto = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaNomeCompleto = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Nome Completo:", etNomeCompleto);
    	
        final EditText etRG = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaRG = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("RG:", etRG);
    	
        final EditText etCPF = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaCPF = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("CPF:", etCPF);
    	
        final EditText etDataInicioLocacao = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaDataInicioLocacao = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Data Início Locação:", etDataInicioLocacao);
    	
        final EditText etDataTerminoLocacao = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaDataTerminoLocacao = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Data Término Locação:", etDataTerminoLocacao);
    	
        final EditText etDiaPagamentoAluguel = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaDiaPagamentoAluguel = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Dia do Pagamento do Aluguel:", etDiaPagamentoAluguel);
    	
        final EditText etValorAluguel = meusWidgetsBuilder.criaEditText("");
        LinearLayout llLinhaValorAluguel = meusWidgetsBuilder.criaLinearLayoutLinha_TV_ET("Valor do Aluguel:", etValorAluguel);
        
        LayoutParams lp_MATCH_WRAP = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			
					 lp_MATCH_WRAP.setMargins(0, 20, 0, 0);		

		Button button_gerarPDF = meusWidgetsBuilder.criaBotao("Gerar PDF", lp_MATCH_WRAP);	
		button_gerarPDF.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			 acaoAposCliqueNoBotaoGerarPDF(etComodosDaCasa.getText().toString(), etRuaNumeroCasa.getText().toString(),
					 						etNomeCompleto.getText().toString(), etRG.getText().toString(), etCPF.getText().toString(), 
					 						etDataInicioLocacao.getText().toString(), etDataTerminoLocacao.getText().toString(),
					 						etDiaPagamentoAluguel.getText().toString(), etValorAluguel.getText().toString());	
			}
		});
			      
		llTela.addView(llLinhaComodosDaCasa);	
		llTela.addView(llLinhaRuaNumeroCasa);
		llTela.addView(llLinhaNomeCompleto);
		llTela.addView(llLinhaRG);
		llTela.addView(llLinhaCPF);
		llTela.addView(llLinhaDataInicioLocacao);
		llTela.addView(llLinhaDataTerminoLocacao);
		llTela.addView(llLinhaDiaPagamentoAluguel);
		llTela.addView(llLinhaValorAluguel);
		
		llTela.addView(button_gerarPDF);
					
		scrollView.addView(llTela);
		
		setContentView(scrollView);
	}

	private void acaoAposCliqueNoBotaoGerarPDF(String comodosDaCasa, String ruaNumeroCasa, 
											   String nomeCompleto, String rg, String cpf,
											   String dataInicioLocacao, String dataTerminoLocacao,
											   String diaPagamentoAluguel, String valorAluguel){
															
		if (comodosDaCasa.equals("") 
				|| ruaNumeroCasa.equals("")
					|| nomeCompleto.equals("")
						|| rg.equals("")
							|| cpf.equals("")
								|| dataInicioLocacao.equals("")
									|| dataTerminoLocacao.equals("")
										|| diaPagamentoAluguel.equals("")
											|| valorAluguel.equals("")) {

			Toast.makeText(context, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
		} 
		else {
			
			criaArquivoPDF(comodosDaCasa, ruaNumeroCasa, 
						   nomeCompleto, rg, cpf,
						   dataInicioLocacao, dataTerminoLocacao,
						   diaPagamentoAluguel, valorAluguel);				  
		}
	}
	
	private void criaArquivoPDF(String comodosDaCasa, String ruaNumeroCasa, 
								String nomeCompleto, String rg, String cpf,
								String dataInicioLocacao, String dataTerminoLocacao,
								String diaPagamentoAluguel, String valorAluguel) {

		String srcContrato = Environment.getExternalStorageDirectory()+"/Contratos/"+nomeCompleto;	

		try {
		
		GeraPDF geraPDF = new GeraPDF();
				geraPDF.criaPDF(srcContrato+".pdf", comodosDaCasa, ruaNumeroCasa, 
													nomeCompleto, rg, cpf, 
													dataInicioLocacao, dataTerminoLocacao, 
													diaPagamentoAluguel, valorAluguel);
		
		Toast.makeText(context, "PDF gerado com sucesso!", Toast.LENGTH_SHORT).show();

		chamaVisualizadorPDF(srcContrato+".pdf");
		
		} 
		catch (Exception erro) {

			Toast.makeText(context, ""+erro, Toast.LENGTH_SHORT).show();

			erro.printStackTrace();
		}
	}
	
	public void chamaVisualizadorPDF(String caminhoComExtensao){
	     	
	   	String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(".pdf");
	   		   	
	   				   Intent intent = new Intent(Intent.ACTION_VIEW);
	   		   				  intent.setDataAndType(Uri.fromFile(new File(caminhoComExtensao)), mimeType);		
	   		   				  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	   	startActivity(intent);
	   	finish(); 
	}

}
