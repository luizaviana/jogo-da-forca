import java.io.*;

public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		if(texto.equals(""))
			throw new Exception ("Texto vazio");
		else
			this.texto = texto;
		// # Verifica se o texto recebido é nulo ou então vazio, ou seja, sem nenhum caractere, lançando exceção.
		// # Armazena o texto recebido em this.texto.
    }

    public byte getQuantidade (char letra)
    {
		byte qtd = 0;
		for(byte i = 0; i < texto.length(); i++)
		{
			if(this.texto.charAt(i) == letra)
				qtd++;
		}
		
		return qtd;
		
        // # Percorre o String this.texto, conta
        // # e retorna quantas letras existem nele iguais a letra fornecida
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
		for(byte n = 0, j = -1; n < texto.length(); n++)
		{
			if(texto.charAt(n) == letra)
			{
				j++;
				if(j == i)
				{
					return n;
				}
			}
			
			if(n + 1 == texto.length())
			{
				throw new Exception ("Não foi encontrada a posição");
			}
		}
        return -1;
        // # se i==0, retorna a posição em que ocorre a primeira aparição de letra fornecida em this.texto;
        // # se i==1, retorna a posição em que ocorre a segunda aparição de letra fornecida em this.texto;
        // # se i==2, retorna a posição em que ocorre a terceira aparição de letra fornecida em this.texto; e assim por diante.
        // # Lançar exceção caso não encontre em this.texto a Iézima aparição da letra fornecida.
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    public String toString ()
    {
        return this.texto;
    }

    public boolean equals (Object obj)
    {
		if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass()!= obj.getClass())
            return false;

        Palavra palavra =
       (Palavra)obj;

       if(this.texto != palavra.texto)
			return false;
			
		return true;
        // # Verificar se this e obj possuem o mesmo conteúdo, retornando
        // # True no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
		final int PRIMO = 13;
        
        int ret=666;
        
		ret = PRIMO * ret + this.texto.hashCode();
		
        if (ret<0) ret = -ret;

        return ret;
        // # Calcular e retornar o hashcode de this
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
