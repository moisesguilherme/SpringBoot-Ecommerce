package org.una.sdm.aula09.aula11.builders;

import org.una.sdm.aula09.aula11.Dictionary;
import org.una.sdm.aula09.aula11.DictionaryWord;

import java.util.Set;

public class DictionaryBuilder {

    private Dictionary dictionary = new Dictionary();

    public DictionaryBuilder id(Long id){
        dictionary.setId(id);
        return this;
    }

    public DictionaryBuilder name(String name){
        dictionary.setName(name);
        return this;
    }

    public DictionaryBuilder buildWords(Set<DictionaryWord> words) {
        dictionary.setWords(words);
        return this;
    }

    public DictionaryBuilder addWord(DictionaryWord word) {
        dictionary.getWords().add(word);
        return this;
    }

    public Dictionary build() {
        return dictionary;
    }
}
