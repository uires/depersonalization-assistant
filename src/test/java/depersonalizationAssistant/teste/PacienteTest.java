package depersonalizationAssistant.teste;

import java.util.Calendar;

import org.depersonalizationAssistant.dao.RelatorioDAO;
import org.depersonalizationAssistant.model.NomePatologia;
import org.depersonalizationAssistant.model.Paciente;
import org.depersonalizationAssistant.model.Patologia;
import org.depersonalizationAssistant.model.Relatorio;
import org.junit.Test;

public class PacienteTest {
	/*
	@Test
	public void cadastro(){
		Paciente paciente = new Paciente();
		paciente.setEmail("asd@g.com");
		paciente.setNome("Nilzete dos Santos ");
		paciente.setSexo("F");
		paciente.setCpf("003.030.211-87");
		paciente.setTelefone("41-9732-0145");
		paciente.setDataNascimento(Calendar.getInstance());
		Endereco endereco = new Endereco();
		endereco.setCep("41111-123");
		endereco.setCidade("São Paulo");
		endereco.setComplemento("Perto da igreja católica.");
		endereco.setRua("Av. ACM, nº 4001");
		endereco.setEstado("São Paulo");
		paciente.setEndereco(endereco);
		PacienteDAO dao = new PacienteDAO();
		dao.cadastraPaciente(paciente);
	}
	*/
	
	@Test
	public void cadastarPatologiaAnd (){
		Paciente p = new Paciente();
		p.setId(1);
		Relatorio rela = new Relatorio();
		rela.setIdPaciente((long)p.getId());
		rela.setDescricao("Sofri com grandes crises de DP, creio que mudou minha vida.");
		Patologia pato = new Patologia();
		pato.setDataInicio(Calendar.getInstance());
		pato.setNomePatologia(NomePatologia.ANSIEDADE);
		rela.setPatologia(pato);
		RelatorioDAO dao = new RelatorioDAO();
		dao.cadastraRelatorio(rela, (long) p.getId());
	}
}
