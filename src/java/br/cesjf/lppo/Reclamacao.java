
package br.cesjf.lppo;

public class Reclamacao {
    private long id;
    private String nome;
    private String email;
    private String descricao;
    private int status;

    public Reclamacao(){
    
    }
    
    public long getId() {
        return id;
    }

  
    public void setId(long id) {
        this.id = id;
    }

   
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

   
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    public int getStatus() {
        return status;
    }

    
    public void setStatus(int status) {
        this.status = status;
    }
    
}
