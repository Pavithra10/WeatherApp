/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.hft.dbproject.weatherapp.persistence;

import net.hft.dbproject.weatherapp.entities.UserBase;

/**
 * Interface for the UserService
 * 
 * @author Jan
 */
public interface UserBaseService {
    
    public void saveNewUser(UserBase user);
    
}
