package br.com.reislavajato.controle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.reislavajato.config.AppConfig;
import br.com.reislavajato.entidade.Funcionario;
import br.com.reislavajato.entidade.Servico;
import br.com.reislavajato.neg.ServicoNeg;

public class TestIncluirServFunc {
	private static Servico servico = new Servico();
	private static Funcionario funcionario = new Funcionario();
	private static List<Funcionario> funcionarios = new ArrayList<>();
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public static void main(String[] args) throws Exception {
		// funcionario.setAtivo(EnumSimNao.SIM);
		// funcionario.setCarteiraTrabalho("526325");
		// funcionario.setCnh("147853269");
		// funcionario.setDataEntradaExercicio(new Date());
		// funcionario.getPessoa().getPessoaFisica().setNome("Judas");
		// funcionario.getPessoa().getPessoaFisica().setCpf("99222566149");
		//
		// funcionario.getPessoa().getEndereco().setBairro("Setor");
		// funcionario.getPessoa().getEndereco().setLogradouro("Rua");
		// funcionario.getPessoa().getEndereco().setCep("74650-360");
		//
		// funcionario.getPessoa().getEndereco().getMunicipio().setCodigo(465465L);
		// funcionario.getPessoa().getEndereco().getMunicipio().setNome("Gyn");
		// funcionario.getPessoa().getEndereco().getMunicipio().setUf(EnumUf.GO);
		//
		// funcionario.getPessoa().getTelefone().setCelular("99999999999");
		//
		// funcionario.setSalario(new BigDecimal("2.000"));
		//
		// context.getBean(FuncionarioNeg.class).incluir(funcionario);

		funcionario.setFuncionarioId(1L);
		funcionarios.add(funcionario);
		// funcionario = new Funcionario();
		// funcionario.setFuncionarioId(3L);
		// funcionarios.add(funcionario);

		servico.setDescricao("Pelicula");
		servico.setObservacao("abacaxi");
		servico.setPercentualComissao(new BigDecimal("5.0"));
		servico.setValorServico(new BigDecimal("35.00"));
		// servico.getFuncionarios().addAll(funcionarios);

		context.getBean(ServicoNeg.class).incluir(servico);

	}
}
