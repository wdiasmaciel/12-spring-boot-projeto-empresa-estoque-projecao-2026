package com.empresa.app.projections;

import java.time.LocalDate;
import java.util.UUID;

public interface EstoqueProdutoFilialProjection {

    UUID getIdProduto();

    String getNomeProduto();

    String getCnpjFilial();

    String getNomeFilial();

    double getPreco();

    int getQuantidade();

    LocalDate getValidade();
}
