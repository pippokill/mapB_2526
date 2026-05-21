/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package di.uniba.map.b.lab.lambda.esercizi;

import java.util.Objects;

/**
 *
 * @author pierpaolo
 */
public class Candidato {
    
    private String nome;
    
    private int livelloForza;
    
    private double costoIngaggio;
    
    private String specializzazione;
    
    private boolean possiedeNeve;

    /**
     *
     * @param nome
     * @param livelloForza
     */
    public Candidato(String nome, int livelloForza) {
        this.nome = nome;
        this.livelloForza = livelloForza;
    }

    /**
     *
     */
    public Candidato() {
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public int getLivelloForza() {
        return livelloForza;
    }

    /**
     *
     * @param livelloForza
     */
    public void setLivelloForza(int livelloForza) {
        this.livelloForza = livelloForza;
    }

    /**
     *
     * @return
     */
    public double getCostoIngaggio() {
        return costoIngaggio;
    }

    /**
     *
     * @param costoIngaggio
     */
    public void setCostoIngaggio(double costoIngaggio) {
        this.costoIngaggio = costoIngaggio;
    }

    /**
     *
     * @return
     */
    public String getSpecializzazione() {
        return specializzazione;
    }

    /**
     *
     * @param specializzazione
     */
    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    /**
     *
     * @return
     */
    public boolean isPossiedeNeve() {
        return possiedeNeve;
    }

    /**
     *
     * @param possiedeNeve
     */
    public void setPossiedeNeve(boolean possiedeNeve) {
        this.possiedeNeve = possiedeNeve;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candidato other = (Candidato) obj;
        return Objects.equals(this.nome, other.nome);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Candidato{" + "nome=" + nome + ", livelloForza=" + livelloForza + ", costoIngaggio=" + costoIngaggio + ", specializzazione=" + specializzazione + ", possiedeNeve=" + possiedeNeve + '}';
    }
    
    
    
}
