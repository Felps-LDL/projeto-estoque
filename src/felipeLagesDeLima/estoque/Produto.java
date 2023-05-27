package felipeLagesDeLima.estoque;

public class Produto 
{
    public int cod, estq_min, qtd = 0;
    public double lucro, preco_compra, preco_venda;
    public Fornecedor forn;
    public String desc;

    public Produto(int cod, String desc, int min, double lucro, Fornecedor forn)
    {
        this.cod = cod;
        this.desc = desc;
        estq_min = min;
        this. lucro = lucro;
        this.forn = forn;
    }

    void compra(int quant, double val)
    {
        // Atualia preço de compra
        preco_compra = (qtd * preco_compra + quant * val) / (qtd + quant);

        // Atualiza preço de venda
        preco_venda = preco_compra + lucro * preco_compra;

        // Atualiza qtd
        qtd += quant;
    }

    @Override
    public String toString() {
        return "Produto [cod=" + cod + ", estq_min=" + estq_min + ", qtd=" + qtd + ", lucro=" + lucro
                + ", preco_compra=" + preco_compra + ", preco_venda=" + preco_venda + ", forn=" + forn + ", desc="
                + desc + "]";
    }  

}
