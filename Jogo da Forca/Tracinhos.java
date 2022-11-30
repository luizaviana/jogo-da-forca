import java.io.*;

public class Tracinhos implements Cloneable
{
    private char texto [];
	
    public Tracinhos (int qtd) throws Exception
    {
		if(qtd <= 0)
			throw new Exception ("A quantidade de tracinhos n�o pode ser negativa");
		// # Verifica se qtd não é positiva, lançando uma exceção.
		this.texto = new char[qtd];
		// # Instancia this.texto com um vetor com tamanho igual qtd.
			
		for(int i = 0; i < qtd; i++)
		{
			this.texto[i] = '_';
			// # Preenche this.texto com underlines (_).
		}
    }

    public void revele (int posicao, char letra) throws Exception
    {
		if(posicao < 0 || posicao >= this.texto.length)
			throw new Exception("A posição não existe no vetor");
		// # Verifica se posição é negativa ou então igual ou maior do que this.texto.length, lançando uma exceção.
		else
			texto[posicao] = letra;
		// # Armazena a letra fornecida na posição tambem fornecida do vetor this.texto
    }

    public boolean isAindaComTracinhos ()
    {
		for(int i = 0; i < this.texto.length; i++)
		{
			// # Percorre o vetor this.texto e verifica se o mesmo ainda contem algum underline ou se j� foram todos substitu�dos por letras;
			if(this.texto[i] == '_')
				return true;
				// # retornar true caso ainda reste algum underline
		}
		
		return false;
        // # Ou false caso contrário
    }

    public String toString ()
    {
		String st = "";
		for(int i = 0; i < this.texto.length; i++)
		{
			st += this.texto[i] + " ";
		}
		return st;
        // # Retorna um String com TODOS os caracteres que há no vetor this.texto, intercalados com espa�os em brancos
    }

    public boolean equals (Object obj)
    {
		if (this==obj)
			return true;

		if (obj==null)
			return false;

		if (this.getClass()!=obj.getClass())
			return false;

		Tracinhos t =
				(Tracinhos)obj;

		for(int i = 0; i < this.texto.length; i++)
		{
			if(this.texto[i] != t.texto[i])
				return false;
		}

		return true;
        // * Verificar se this e obj possuem o mesmo conteúdo, retornando
        // * True no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
		final int PRIMO = 13;
        
        int ret=666;
		
		for(int i = 0; i < texto.length; i++)
		{
			ret = PRIMO * ret + new Character(this.texto[i]).hashCode();
		}
		
        if (ret<0) ret = -ret;

        return ret;
        // * Calcular e retornar o hashcode de this
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de cópia
    {
		if(t == null)
			throw new Exception("Objeto tracinhos nulo");

		this.texto = new char[t.texto.length];
		// # Instanciar this.texto um vetor com o mesmo tamanho de t.texto
			
		for(int i = 0; i < t.texto.length; i++)
		{
			this.texto[i] = t.texto[i];
			// # Copiar o conteúdo de t.texto para this.texto
		}    
    }

    public Object clone ()
    {
		Tracinhos clone = null;
		
		try
		{
			clone = new Tracinhos(this);
		}
		catch(Exception ex)
		{}
		
		return clone;
		
        // # Retornar uma cópia de this
    }
}
