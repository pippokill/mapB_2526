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

    public Candidato(String nome, int livelloForza) {
        this.nome = nome;
        this.livelloForza = livelloForza;
    }

    public Candidato() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLivelloForza() {
        return livelloForza;
    }

    public void setLivelloForza(int livelloForza) {
        this.livelloForza = livelloForza;
    }

    public double getCostoIngaggio() {
        return costoIngaggio;
    }

    public void setCostoIngaggio(double costoIngaggio) {
        this.costoIngaggio = costoIngaggio;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public boolean isPossiedeNeve() {
        return possiedeNeve;
    }

    public void setPossiedeNeve(boolean possiedeNeve) {
        this.possiedeNeve = possiedeNeve;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nome);
        return hash;
    }

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

    @Override
    public String toString() {
        return "Candidato{" + "nome=" + nome + ", livelloForza=" + livelloForza + ", costoIngaggio=" + costoIngaggio + ", specializzazione=" + specializzazione + ", possiedeNeve=" + possiedeNeve + '}';
    }
    
    
    
}
