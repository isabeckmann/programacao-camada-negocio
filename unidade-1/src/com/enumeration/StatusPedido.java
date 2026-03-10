package com.enumeration;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO("Pedido recebido, aguardando pagamento do cliente"),
    PROCESSANDO("Pagamento aprovado, pedido em processamento"),
    ENVIADO("Pedido despachado pelo vendedor"),
    ENTREGUE("Produto chegou no destinatário"),
    CANCELADO("Cliente cancelou o pedido");

    private final String descricao;

    // Construtor da enum
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    // Getter
    public String getDescricao() {
        return descricao;
    }

    public boolean isFinalizado() {
        return this == ENTREGUE || this == CANCELADO;
    }
}