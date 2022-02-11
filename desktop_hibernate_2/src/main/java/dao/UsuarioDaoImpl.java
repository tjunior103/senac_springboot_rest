/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.*;

public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao, Serializable {

    @Override
    public List<Usuario> listarTodo(Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Usuario");
        return consulta.list();
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query consulta = sessao.createQuery("from Usuario where nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.list();
    }

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Usuario) sessao.get((Usuario.class), id);
    }

    @Override
    public Usuario logar(String login, String senha, Session session) throws HibernateException {
        Query consulta = session.createQuery("from Usuario where login = :login and senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return (Usuario) consulta.uniqueResult();
    }

    @Override
    public void atualizarUltimoAcesso(Long id, Session session) throws HibernateException {
        Transaction transacao = session.beginTransaction();
        Query hql = session.createQuery("update Usuario set ultimo_acesso = current_date() "
                + "where id = :id");
        hql.setParameter("id", id);
        hql.executeUpdate();
        transacao.commit();
    }

    @Override
    public void alterarStatus(Long id, boolean status, Session session) throws HibernateException {
        Transaction transacao = session.beginTransaction();
        Query hql = session.createQuery("update Usuario set ativo = :status where id = :id");
        hql.setParameter("id", id);
        hql.setParameter("status", status);
        hql.executeUpdate();
        transacao.commit();
    }

}
