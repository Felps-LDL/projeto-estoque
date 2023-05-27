package felipeLagesDeLima.banco;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Extrato 
{
	private String operacao;
	private double valor;
	private double saldo;
	private Date data;
	
	public Extrato(Date data, String op, double v, double s) 
	{
		this.operacao = op;
		this.valor = v;
		this.saldo = s;
		this.data = data;
	}
	
	public String getLinha() 
	{
		// Formatando a data e colocando-a no extrato
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data) + " - " + operacao + ": " + valor + " Saldo: " + saldo + "\n";
	}

	public String getOperacao() 
	{
		return operacao;
	}

	public void setOperacao(String operacao) 
	{
		this.operacao = operacao;
	}

	public double getValor() 
	{
		return valor;
	}

	public void setValor(double valor) 
	{
		this.valor = valor;
	}

	public double getSaldo() 
	{
		return saldo;
	}

	public void setSaldo(double saldo) 
	{
		this.saldo = saldo;
	}

	public Date getData() 
	{
		return data;
	}

	public void setData(Date data) 
	{
		this.data = data;
	}
}