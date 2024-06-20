package br.com.fiap.checkpoint2.controller.dto.contratacao;

import br.com.fiap.checkpoint2.model.Contratacao;


public class SearchedContratacao {
    private Long numero_contratacao, codigo_cliente;

    public Long getNumero_contratacao() {
        return numero_contratacao;
    }

    public void setNumero_contratacao(Long numero_contratacao) {
        this.numero_contratacao = numero_contratacao;
    }

    public Long getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Long codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }
    
    public static SearchedContratacao toDto(Contratacao contratacao){
        SearchedContratacao dto = new SearchedContratacao();
        dto.setNumero_contratacao(contratacao.getNumero_contratacao());
        dto.setCodigo_cliente(contratacao.getCodigo_cliente());
        return dto;
    }
}
