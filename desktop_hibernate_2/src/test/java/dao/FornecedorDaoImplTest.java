/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Endereco;
import entidade.Fornecedor;
import java.util.Date;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;
import web_service.EnderecoWebService;

/**
 *
 * @author Silvio
 */
public class FornecedorDaoImplTest {

    private Fornecedor fornecedor;
    private Session sessao;
    private FornecedorDao fornecedorDao;

    public FornecedorDaoImplTest() {
        fornecedorDao = new FornecedorDaoImpl();
    }

    @Test
    public void testsalvar() {
        System.out.println("salvar");

        String cep = "88110400";
        EnderecoWebService webService = new EnderecoWebService();
        Endereco endereco = webService.pesquisaCep(cep);

        fornecedor = new Fornecedor(null, "fornecedor x", new Date(), "bla bla...");
        fornecedor.setEndereco(endereco);
        endereco.setFornecedor(fornecedor);

        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        assertNotNull(fornecedor.getId());
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

//    @Test
    public void testListarTodo() {
        System.out.println("listarTodo");

    }

}
