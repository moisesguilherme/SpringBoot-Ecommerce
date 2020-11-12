package org.una.sdm.aula09.controllers.mappers;

import org.una.sdm.aula09.controllers.representations.ProdutoRepresentation;
import org.una.sdm.aula09.domain.Produto;
import org.una.sdm.aula09.domain.builders.CategoriaBuilder;
import org.una.sdm.aula09.domain.builders.ProdutoBuilder;

public class ProdutoMapper {

    public static Produto inbound(ProdutoRepresentation representation) {

        Produto produto = new ProdutoBuilder()
                .nome(representation.getNome())
                .preco(representation.getPreco())
                .categoria(new CategoriaBuilder()
                        .id(representation.getCategoriaId())
                        .build())
                .build();

        return  produto;
    }

    public static ProdutoRepresentation outbound(Produto produto) {

        return null;
    }
}
