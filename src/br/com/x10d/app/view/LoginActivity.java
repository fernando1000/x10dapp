package br.com.x10d.app.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import br.com.x10d.app.R;
import br.com.x10d.app.util.TelaBuilder;
import br.com.x10d.app.webservice.AutenticacaoWS;

@SuppressLint("InlinedApi")
public class LoginActivity extends Activity {

	private Context context;	
	private AutenticacaoWS autenticacaoWS;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		context = LoginActivity.this;
		
		autenticacaoWS = new AutenticacaoWS(context);
				
		//ActionBar bar = getActionBar();
				  //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(getString(R.color.azul_consigaz))));

				  
		TelaBuilder meusWidgetsBuilder = new TelaBuilder(context);
				
		LinearLayout llTela = meusWidgetsBuilder.criaLinearLayoutTELA();
		llTela.setBackgroundColor(Color.WHITE);
				//context.getResources().getColor(R.color.azul_claro_consigaz));

		TextView textView_usuario = meusWidgetsBuilder.criaTextViewTITULO("Usuário:");

        final EditText editText_usuario = meusWidgetsBuilder.criaEditText("");

		TextView textView_senha = meusWidgetsBuilder.criaTextViewTITULO("Senha:");

        final EditText editText_senha = meusWidgetsBuilder.criaEditText("");
        			   editText_senha.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
			        	     
        LayoutParams lp_MATCH_WRAP = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			
					 lp_MATCH_WRAP.setMargins(0, 20, 0, 0);		

		Button button_entrar = meusWidgetsBuilder.criaBotao("Entrar", lp_MATCH_WRAP);	
		button_entrar.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
							
			acaoAposCliqueNoBotaoEntrar(editText_usuario, editText_senha);
			}
		});
		
	    ImageView imageView = new ImageView(context);				    
			      imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.cc));
			  	     LayoutParams lp_WRAP_WRAP = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			
			  		 			  lp_WRAP_WRAP.setMargins(0, 60, 0, 60);		
	    imageView.setLayoutParams(lp_WRAP_WRAP);

			      
			      
		llTela.addView(imageView);
		llTela.addView(textView_usuario);
		llTela.addView(editText_usuario);
		llTela.addView(textView_senha);
		llTela.addView(editText_senha);	
		llTela.addView(button_entrar);
					
		setContentView(llTela);		
	}
		
	private void acaoAposCliqueNoBotaoEntrar(EditText editText_usuario, EditText editText_senha){
		
		String usuario = editText_usuario.getText().toString();

		String senha = editText_senha.getText().toString();

		if (usuario.equals("")) {

			Toast.makeText(context, "Informe o usuário", Toast.LENGTH_SHORT).show();
		}
		else if (senha.equals("")) {

			Toast.makeText(context, "Informe a senha", Toast.LENGTH_SHORT).show();
		} 
		else {
			
			autenticacaoWS.buscaUsuarioWS(usuario, senha);
		}
	}
			
	/*
	private void abreDashboard() {
				
		Intent intent = new Intent(LoginActivity.this, ActivityDashboard.class);
		startActivity(intent);
		finish();
	}
	*/
	
}
