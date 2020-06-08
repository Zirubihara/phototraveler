package com.phototraveler.phototraveler.Exception;

public class QuestNotFoundException extends RuntimeException{
    QuestNotFoundException(Long id){super("nie znaleziono questu " +id);}
}
