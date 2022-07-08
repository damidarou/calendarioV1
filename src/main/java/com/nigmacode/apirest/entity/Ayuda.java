package com.nigmacode.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Ayuda")
public class Ayuda {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cod_ayuda")
    private Integer cod_ayuda;

    @Column(name="tema")
    private String tema;

    @Column(name="respuesta")
    private String respuesta;

    @Column(name = "usuario")
    private int usuario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @JsonIgnoreProperties("ayudas")
    private Usuario usuarios;

    public Ayuda() {
    }

    public Ayuda(Integer cod_ayuda, String tema, String respuesta, int usuario) {
        this.cod_ayuda = cod_ayuda;
        this.tema = tema;
        this.respuesta = respuesta;
        this.usuario = usuario;
    }

    public Integer getCod_ayuda() {
        return cod_ayuda;
    }

    public void setCod_ayuda(Integer cod_ayuda) {
        this.cod_ayuda = cod_ayuda;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Ayuda{" +
                "cod_ayuda=" + cod_ayuda +
                ", tema='" + tema + '\'' +
                ", respuesta='" + respuesta + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
