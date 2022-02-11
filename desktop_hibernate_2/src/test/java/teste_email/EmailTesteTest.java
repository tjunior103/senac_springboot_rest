/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_email;

import entidade.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silvio
 */
public class EmailTesteTest {
    
    public EmailTesteTest() {
    }

//    @Test
    public void testCriarEmailUsuarioNovo() {
        System.out.println("criarEmailUsuarioNovo");
        Usuario usuario = new Usuario("Junior", "tjunior103@gmail.com", "dfdsf");
        EmailTeste emailTeste = new EmailTeste();
        boolean enviou = emailTeste.criarEmailUsuarioNovo(usuario);
        assertTrue(enviou);
    }
    
}
