package com.empresa.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.app.models.EstoqueModel;
import com.empresa.app.models.EstoqueModelPk;
import com.empresa.app.projections.EstoqueProdutoFilialProjection;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, EstoqueModelPk> {

    // JPQL (Java Persistence Query Language) consulta utilizando entidades e seus atributos
    @Query("""
        select str(e.produtoModel.id) as idProduto,
               e.produtoModel.nome as nomeProduto,
               e.filialModel.cnpj as cnpjFilial,
               e.filialModel.nome as nomeFilial,
               e.preco as preco,
               e.quantidade as quantidade,
               e.validade as validade
        from EstoqueModel e
    """)
    List<EstoqueProdutoFilialProjection> findAllEstoqueProjecaoJpql();

    // Query nativa SQL para retorno da mesma projeção a partir das tabelas do banco
    @Query(value = """
        select cast(e.id_produto as varchar) as idProduto,
               p.nome as nomeProduto,
               e.cnpj_filial as cnpjFilial,
               f.nome as nomeFilial,
               e.preco as preco,
               e.quantidade as quantidade,
               e.validade as validade
          from estoque e
          join produto p on e.id_produto = p.id
          join filial f on e.cnpj_filial = f.cnpj
    """, nativeQuery = true)
    List<EstoqueProdutoFilialProjection> findAllEstoqueProjecaoQueryNative();
}
