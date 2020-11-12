package org.una.sdm.aula09.aula11;

import org.una.sdm.aula09.aula11.builders.DictionaryWordBuilder;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Dictionary implements Cloneable {

	private Long id;

	private String name;

	private Set<DictionaryWord> words = new HashSet<>();

	//gets e sets

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DictionaryWord> getWords() {
		return words;
	}

	public void setWords(Set<DictionaryWord> words) {
		this.words = words;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Dictionary that = (Dictionary) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public Dictionary clone() {
		Dictionary clone = new Dictionary();
		clone.setId(this.getId());
		clone.setName(this.getName());
		clone.setWords(this.getWords().stream()
				.map(dw -> new DictionaryWordBuilder()
						.id(dw.getId())
						.word(dw.getWord())
						.build())
				.collect(Collectors.toSet()));
		return clone;
	}
}