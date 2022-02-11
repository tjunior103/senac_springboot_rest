/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_service;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Silvio
 */
@Provider
public class GensonProvider implements ContextResolver<Genson>{
    private Genson genson = new GensonBuilder().setSkipNull(true).create();

    public Genson getContext(Class<?> aClass) {
        return genson;
    }
}
