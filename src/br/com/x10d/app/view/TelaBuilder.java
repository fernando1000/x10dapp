package br.com.x10d.app.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import br.com.x10d.app.R;

public class TelaBuilder {

	private Context context;
	
	public TelaBuilder(Context _context){
		this.context = _context;
	}
		
	public TextView criaTextViewTITULO(String texto){
		
		TextView textView = new TextView(context);
		textView.setTextSize(20);
		textView.setTextColor(context.getResources().getColor(R.color.azul_consigaz)); 
		textView.setTypeface(textView.getTypeface(), Typeface.BOLD);
		textView.setText(texto);	

		return textView;
	}

	public TextView criaTextViewCONTEUDO(String texto){
		
		TextView textView = new TextView(context);
		textView.setTextSize(18);
		textView.setTextColor(Color.BLACK); 
		textView.setTypeface(textView.getTypeface(), Typeface.ITALIC);
		textView.setText(texto);	
		
		return textView;
	}
	public TextView criaTextViewCONTEUDO_qtds(){
		
		TextView textView = new TextView(context);
		textView.setTextSize(12);
		//textView.setTextColor(Color.BLACK); 
		
		return textView;
	}
	

	@SuppressLint("NewApi")
	public Button criaBotao(String texto, LayoutParams lllp){

		Button button = new Button(context);
		button.setBackground(context.getResources().getDrawable(R.drawable.style_btn_consigaz));
		button.setText(texto);
		button.setTextColor(Color.WHITE);
		button.setTextSize(24);
		button.setLayoutParams(lllp);

		return button;
	}

	@SuppressLint("NewApi")
	public EditText criaEditText(String texto){
	
	    EditText editText = new EditText(context);
	    editText.setTextSize(20);
	    editText.setBackground(context.getResources().getDrawable(R.drawable.style_edit_consigaz));    		  
	    editText.setText(texto);
	    
	    return editText;
	}

	@SuppressLint("NewApi")
	public EditText criaEditTextleituraAtual(String texto){
		
		LayoutParams lp_MATCH_WRAP = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			

	    EditText editText = new EditText(context);
	    editText.setTextSize(20);
	    editText.setBackground(context.getResources().getDrawable(R.drawable.style_edit_consigaz));    		  
	    editText.setText(texto);
	    editText.setLayoutParams(lp_MATCH_WRAP);
	    
	    return editText;
	}

	public LinearLayout criaLinearLayoutTELA(){
	
		LinearLayout linearLayout = new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.setBackgroundColor(context.getResources().getColor(R.color.azul_claro_consigaz));
		linearLayout.setPadding(10, 0, 10, 0);
	
		return linearLayout;
	}
	
	public LinearLayout criaLinearLayoutLINHA(String titulo, TextView tv_conteudo){
		
		LinearLayout linearLayout = new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.addView(criaTextViewTITULO(titulo));
		linearLayout.addView(tv_conteudo);
		
		return linearLayout;
	}
	
	public LinearLayout criaLinearLayoutLINHAButtonButton(Button b1, Button b2){
		
		LinearLayout linearLayout = new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.addView(b1);
		linearLayout.addView(b2);
		
		return linearLayout;
	}

	public LinearLayout criaLinearLayoutLINHAet(String titulo, EditText et_conteudo){
		
		LinearLayout linearLayout = new LinearLayout(context);
		linearLayout.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout.addView(criaTextViewTITULO(titulo));
		linearLayout.addView(et_conteudo);
		
		return linearLayout;
	}

	@SuppressLint("NewApi")
	public LinearLayout criaLinearLayoutcomBordaArredondada(){
		
		LinearLayout ll_holder = new LinearLayout(context);
		ll_holder.setOrientation(LinearLayout.VERTICAL);
		ll_holder.setBackground(criaGradientDrawable(Color.WHITE));
		ll_holder.setPadding(10, 10, 10, 10);
		
		LayoutParams lp_MATCH_WRAP = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);			
							lp_MATCH_WRAP.setMargins(0, 20, 0, 20);		
		ll_holder.setLayoutParams(lp_MATCH_WRAP);
		
		return ll_holder;
	}
	
	public GradientDrawable criaGradientDrawable(int cor){
		
		GradientDrawable drawable = new GradientDrawable();
		drawable.setShape(GradientDrawable.RECTANGLE);
		drawable.setStroke(3, Color.BLACK);
		drawable.setCornerRadius(8);
		drawable.setColor(cor);
		
		return drawable;
	}

	public ScrollView criaScrollView(){
		
		ScrollView scrollView = new ScrollView(context);
	
		return scrollView;
	}
	
}
