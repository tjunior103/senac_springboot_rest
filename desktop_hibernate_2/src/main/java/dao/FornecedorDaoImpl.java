/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao, Serializable{

    @Override
    public Fornecedor pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return (Fornecedor) sessao.get(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> listarTodo(Session sessao) throws HibernateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
