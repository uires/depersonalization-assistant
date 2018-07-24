package depersonalizationAssistant.teste;

import java.util.Date;

import org.depersonalizationAssistant.dao.PacienteDAO;
import org.depersonalizationAssistant.model.Endereco;
import org.depersonalizationAssistant.model.Paciente;
import org.junit.Test;

public class PacienteTest {

	@Test
	public void cadastro(){
		Paciente paciente = new Paciente();
		paciente.setEmail("asd@g.com");
		paciente.setNome("Nilzete dos Santos ");
		paciente.setSexo("F");
		paciente.setCpf("003.030.211-87");
		paciente.setTelefone("41-9732-0145");
		paciente.setDataNascimento(new Date());
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
}
