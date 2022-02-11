/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Fornecedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public interface FornecedorDao extends BaseDao<Fornecedor, Long>{
    
    List<Fornecedor> listarTodo(Session sessao) throws HibernateException;
    
}
