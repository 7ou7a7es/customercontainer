package org.hackathon.packapp.containerbank.service.impl;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Card;
import org.hackathon.packapp.containerbank.model.CardType;
import org.hackathon.packapp.containerbank.repository.CardRepository;
import org.hackathon.packapp.containerbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
	
    @Override
    @Transactional(readOnly = true)
    public Collection<CardType> findCardTypes() throws DataAccessException {
    	
    	long startTime = System.currentTimeMillis();
    	Collection<CardType> result = cardRepository.findCardTypes();
    	System.out.println("*** customercontainer CardServiceImpl method findCardTypes time : " + (System.currentTimeMillis() - startTime));
        return result;
    }


    @Override
    @Transactional(readOnly = true)
    public Card findCardById(int id) throws DataAccessException {
    	long startTime = System.currentTimeMillis();
    	Card result = cardRepository.findById(id);
    	System.out.println("*** customercontainer CardServiceImpl method findCardById id "+id +" time : " + (System.currentTimeMillis() - startTime));
    	return result;
    }

    @Override
    @Transactional
    public void saveCard(Card card) throws DataAccessException {
    	long startTime = System.currentTimeMillis();
        cardRepository.save(card);
        System.out.println("*** customercontainer CardServiceImpl method saveCard card "+ card.getId()+" time : " + (System.currentTimeMillis() - startTime));
    }
}
