package felipeLagesDeLima.banco;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UsoDeConta 
{

	public static void main(String[] args) throws ParseException 
	{	
		// Formatador de data usado na aula
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Date data, data_inicio, data_fim;

		Pessoa p1 = new Pessoa(1, "Pedro");
		Pessoa p2 = new Pessoa(2, "João");
		
		ContaComum c1 = new ContaComum(1, p1);
		ContaComum c2 = new ContaComum(2, p2);
		
		String textDataInicio, textDataFim;

//		c1.saldo = 10;
//		c1.num = 10;
		
		c1.setNum(10);
		c2.setNum(10000);

		// Datas e operações
		data = sdf.parse("19/05/2023");
		c1.credito(100, data);

		data = sdf.parse("20/05/2023"); 
		c1.debito(40, data);
		
		data = sdf.parse("21/05/2023");
		c1.credito(120, data);
		
		data = sdf.parse("22/05/2023");
		c1.credito(80, data);


		// Pegar CPF e Nome
		System.out.println("CPF: " + c1.getDono().getCpf());
		System.out.println("Nome: " + c1.getDono().getNome());

		// Pegar data inicial e final

		System.out.println("Data inicial (DD/MM/AAAA): ");
		textDataInicio = sc.nextLine();
		System.out.println("Data final : (dia(dd)/mes(MM)/ano(YYYY))");
		textDataFim = sc.nextLine();
		sc.close();

		// Formatando as datas
		data_inicio = sdf.parse(textDataInicio);
		data_fim = sdf.parse(textDataFim);
		System.out.println("");

		// Mostrando o extrato
		System.out.println(c1.getExtrato(data_inicio, data_fim));
	}

}
