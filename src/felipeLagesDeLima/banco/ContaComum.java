package felipeLagesDeLima.banco;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ContaComum {
	private int num;
	private double saldo;
	private Extrato[] extrato = new Extrato[100];
	private int pos = 0;
	private Pessoa dono;

	
	public ContaComum(int n, Pessoa p) {
	   num = n;	
	   if (p.getConta() == null) 
	   {
	     dono = p;
	     p.setConta(this);
	   } 
	   else 
	   {
		 System.out.println("Essa pessoa já possui uma conta");
		 return;
	   }
	}
	
	public void credito(double val, Date data) 
	{
		saldo = saldo + val;
		extrato[pos++] = new Extrato(data, "Credito", val, saldo);
	}
	
	public void debito(double val, Date data) 
	{
		if (val <= saldo) 
		{ 
		  	saldo = saldo - val;
			extrato[pos++] = new Extrato(data, "Debito", val, saldo);
		} 
		else 
		{
			System.out.println("Saldo insuficiente.");
		}
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int n) 
	{
		if (n < 1000) 
		{ 
			num = n;
		} 
		else 
		{
			System.out.println("Não é permitido usar numeros maiores que 1000");
		}
	}

	public double getSaldo() 
	{
		return saldo;
	}

	public String getExtrato(Date dataInicio, Date dataFim) 
	{
		String ext = "";

		for (int i = 0; i < pos; i++) 
		{
			// Pega somente no intervalo
			if (dataInicio.compareTo(extrato[i].getData()) <= 0 && extrato[i].getData().compareTo(dataFim) <= 0)
			{
				ext += extrato[i].getLinha();
			} 
		}
		
		return ext;
	}
	
	public Pessoa getDono() 
	{
		return dono;
	}
	
}
