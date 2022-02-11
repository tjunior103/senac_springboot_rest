package dao;

import entidade.Chamado;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silvio
 */
public class ChamadoDaoImplTest {

    private Chamado chamado;
    private final ChamadoDao chamadoDao;
    private Session sessao;

    public ChamadoDaoImplTest() {
        chamadoDao = new ChamadoDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("excluir");
        sessao = HibernateUtil.abrirConexao();
        chamado = new Chamado("Monitor " + 10, "dskfj ksdjfkds");
        chamadoDao.salvarOuAlterar(chamado, sessao);
        sessao.close();
        assertNotNull(chamado.getId());
    }

//    @Test
    public void testAlterar() {
        System.out.println("alterar");
        buscarChamadoBd();
        chamado.setAtivo(false);
        sessao = HibernateUtil.abrirConexao();
        chamadoDao.salvarOuAlterar(chamado, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Chamado chamatoAlt = chamadoDao.pesquisarPorId(chamado.getId(), sessao);
        sessao.close();
        assertEquals(chamatoAlt.isAtivo(), chamado.isAtivo());
    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarChamadoBd();
        sessao = HibernateUtil.abrirConexao();
        chamadoDao.excluir(chamado, sessao);

        Chamado chamadoExc = chamadoDao.pesquisarPorId(chamado.getId(), sessao);
        sessao.close();
        assertNull(chamadoExc);
    }

//    @Test
    public void testPesquisarPorEquipamento() {
        System.out.println("pesquisarPorEquipamento");
        buscarChamadoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Chamado> chamados = chamadoDao.
                pesquisarPorEquipamento(chamado.getEquipamento().substring(0, 3), sessao);
        sessao.close();
        assertTrue(!chamados.isEmpty());
    }

//    @Test
    public void testPesquisarChamadoAberto() {
        System.out.println("pesquisarChamadoAberto");
        buscarChamadoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Chamado> chamados = chamadoDao.pesquisarChamadoAberto(sessao);
        sessao.close();
        assertTrue(!chamados.isEmpty());
    }

//    @Test
    public void testPesquisarPorData() {
        System.out.println("pesquisarPorData");
        buscarChamadoBd();
        sessao = HibernateUtil.abrirConexao();
        List<Chamado> chamados = chamadoDao.pesquisarPorData(chamado.getCadastro(), sessao);
        sessao.close();
        assertTrue(!chamados.isEmpty());
    }

    public Chamado buscarChamadoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query consulta = sessao.createQuery("from Chamado");
        List<Chamado> chamados = consulta.list();
        sessao.close();
        if (chamados.isEmpty()) {
            testSalvar();
        } else {
            chamado = chamados.get(0);
        }
        return chamado;
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
    }

}
