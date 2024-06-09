public class ConversorMoeda {
    private String moedaBase;
    private String moedaConverter;
    Double precoMoeda;
    Double valorConvertido;
    Double valorAConverter;

    public ConversorMoeda(moedasParaConverter moeda) {
        this.moedaBase = moeda.base_code();
        this.moedaConverter = moeda.target_code();
        this.precoMoeda = moeda.conversion_rate();
        this.valorConvertido = moeda.conversion_result();
    }

    public void setValorAConverter(Double valorAConverter) {
        this.valorAConverter = valorAConverter;
    }

    public Double getValorAConverter() {
        return valorAConverter;
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaConverter() {
        return moedaConverter;
    }

    public Double getValorConvertido() {
        return valorConvertido;
    }

    public String nomePorExtenso(String nome) {
        String nomePorExtenso = nome;

        switch (nome) {
            case "ARS":
                nomePorExtenso = "Peso Argentino";
                break;
            case "UYU":
                nomePorExtenso = "Peso Uruguaio";
                break;
            case "CLP":
                nomePorExtenso = "Peso Chileno";
                break;
            case "PEN":
                nomePorExtenso = "Sol Peruano";
                break;
            case "COP":
                nomePorExtenso = "Peso Colombiano";
                break;
            case "BRL":
                nomePorExtenso = "Real Brasileiro";
                break;
        }
        return nomePorExtenso;
    }

    @Override
    public String toString() {
        return "\n::::: " +
                "\n\tValor a converter: " + valorAConverter +
                "\n\tMoeda Base: " + moedaBase +
                ", \n\tMoeda para Converter: " + moedaConverter +
                ", \n\tvalorConvertido: " + valorConvertido +
                "\n::::: \n";
    }
}
