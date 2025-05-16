package org.example.seniorplus.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document(collection = "idoso")
public class Idoso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cpf;
    private String rg;
    private String nome;
    private String email;
    private Date dataNascimento;
    private String telefone;
    private Double peso;
    private Double altura;
    private String tipoSanguineo;
    private String observacao;
    private String imc;

    @DBRef
    private List<Endereco> enderecos = new ArrayList<>();

    public Idoso() {
    }

    public Idoso(String cpf, String rg, String nome, String email, Date dataNascimento, String telefone, Double peso, Double altura, String tipoSanguineo, String observacao, String imc) {
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.peso = peso;
        this.altura = altura;
        this.tipoSanguineo = tipoSanguineo;
        this.observacao = observacao;
        this.imc = imc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getImc() {
        if (this.peso == null || this.altura == null || this.altura == 0) {
            return "Dados insuficientes para calcular o IMC.";
        }

        double imc = this.peso / (this.altura * this.altura);
        String classificacao;

        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc < 25) {
            classificacao = "Peso normal";
        } else if (imc < 30) {
            classificacao = "Sobrepeso";
        } else if (imc < 35) {
            classificacao = "Obesidade grau I";
        } else if (imc < 40) {
            classificacao = "Obesidade grau II";
        } else {
            classificacao = "Obesidade grau III (mórbida)";
        }

        return String.format("IMC: %.2f - %s", imc, classificacao);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Idoso idoso = (Idoso) o;
        return Objects.equals(cpf, idoso.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

}

