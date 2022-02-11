/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import entidade.Endereco;
import java.net.URI;
import java.util.Map;

/**
 *
 * @author Silvio
 */
public class EnderecoWebService {

    private Client client;
    private WebResource webResource;

    public EnderecoWebService() {
        ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
        client = Client.create(clientConfig);
        //Utilizado para imprimir as operacoes no console
        client.addFilter(new LoggingFilter(System.out));
        webResource = client.resource("https://viacep.com.br/ws/");
    }

    public Endereco pesquisaCep(String cep) {
        Endereco ende = webResource.path(cep).path("/json").get(Endereco.class);
        return ende;
    }

    public static void main(String[] args) {
        EnderecoWebService webService = new EnderecoWebService();
        Endereco end = webService.pesquisaCep("88888888");
        System.out.println(end);
    }

}
