package br.edu.ifms.universidade.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.universidade.model.Aluno;
import br.edu.ifms.universidade.model.Curso;
import br.edu.ifms.universidade.model.Disciplina;
import br.edu.ifms.universidade.model.Instituicao;
import br.edu.ifms.universidade.model.Turma;
import br.edu.ifms.universidade.repository.AlunoRepository;
import br.edu.ifms.universidade.repository.CursoRepository;
import br.edu.ifms.universidade.repository.DisciplinaRepository;
import br.edu.ifms.universidade.repository.InstituicaoRepository;
import br.edu.ifms.universidade.repository.TurmaRepository;

@Service
public class DBService {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	@Autowired
	InstituicaoRepository instituicaoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	
	public void instantiateTestDataBase() throws ParseException {
		
		
		Instituicao inst1 = new Instituicao(null, "IFMS", "001.002.003/0004-56");
		Instituicao inst2 = new Instituicao(null, "UFMS", "100.200.300/0004-56");
		
		Curso curso1 = new Curso(null, "ADS", "Tecnologia da Informação", null);
		Curso curso2 = new Curso(null, "Metalurgia", "Mineração", null);
		Curso curso3 = new Curso(null, "Sistemas de Informação", "Tecnologia da Informação", null);
		Curso curso4 = new Curso(null, "Administração de Empresas", "Humanas", null);
		
		Turma turma1 = new Turma(null, 123, null);
		Turma turma2 = new Turma(null, 456, null);
		Turma turma3 = new Turma(null, 789, null);
		Turma turma4 = new Turma(null, 147, null);
		Turma turma5 = new Turma(null, 258, null);
		Turma turma6 = new Turma(null, 369, null);
		Turma turma7 = new Turma(null, 159, null);
		Turma turma8 = new Turma(null, 357, null);
		
		
		Aluno aluno1 = new Aluno(null, "Rodrigo", 321);
		Aluno aluno2 = new Aluno(null, "Bruno", 654);
		Aluno aluno3 = new Aluno(null, "Mariana", 987);
		Aluno aluno4 = new Aluno(null, "Alexandre", 741);
		Aluno aluno5 = new Aluno(null, "Kenely", 852);
		Aluno aluno6 = new Aluno(null, "Fabiola", 963);
		Aluno aluno7 = new Aluno(null, "Carlos", 753);
		Aluno aluno8 = new Aluno(null, "Lucas", 951);
		Aluno aluno9 = new Aluno(null, "Marcelo", 397);
		
		Disciplina disc1 = new Disciplina(null, "Frames 2", "80");
		Disciplina disc2 = new Disciplina(null, "Sistemas Distribuidos", "60");
		Disciplina disc3 = new Disciplina(null, "LP3", "80");
		Disciplina disc4 = new Disciplina(null, "Frames 1", "120");
		Disciplina disc5 = new Disciplina(null, "Auditoria e Segurança", "150");
		Disciplina disc6 = new Disciplina(null, "Matemática", "60");
		Disciplina disc7 = new Disciplina(null, "Geologia", "60");
		Disciplina disc8 = new Disciplina(null, "Quimica", "100");
		Disciplina disc9 = new Disciplina(null, "Gestão de Pessoas", "100");
		
		
		
		
		turma1.getDisciplinas().addAll(Arrays.asList(disc2, disc4));
		turma2.getDisciplinas().addAll(Arrays.asList(disc1, disc3, disc5));
		turma3.getDisciplinas().addAll(Arrays.asList(disc6, disc8));
		turma4.getDisciplinas().addAll(Arrays.asList(disc7));
		turma5.getDisciplinas().addAll(Arrays.asList(disc2, disc4));
		turma6.getDisciplinas().addAll(Arrays.asList(disc1, disc3, disc5));
		turma7.getDisciplinas().addAll(Arrays.asList(disc6, disc9));
		turma8.getDisciplinas().addAll(Arrays.asList(disc9));
		
		
		
		disc1.getAlunos().addAll(Arrays.asList(aluno1, aluno2, aluno6, aluno7, aluno8));
		disc2.getAlunos().addAll(Arrays.asList(aluno3, aluno4, aluno5, aluno9));
		disc3.getAlunos().addAll(Arrays.asList(aluno1, aluno2, aluno6, aluno7, aluno8));
		disc4.getAlunos().addAll(Arrays.asList(aluno3, aluno4, aluno5, aluno9));
		disc5.getAlunos().addAll(Arrays.asList(aluno1, aluno3, aluno5, aluno7, aluno9));
		disc6.getAlunos().addAll(Arrays.asList(aluno2, aluno4, aluno6, aluno8));
		disc7.getAlunos().addAll(Arrays.asList(aluno3, aluno4, aluno5, aluno9));
		disc8.getAlunos().addAll(Arrays.asList(aluno1, aluno2, aluno4, aluno7, aluno8, aluno9));
		disc9.getAlunos().addAll(Arrays.asList(aluno3, aluno5, aluno6));
		
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5, aluno6, aluno7, aluno8, aluno9));
		disciplinaRepository.saveAll(Arrays.asList(disc1, disc2, disc3, disc4, disc5, disc6, disc7, disc8, disc9));
		turmaRepository.saveAll(Arrays.asList(turma1, turma2, turma3, turma4, turma5, turma6, turma7, turma8));
		
		cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3, curso4));
		instituicaoRepository.saveAll(Arrays.asList(inst1, inst2));
		
		
		
		
		
		
		
		
		
		
		
		
		/*Aluno(Integer id, String nomeAluno, int ra)
		 *Curso(Integer id, String nome_curso, String área_atuacao, Instituicao instituicao)
		 *Disciplina(Integer id, String nomeDisciplina, String cargaHoraria)
		 *Instituicao(Integer id, String nome_instituicao, String cnpj)
		 *Turma(Integer id, int numero_turma, Curso curso)
		
		*/
		
		
	}
	
}
