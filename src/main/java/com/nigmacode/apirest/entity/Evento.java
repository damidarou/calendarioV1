package com.nigmacode.apirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cod_evento")
    private Integer cod_evento;

    @Column(name="usuario")
    private int usuario;

    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "hora")
    private Time hora;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario", referencedColumnName = "cod_usuario", insertable = false, updatable = false)
    @JsonIgnoreProperties("eventos")
    private Usuario usaurio;

    @OneToMany(mappedBy = "eventos1", fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnoreProperties("eventos1")
    private List<Tipo_evento> tipo_eventos;

    public Evento() {
    }

    public Evento(Integer cod_evento, int usuario, LocalDate fecha, Time hora, String nombre, String descripcion, String ubicacion) {
        this.cod_evento = cod_evento;
        this.usuario = usuario;
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public List<Tipo_evento> getTipo_eventos() {
        return tipo_eventos;
    }

    public void setTipo_eventos(List<Tipo_evento> tipo_eventos) {
        this.tipo_eventos = tipo_eventos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getCod_evento() {
        return cod_evento;
    }

    public void setCod_evento(Integer cod_evento) {
        this.cod_evento = cod_evento;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "cod_evento=" + cod_evento +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                ", hora='" + hora + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
