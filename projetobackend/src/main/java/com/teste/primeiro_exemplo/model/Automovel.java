package com.teste.primeiro_exemplo.model;

public class Automovel {
    
     //id, marca, modelo, motor, cor, descricao
    //#region Atributos
    private Integer id;

    private String marca;

    private String modelo;

    private Double motor;

    private String cor;

    private String descricao;
    //#endregion

    //#region Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getMotor() {
        return motor;
    }

    public void setMotor(Double motor) {
        this.motor = motor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //#endregion
}
