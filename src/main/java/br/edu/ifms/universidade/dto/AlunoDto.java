package br.edu.ifms.universidade.dto;

public class AlunoDto {
	
	private Integer id;
	private String nomeAluno;
	private int ra;
	
	
	public AlunoDto() {
		// TODO Auto-generated constructor stub
	}
	
	



	public AlunoDto(Integer id, String nomeAluno, int ra) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.ra = ra;
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
	}

}
