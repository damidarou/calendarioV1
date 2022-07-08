package com.nigmacode.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Usuario")
public class Usuario {

        //Crea las columnas de la tabla test, indicando el tipo de valor que van a almacenar
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="cod_usuario")
        private Integer cod_usuario;

        @Column(name="username")
        private String username;

        @Column(name="password")
        private String password;

    @OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("usuarios")
    private List<Ayuda> ayudas;

    @OneToMany(mappedBy = "usaurio", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("usaurio")
    private List<Evento> eventos;

    public Usuario() {
    }

    public Usuario(Integer cod_usuario, String username, String password) {
        this.cod_usuario = cod_usuario;
        this.username = username;
        this.password = password;
    }

    public Integer getCod_usuario() {
        return cod_usuario;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Ayuda> getAyudas() {
        return ayudas;
    }

    public void setAyudas(List<Ayuda> ayudas) {
        this.ayudas = ayudas;
    }
    public void setCod_usuario(Integer cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cod_usuario=" + cod_usuario +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
