package entidades;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

public class Contatos {
	
	private String fone;
	private String celular;
	private String email;
	private static final String FormatoCel = "(##) #####.####";
	private static final String FormatoFixo = "(##) ####.####";	
		
	public Contatos() {
		
	}

	public Contatos(String fone, String celular, String email) {
		super();
		this.setFone(fone);
		this.setCelular(celular);
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone.replaceAll("[^0-9]", "");
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular.replaceAll("[^0-9]", "");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public static boolean isEmailValido(String email) {
	    boolean isEmailIdValid = false;
	    if (email != null && email.length() > 0) {
	        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(email);
	        if (matcher.matches()) {
	            isEmailIdValid = true;
	        }
	    }
	    return isEmailIdValid;
	}
	
	public String gerFoneFormatado() {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(FormatoFixo);
			mask.setValueContainsLiteralCharacters(false);
			if(this.fone != null && !this.fone.equals("")) {
				return mask.valueToString(getFone());				
			}
			return this.fone = null;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getFone();
	}
	
	public String getCelFormatado() {
		MaskFormatter mask;
		try {
			mask = new MaskFormatter(FormatoCel);
			mask.setValueContainsLiteralCharacters(false);
			if(this.celular != null && !this.celular.equals("")) {
				return mask.valueToString(getCelular());				
			}
			return this.celular = null;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return getCelular();
	}
	
}
