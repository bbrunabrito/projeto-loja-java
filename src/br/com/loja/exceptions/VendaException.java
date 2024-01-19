package br.com.loja.exceptions;

public class VendaException extends Exception {
    private String mensagem;
    private String detalhes;
    private CodigoErro codigoErro;

    public VendaException(String mensagem, String detalhes, CodigoErro codigoErro) {
        this.mensagem = mensagem;
        this.detalhes = detalhes;
        this.codigoErro = codigoErro;
    }


    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }

    @Override
    public String toString() {
        return "\n" +
                "Erro: " + mensagem +
                "\nDetalhes: " + detalhes +
                "\nCodigo do Erro: " + codigoErro;
    }
}
