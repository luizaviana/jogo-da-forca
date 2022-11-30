import java.io.*;

public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
		this.letrasJaDigitadas = "";
		
        // # Torna this.letrasJaDigitadas igual ao String vazio
    }

    public boolean isJaDigitada (char letra)
    {
		for(byte i = 0; i < this.letrasJaDigitadas.length(); i++)
		{
			if(letrasJaDigitadas.charAt(i) == letra)
				return true;
		}
		
		return false;
		
        // * Percorrer o String this.letrasJaDigitadas e verificar se ele
        // # possui a letra fornecida, retornando true em caso afirmativo
        // # ou false em caso negativo
    }

    public void registre (char letra) throws Exception
    {
		if(this.isJaDigitada(letra))
			throw new Exception ("Esta letra já foi digitada");
		
		else
			this.letrasJaDigitadas += letra;
		
		// # Verifica se a letra fornecida ja foi digitada (pode usar o método this.isJaDigitada, para isso),
		// # lançando uma exceção em caso afirmativo.
		// # concatena a letra fornecida a this.letrasJaDigitadas.
    }

    public String toString ()
    {
		String toStrings = "";
		
		for(byte i = 0; i < this.letrasJaDigitadas.length(); i++)
		{
			toStrings += this.letrasJaDigitadas.charAt(i) + ", ";
		}
		
		return toStrings;
		
		// # Retorna um String com TODAS as letras presentes em
		// # this.letrasJaDigitadas separadas por vírgula (,).
    }

    public boolean equals (Object obj)
    {
		if (this==obj)
			return true;

		if (obj==null)
			return false;

		if (this.getClass()!=obj.getClass())
			return false;

		ControladorDeLetrasJaDigitadas c = (ControladorDeLetrasJaDigitadas) obj;

		if(this.letrasJaDigitadas != c.letrasJaDigitadas)
			return false;

		return true;
        // * Verificar se this e obj são iguais
    }

    public int hashCode ()
    {
		final int PRIMO = 13;
        
        int ret=666;

		ret = PRIMO * ret + this.letrasJaDigitadas.hashCode();
		
        if (ret<0) ret = -ret;

        return ret;
        
        // ! Calcular e retornar o hashcode de this
    }

    public ControladorDeLetrasJaDigitadas(ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas) throws Exception
    // construtor de cópia
    {
		if(controladorDeLetrasJaDigitadas == null)
			throw new Exception ("Controlador nulo");
			
		this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
        // * Copiar c.letrasJaDigitadas em this.letrasJaDigitadas
    }

    public Object clone ()
    {
		ControladorDeLetrasJaDigitadas clone = null;
		
		try
		{
			clone = new ControladorDeLetrasJaDigitadas(this);
		}
		catch(Exception ex)
		{}
		
		return clone;
        // * Criar uma cópia do this com o construtor de cópia e retornar
    }
}
