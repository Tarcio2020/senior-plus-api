package org.example.seniorplus.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Document(value = "consulta")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cpf;
    private String nomeMedico;
    private String especialidade;
    private LocalDate data;
    private LocalTime hora;
    private String local; // nome da clínica ou hospital
    private String observacoes; // anotações gerais do médico
    private String imgReceita;

    public Consulta() {
    }

    public Consulta(String cpf, String nomeMedico, String especialidade, LocalDate data, LocalTime hora, String local, String observacoes, String imgReceita) {
        this.cpf = cpf;
        this.nomeMedico = nomeMedico;
        this.especialidade = especialidade;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.observacoes = observacoes;
        this.imgReceita = imgReceita;
    }

    public String getId() {
        return cpf;
    }

    public void setId(String id) {
        this.cpf = cpf;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getImgReceita() {
        return imgReceita;
    }

    public void setImgReceita(String imgReceita) {
        this.imgReceita = imgReceita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return Objects.equals(cpf, consulta.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
