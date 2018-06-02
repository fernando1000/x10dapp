package br.com.x10d.app.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.LinearLayout.LayoutParams;
import br.com.x10d.app.R;
import br.com.x10d.app.util.AcaoSairDoAplicativo;
import br.com.x10d.app.util.MeuAlerta;
import br.com.x10d.app.util.TelaBuilder;

@SuppressLint("NewApi")
public class DashboardActivity extends Activity {

	private Context context;
	private static final int MENU_ITEM_ITEM1 = 1;
	private static final int MENU_ITEM_ITEM2 = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = DashboardActivity.this;
		
		setContentView(devolveTelaInicial());
	}
	
	private ScrollView devolveTelaInicial() {
		
		
		TelaBuilder telaBuilder = new TelaBuilder(context);
		
		ScrollView scrollView = telaBuilder.criaScrollView();
		scrollView.setBackgroundColor(Color.WHITE);
			
		LinearLayout llTela = telaBuilder.criaLinearLayoutTELA();
		llTela.setOrientation(LinearLayout.HORIZONTAL);
		llTela.setBackgroundColor(Color.WHITE);

		LayoutParams lp_colunaEsquerda = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.50f);
		LayoutParams lp_colunaDireita = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT, 0.50f);
		
		LinearLayout llColunaEsquerda = telaBuilder.criaLinearLayoutColuna(lp_colunaEsquerda);
				     llColunaEsquerda.addView(telaBuilder.criaLinearLayoutImageViewTextView(getResources().getDrawable(R.drawable.ic_people_black_24dp), "Clientes"));
				     llColunaEsquerda.addView(telaBuilder.criaLinearLayoutImageViewTextView(getResources().getDrawable(R.drawable.ic_schedule_black_24dp), "Agendas"));

		llTela.addView(llColunaEsquerda);
	
		LinearLayout llColunaDireita = telaBuilder.criaLinearLayoutColuna(lp_colunaDireita);
		LinearLayout linearLayoutNegocios = telaBuilder.criaLinearLayoutImageViewTextView(getResources().getDrawable(R.drawable.ic_business_black_24dp), "Negócios");
					 linearLayoutNegocios.setOnClickListener(new View.OnClickListener() {
						 	@Override
						 	public void onClick(View v) {
						 		
								startActivity(new Intent(context, NegociosActivity.class));						
							}
					 	});
						
					 llColunaDireita.addView(linearLayoutNegocios);
					 
					 llColunaDireita.addView(telaBuilder.criaLinearLayoutImageViewTextView(getResources().getDrawable(R.drawable.ic_settings_black_24dp), "Configuração"));

		llTela.addView(llColunaDireita);
		
		scrollView.addView(llTela);

		return scrollView;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		menu.add(Menu.NONE, MENU_ITEM_ITEM1, Menu.NONE, "Perfil");
		menu.add(Menu.NONE, MENU_ITEM_ITEM2, Menu.NONE, "Sair");
		
	    return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
	    switch (item.getItemId()) {
	    
	    	case MENU_ITEM_ITEM1: mostraPerfil();
	    		return true;

	    	case MENU_ITEM_ITEM2: sairDoAplicativo();
    			return true;

	    	default:
	    		return false;
	    }
	}
		
	@Override
	public void onBackPressed() {

		sairDoAplicativo();		
	}
	
	private void sairDoAplicativo() {
		
		AcaoSairDoAplicativo acaoSairAplicativo = new AcaoSairDoAplicativo(DashboardActivity.this);
		
		new MeuAlerta("Sair", "Deseja sair do aplicativo?", context).meuAlertaSimNao(acaoSairAplicativo);
	}
	
	private void mostraPerfil() {
		
	}
	

}
