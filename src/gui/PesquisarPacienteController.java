package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PesquisarPacienteController extends InicialPesquisaController{

    TextField nome = null;
    Date dataNasc;
    String dataNasConvertida = "";
    TextField dnc = null;
    @FXML
    Label rg = null;
    String org = "";
    String cpf = "";
    String numSus = "";
    String rua = "";
    String num = "";
    String bairro = "";
    String cidade = "";
    String uf = "";
    String comp = "";
    String cep = "";
    String fone = "";
    String cel = "";
    String email = "";
    String tpVacina = "";
    Date data1Vac;
    String dataVac1Convertida = "";
    TextField dv1c = null;
    Date data2Vac;
    String dataVac2Convertida = "";
    TextField dv2c = null;


    @FXML
    public String resultadoPesquisa(){

        ResultSet rs = con.executaBusca(this.sql);

        try {
            while (rs.next()){
                nome.setPromptText(rs.getString("nome_paciente")); ;
                dataNasc = rs.getDate("data_nasc_paciente");
                rg.setText(rs.getString("rg_paciente"));
                org = rs.getString("org_emissor_paciente");
                cpf = rs.getString("cpf_paciente");
                numSus = rs.getString("num_sus_paciente");
                rua = rs.getString("rua_paciente");
                num = rs.getString("num_paciente");
                bairro = rs.getString("bairro_paciente");
                cidade = rs.getString("cidade_paciente");
                uf = rs.getString("uf_paciente");
                comp = rs.getString("complemento_paciente");
                cep = rs.getString("cep_paciente");
                fone = rs.getString("fone_paciente");
                cel = rs.getString("celular_paciente");
                email = rs.getString("email_paciente");
                tpVacina = rs.getString("tipo_vac_paciente");
                data1Vac = rs.getDate("data1_vac_paciente");
                data2Vac = rs.getDate("data2_vac_paciente");

                DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
                dataNasConvertida = formatUS.format(dataNasc);
                LocalDate data = LocalDate.parse(dataNasConvertida);
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dnc.setPromptText(dataNasConvertida = fmt.format(data));


                formatUS = new SimpleDateFormat("yyyy-MM-dd");
                dataVac1Convertida = formatUS.format(data1Vac);
                data = LocalDate.parse(dataVac1Convertida);
                fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dv1c.setPromptText(dataVac1Convertida = fmt.format(data));

                formatUS = new SimpleDateFormat("yyyy-MM-dd");
                dataVac2Convertida = formatUS.format(data2Vac);
                data = LocalDate.parse(dataVac2Convertida);
                fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dv2c.setPromptText(dataVac2Convertida = fmt.format(data));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(cpf.equals("")) {
            return "CPF não cadastrado";
        }else {
            return "Nome: " + nome +
                    "\nData de Nascimento: " + dataNasConvertida +
                    "\nR.G.: " + rg + "\nOrg. Emissor: " + org + "\nCPF: " + cpf +
                    "\nNúmero SUS: "+ numSus +"\nRua: " + rua + "\nNº: " + num +
                    "\nBairro: " + bairro + "\nCidade: " + cidade + "\nUF: " + uf +
                    "\nComplemento: " + comp + "\nCEP: " + cep + "\nFone: " + fone +
                    "\nCelular: " + cel + "\nE-mail: " + email + "\nTipo de Vacina: " + tpVacina +
                    "\nData da primeira dose ou dose única: " + dataVac1Convertida + "\nData da segunda dose: " + dataVac2Convertida;
        }
    }
}
