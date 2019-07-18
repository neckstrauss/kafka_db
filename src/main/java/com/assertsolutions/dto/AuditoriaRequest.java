package com.assertsolutions.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Auditoria Request DTO Object")
public class AuditoriaRequest {

	private BigDecimal idLog;
	
	private String cliente;
	private Date fechaLog;
	
	@NotNull
	private String usuarioCreacion;
	private String nivelLog;
	private String tipoEvento;
	private String descripcion;
	private String contenidoLog;
	private String ipOrigen;
	private String idExchange;
	private String aplicacion;
	private String operacion;

	
	public BigDecimal getIdLog() {
		return idLog;
	}

	public void setIdLog(BigDecimal idLog) {
		this.idLog = idLog;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Date getFechaLog() {
		return fechaLog;
	}

	public void setFechaLog(Date fechaLog) {
		this.fechaLog = fechaLog;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getNivelLog() {
		return nivelLog;
	}

	public void setNivelLog(String nivelLog) {
		this.nivelLog = nivelLog;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getContenidoLog() {
		return contenidoLog;
	}

	public void setContenidoLog(String contenidoLog) {
		this.contenidoLog = contenidoLog;
	}

	public String getIpOrigen() {
		return ipOrigen;
	}

	public void setIpOrigen(String ipOrigen) {
		this.ipOrigen = ipOrigen;
	}

	public String getIdExchange() {
		return idExchange;
	}

	public void setIdExchange(String idExchange) {
		this.idExchange = idExchange;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

}
