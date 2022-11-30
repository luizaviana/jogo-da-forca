import java.io.*;

public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;
	
    public ControladorDeErros (int qtdMax) throws Exception
    {
		if(qtdMax <= 0)
			throw new Exception ("Quantidade máxima não positiva");
            // # Verifica se qtdMax fornecida não é positiva, lançando uma exceção.
		else
			this.qtdMax = qtdMax;
		// # Armazena qtdMax fornecida em this.qtdMax.
    }

    public void registreUmErro () throws Exception
    {
		if(this.qtdErr == this.qtdMax)
			throw new Exception ("Número de erros máximo atingido");
            // # Verifica se this.qtdErr ja é igual a this.qtdMax,
            // # Lança exceção em caso positivo ou
		else
			this.qtdErr++;
        // # Incrementa this.qtdErr em caso negativo
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
		if(this.qtdErr == this.qtdMax)
			return true;
            // # Returna true se this.qtdErr for igual a this.qtdMax,
		else
			return false;
        // # então false, caso contrário.
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    } // 4/5

    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        ControladorDeErros c =
       (ControladorDeErros)obj;

       if(this.qtdMax != c.qtdMax || this.qtdErr != c.qtdErr)
			return false;

		return true;
			
        // # Verificar se this e obj possuem o mesmo conteúdo, retornando
        // # True no caso afirmativo ou false no caso negativo
    }

    public int hashCode ()
    {
		final int PRIMO = 13;
        
        int ret=666;

		ret = PRIMO * ret + new Integer(this.qtdMax).hashCode();
		ret = PRIMO * ret + new Integer(this.qtdErr).hashCode();
		
        if (ret<0) ret = -ret;

        return ret;
        // # Calcular e retornar o hashcode de this
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de cópia
    {
		if(c == null)
			throw new Exception ("Controlador nulo");

		this.qtdMax = c.qtdMax;
		this.qtdErr = c.qtdErr;
		
        // # Copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
    }

    public Object clone ()
    {
		ControladorDeErros clone = null;
		
		try
		{
			clone = new ControladorDeErros(this);
		}
		catch(Exception ex)
		{}
		
		return clone;
        // # Retornar uma cópia de this
    }
}
