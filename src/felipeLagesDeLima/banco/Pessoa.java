package felipeLagesDeLima.banco;

public class Pessoa {
	
	private int cpf;
	private String nome;
	private ContaComum conta;
	
	public Pessoa(int numCpf) {
		cpf = numCpf;
	}
	
	public Pessoa(int numCpf, String nm) {
		cpf = numCpf;
		nome = nm;
	}
	
	public ContaComum getConta() 
	{
		return conta;
	}
	
	public void setConta(ContaComum c) 
	{
		if (conta != null) 
		{
		  System.out.println("Não é permitido alterar a conta dessa pessoa.");
		} 
		else 
		{
		  conta = c;
		}
	}
	
	public int getCpf() 
	{
		return cpf;
	}
	
	public String getNome() 
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
}
