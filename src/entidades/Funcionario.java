package entidades;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Funcionario {

    private String nome;
    private String userName;
    private String senha;
    private String doc;
    private String email;
    private String cargo;
    private static final String FormatoCpf = "###.###.###-##";

    Documentos docValid = new Documentos();

    public Funcionario(){

    }

    public Funcionario(String nome, String userName, String senha, String doc, String email, String cargo) {

        this.nome = nome;
        this.userName = userName;
        this.senha = senha;
        this.doc = doc;
        this.email = email;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
            this.doc = doc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
