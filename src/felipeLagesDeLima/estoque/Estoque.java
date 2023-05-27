package felipeLagesDeLima.estoque;

public class Estoque 
{
    public Produto prod[] = new Produto[1000];
    public int qtd_produtos = 0;

    public void incluir(Produto p)
    {
        for (int i = 0; i < qtd_produtos; i++)
        {
            if (prod[i].cod == p.cod)
            {
                return;
            }
        }

        prod[qtd_produtos++] = p; // new Produto(p.cod, p.desc, p.estq_min, p.lucro, p.forn);
    }

    public void comprar(int cod, int quant, double preco)
    {
        int i;

        for (i = 0; i < qtd_produtos; i++)
        {
            if (cod == prod[i].cod)
            {
                break;
            }
        }


        if (quant <= 0 || preco <= 0 || prod[i] == null)
        {
            return;
        }

        prod[i].compra(quant, preco);
    }

    public double vender(int cod, int quant)
    {
        int i;
        for (i = 0; i < qtd_produtos; i++)
        {
            if (cod == prod[i].cod)
            {
                break;
            }
        }

        // Caso não tenha produto ou não tenha encontrado o produto
        if (prod[i] == null || quant <= 0)
        {
            return -99999;
        }

        // qtd de itens insuficientes
        if (prod[i].qtd < quant)
        {
            return -1;
        }

        prod[i].qtd -= quant;

        return quant * prod[i].preco_venda;
    }

    public int quantidade(int cod)
    {
        int i;

        for (i = 0; i < qtd_produtos; i++)
        {
            if (prod[i].cod == cod)
            {
                break;
            }
        }
    
        // Qtd de itens do produto
        return prod[i].qtd;
    }
    
    public Fornecedor fornecedor(int cod)
    {
        int i = 0;
        
        for (i = 0; i < qtd_produtos; i++)
        {
            if (prod[i].cod == cod)
            {
                break;
            }
        }

        if (prod[i] == null)
        {
            return null;
        }
        else
        {
            return prod[i].forn;
        }
    }

    public Produto[] estoqueAbaixoDoMinimo()
    {
        int tam = 0, i;

        for (i = 0; i < qtd_produtos; i++)
        {
            if (prod[i].qtd < prod[i].estq_min)
            {
                tam++;
            }
        }

        Produto mins[] = new Produto[tam];
        int count = 0;

        for (i = 0; i < qtd_produtos; i++)
        {
            if (prod[i].qtd < prod[i].estq_min)
            {
                mins[count++] = prod[i]; // new Produto(prod[i].cod, prod[i].desc, prod[i].estq_min, prod[i].lucro, prod[i].forn);
            }
        }

        return mins;
    }
    
}