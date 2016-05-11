package br.eti.gregori.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.eti.gregori.jdbc.ConnectionFactory;
import br.eti.gregori.jdbc.modelo.Contato;

public class ContatoDao {
	// Conexao ao banco
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public ContatoDao() {
		this.factory = Persistence.createEntityManagerFactory("contato");
		this.manager = factory.createEntityManager();
	}
	
	public void adiciona(Contato contato) {
		this.manager.persist(contato);
	}
	
	public Contato getContato(Long id) {
		Contato contato = this.manager.find(Contato.class, id);
		return contato;
	}
	
	public List<Contato> getLista() {
		@SuppressWarnings("unchecked")
		List<Contato> contatos = this.manager.createQuery("select c from contato c").getResultList();
		return contatos;
	}
	
	public void altera(Contato contato) {
		this.manager.merge(contato);
	}
	
	public void remove(Contato contato) {
		this.manager.remove(contato);
	 }
	
}
