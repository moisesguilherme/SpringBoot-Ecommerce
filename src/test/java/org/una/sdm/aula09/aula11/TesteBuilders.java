package org.una.sdm.aula09.aula11;

import org.una.sdm.aula09.aula11.builders.DictionaryBuilder;
import org.una.sdm.aula09.aula11.builders.DictionaryWordBuilder;

public class TesteBuilders {

    public static void main(String[] args){



        Dictionary dictionary = new DictionaryBuilder()
                .id(1L)
                .name("Palavras em inglês")
                .addWord(new DictionaryWordBuilder()
                        .id(1L)
                        .word("new")
                        .build())
                .addWord(new DictionaryWordBuilder()
                        .id(2L)
                        .word("builder")
                        .build())
                .build();

        Dictionary cloneDictionary = dictionary.clone();

        System.out.println(dictionary);

    }
}
