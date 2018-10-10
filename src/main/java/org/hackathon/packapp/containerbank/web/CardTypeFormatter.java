
package org.hackathon.packapp.containerbank.web;


import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.hackathon.packapp.containerbank.model.CardType;
import org.hackathon.packapp.containerbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 * Instructs Spring MVC on how to parse and print elements of type 'CardType'. Starting from Spring 3.0, Formatters have
 * come as an improvement in comparison to legacy PropertyEditors. See the following links for more details: - The
 * Spring ref doc: http://static.springsource.org/spring/docs/current/spring-framework-reference/html/validation.html#format-Formatter-SPI
 * - A nice blog entry from Gordon Dickens: http://gordondickens.com/wordpress/2010/09/30/using-spring-3-0-custom-type-converter/
 * <p/>
 * Also see how the bean 'conversionService' has been declared inside /WEB-INF/mvc-core-config.xml
 *
 * @author Wavestone
 */
public class CardTypeFormatter implements Formatter<CardType> {

    private final CardService cardService;


    @Autowired
    public CardTypeFormatter(CardService cardService) {
        this.cardService = cardService;
    }

    @Override
    public String print(CardType cardType, Locale locale) {
        return cardType.getName();
    }

    @Override
    public CardType parse(String text, Locale locale) throws ParseException {
        Collection<CardType> findCardTypes = this.cardService.findCardTypes();
        for (CardType type : findCardTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }

}
