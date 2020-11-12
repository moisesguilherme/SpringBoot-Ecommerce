package org.una.sdm.aula09.aula11;

import java.util.Objects;

public class DictionaryWord {

	private Long id;

	private String word;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DictionaryWord that = (DictionaryWord) o;
		return Objects.equals(word, that.word);
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}
}