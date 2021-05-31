package servico;

public class CadastroPaciente{
	
	public CadastroPaciente() {
		
	}

	/*public void CadastroPaciente() {

		Paciente paciente = new Paciente();
		Documentos doc = new Documentos();
		Contatos contato = new Contatos();
		Endereco end = new Endereco();
		Vacina vac = new Vacina();
		CadPacienteController txt = new CadPacienteController();

		try {

			paciente.setNomeCompleto(txt.getNome().getText());

			if (paciente.getNomeCompleto().equals("")) {
				JOptionPane.showMessageDialog(null,"Campo Obrigatório!\nPreencha com nome completo: "
						+ "Digite o Nome Completo do paciente: ");
			}

			DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
			Date date = formatBR.parse(txt.getDataNasc().getText());

			DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
			String dataConvertida = formatUS.format(date);
			LocalDate data = LocalDate.parse(dataConvertida);

			paciente.setDataNasc(data);

			doc.setCpf(txt.getCPF().getText());

			if (doc.pesquisarCpf()) {
				JOptionPane.showMessageDialog (null,"CFP já cadastrado!\nDigitar um CPF valido não cadastrado\nDigite o CPF do paciente: ");
			}

			if (!doc.isCPF()) {
				JOptionPane.showMessageDialog(null, "CFP invalido!\nDigitar um CPF valido!\nDigite o CPF do paciente: ");
			}

			doc.setRg(txt.getRG().getText());

			doc.setOrgEmissor(txt.getOrgEmissor().getText().toUpperCase());

			doc.setNumSus(txt.getNumSUS().getText());
			paciente.setDoc(doc);

			contato.setFone(txt.getFoneFixo().getText());

			contato.setCelular(txt.getCelular().getText());

			contato.setEmail(txt.getEmail().getText());

			if (contato.getEmail() == null || contato.getEmail().equals("")) {
				contato.setEmail("");
			} else if (!Contatos.isEmailValido(contato.getEmail())) {
					JOptionPane.showMessageDialog(null, "E-mail invalido!\nDigitar um E-mail valido:\nDigite seu E-mail: ");
				}

			paciente.setContatos(contato);

			end.setRua(txt.getLogradouro().getText());

			end.setNum(txt.getNumCasa().getText());

			end.setBairro(txt.getBairro().getText());

			end.setCidade(txt.getCidade().getText());

			end.setUf(txt.getUF().getText().toUpperCase());

			end.setComplemento(txt.getComplemento().getText());

			end.setCep(txt.getCEP().getText());
			paciente.setEndereco(end);

			CadPacienteController tpVac = new CadPacienteController();

			vac.setTpVacina(tpVac.respTpVac());

			if (vac.getResp() == 1 || vac.getResp() == 4) {

				formatBR = new SimpleDateFormat("dd/MM/yyyy");
				date = formatBR.parse(txt.getDataPrimeirdaDose().getText());

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				dataConvertida = formatUS.format(date);
				LocalDate dataVac = LocalDate.parse(dataConvertida);
				vac.setDataVacina1(dataVac);
				dataVac = vac.getDataVacina1().plusDays(28);
				vac.setDataVacina2(dataVac);

			} else if (vac.getResp() == 2 || vac.getResp() == 3) {
				formatBR = new SimpleDateFormat("dd/MM/yyyy");
				date = formatBR.parse(txt.getDataPrimeirdaDose().getText());

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				dataConvertida = formatUS.format(date);
				LocalDate dataVac = LocalDate.parse(dataConvertida);
				vac.setDataVacina1(dataVac);
				dataVac = vac.getDataVacina1().plusDays(21);
				vac.setDataVacina2(dataVac);

			} else if (vac.getResp() == 5) {
				formatBR = new SimpleDateFormat("dd/MM/yyyy");
				date = formatBR.parse(txt.getDataPrimeirdaDose().getText());

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				dataConvertida = formatUS.format(date);
				LocalDate dataVac = LocalDate.parse(dataConvertida);
				vac.setDataVacina1(dataVac);
				vac.setDataVacina2(dataVac);

			} else if (vac.getResp() == 6) {
				formatBR = new SimpleDateFormat("dd/MM/yyyy");
				date = formatBR.parse(txt.getDataPrimeirdaDose().getText());

				formatUS = new SimpleDateFormat("yyyy-MM-dd");
				dataConvertida = formatUS.format(date);
				LocalDate dataVac = LocalDate.parse(dataConvertida);
				vac.setDataVacina1(dataVac);
				dataVac = vac.getDataVacina1().plusDays(90);
				vac.setDataVacina2(dataVac);
			}

			paciente.setVacina(vac);

			CadastroBd.cadastroPaciente(paciente, doc, end, contato, vac);

			JOptionPane.showMessageDialog(null, "Paciente cadastrado");
		} catch (HeadlessException | NullPointerException | ParseException | NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Erro inesperado!");
		}
	}*/
}
