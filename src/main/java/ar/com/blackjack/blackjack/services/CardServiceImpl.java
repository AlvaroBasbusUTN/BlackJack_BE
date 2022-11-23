package ar.com.blackjack.blackjack.services;

import ar.com.blackjack.blackjack.DTOS.CardDto;
import ar.com.blackjack.blackjack.models.Card;
import ar.com.blackjack.blackjack.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    private final ModelMapper modelMapper;




    @Override
    public List<Card> findAll() {
        List<Card> cartas= cardRepository.findAll();
        return  cartas;

    }


   public List<CardDto> traer(){
       List<Card> cartas2= cardRepository.findAll();

       List<CardDto> listDto= cartas2.stream()
               .map(entity -> modelMapper.map(entity, CardDto.class))
               .collect(Collectors.toList());


       return listDto;

    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }
}
