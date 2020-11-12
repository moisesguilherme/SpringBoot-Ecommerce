package org.una.sdm.aula09.aula11.builders;

import org.una.sdm.aula09.aula11.DictionaryWord;

public class DictionaryWordBuilder {

    private DictionaryWord dictionaryWord = new DictionaryWord();

    public DictionaryWordBuilder id(Long id){
        dictionaryWord.setId(id);
        return this;
    }

    public DictionaryWordBuilder word(String word){
        dictionaryWord.setWord(word);
        return this;
    }

    public DictionaryWord build() {
        return dictionaryWord;
    }
}
