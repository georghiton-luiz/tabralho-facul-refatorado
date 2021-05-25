package entidades;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Funcionario {

    private String nome;
    private String senha;
    private String doc;
    private String email;
    private static final String FormatoCpf = "###.###.###-##";

    Documentos docValid = new Documentos();

    public Funcionario(){

    }

    public Funcionario(String nome, String senha, String doc, String email) {
        this.nome = nome;
        this.senha = senha;
        this.doc = doc;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDoc() {
            return doc;
    }

    public void setDoc(String doc) {
        if(doc.length() == 11 || doc.length() == 14){
            this.doc = doc.replaceAll("[^0-9]", "");
        }else{
            this.doc = doc;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfFormatado() {
        MaskFormatter mask;
        try {
            docValid.setCpf(getDoc());
            mask = new MaskFormatter(FormatoCpf);
            mask.setValueContainsLiteralCharacters(false);
            if(docValid.isCPF()) {
                return mask.valueToString(docValid.getCpf());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDoc();
    }
}
