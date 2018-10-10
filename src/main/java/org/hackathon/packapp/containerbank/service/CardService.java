package org.hackathon.packapp.containerbank.service;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Card;
import org.hackathon.packapp.containerbank.model.CardType;
import org.springframework.dao.DataAccessException;

public interface CardService {

    Collection<CardType> findCardTypes() throws DataAccessException;
    
    Card findCardById(int id) throws DataAccessException;

    void saveCard(Card card) throws DataAccessException;
    
}
