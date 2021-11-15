package com.tripsgov2manager.model;

public enum Pagamento {

    PIX("Pix"),
    TRANSFERENCIA("Transferencia"),
    CREDITO("Credito"),
    DEBITO("Debito"),
    BOLETO("Boleto");

    private String pagamento;

    private Pagamento (String pagamento) {
        this.pagamento = pagamento;
    }
}
