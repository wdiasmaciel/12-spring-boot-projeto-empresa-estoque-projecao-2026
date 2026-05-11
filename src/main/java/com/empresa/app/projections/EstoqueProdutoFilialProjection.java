package com.empresa.app.projections;

import java.time.LocalDate;

public interface EstoqueProdutoFilialProjection {

    String getIdProduto();

    String getNomeProduto();

    String getCnpjFilial();

    String getNomeFilial();

    double getPreco();

    int getQuantidade();

    LocalDate getValidade();
}
