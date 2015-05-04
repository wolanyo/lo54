/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.coursesmanager.core.repository.Interface;

import java.util.Set;

/**
 *
 * @author 
 * @param <entity>
 * @param <parameterType>
 */
public interface InterfaceDAO <entity,parameterType>{
    
     public entity getById(parameterType id);
     
     public Set<entity> getList();
     public void create(entity em);
     public void update(entity em);
     public void delete(entity em);
     
}
