
package com.vffs.model;

/**
 *
 * @author valeria
 */
public class Curso {
    private Long id;
    private String nome;
    private Professor professor;

    public Curso(Long id, String nome, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
    }

    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nome=" + nome + ", professor=" + professor.getId() + '}';
    }

    public Long getId() {
        return id;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }  
    
    
}
