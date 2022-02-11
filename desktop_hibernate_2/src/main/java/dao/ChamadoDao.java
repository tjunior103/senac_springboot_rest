/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidade.Chamado;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Silvio
 */
public interface ChamadoDao extends BaseDao<Chamado, Long>{
    
    List<Chamado> pesquisarPorEquipamento(String nome, Session sessao) throws HibernateException;
    
    List<Chamado> pesquisarChamadoAberto(Session sessao) throws HibernateException;
    
    List<Chamado> pesquisarPorData(Date data_pesquisa, Session sessao) throws HibernateException;
    
    
}
