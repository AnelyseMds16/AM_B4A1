import java.util.*;
import java.time.*;

class Pessoa {
    private String nome = "";
    private Date dataNascimento;
    private double altura;
    private int idade;

    public void setIdade(int id) {
        this.idade = id;
    }
    public int getIdade() {
        return idade;
    }

    //
    public void setNome(String n) {
        this.nome = n;
    }
    public String getNome() {
        return nome;
    }

    //
    public void setData(Date date) {
        this.dataNascimento = date;
    }
        public Date getData() {
        return dataNascimento;
    }

    //
    public void setAltura(double alt) {
        this.altura = alt;
    }
    public double getAltura() {
        return altura;
    }


    public void imprime() {
        System.out.println("Nome: " + nome);
        System.out.println("Data de nascimento: " + dataNascimento);
        System.out.println("Altura: " + altura);
    }

    public int CalculoIdade() {
        Calendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.setTime(dataNascimento);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        this.idade = age;
        return age;
    }
}

class Agenda {
    private Pessoa pessoas[] = new Pessoa[10];
    public Agenda() {
        for (int i = 0; i <= 9; i++) {
            pessoas[i] = new Pessoa();
        }
    }

    //
    public void armazenaPessoa(String n, int id, double a) {
        for(int i = 0; i <= 9; i++) {
            if (pessoas[i].getNome() == "") {
                pessoas[i].setNome(n);
                pessoas[i].setAltura(a);
                pessoas[i].setIdade(id);
                i = 10;
            }
        }
    }

        //
    public void removePessoa(String n) {
        for (int i = 0; i < 10; i++) {
            if (pessoas[i].getNome() == n) {
                pessoas[i].setNome("");
                pessoas[i].setAltura(0);
                pessoas[i].setIdade(0);
                i = 10;
            }
        }
    }

    //
    public int buscaPessoa(String n) {
        for (int i = 0; i < 10; i++) {
            if (pessoas[i].getNome() == n) {
                return i;
            }   
        }
        return -1;
    }

    //
    public void imprimeAgenda() {
        for (int i = 0; i < 10; i++) {
            pessoas[i].imprime();
            System.out.println("");
        }
    }

    //
    public void imprimePessoa(int i) {
        pessoas[i].imprime();
    }
}
    
class q1 {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        agenda.armazenaPessoa("Herbert", 25, 2.10);
        agenda.armazenaPessoa("Anelyse", 18, 1.60);
        System.out.println(agenda.buscaPessoa("Anelyse"));
        agenda.imprimeAgenda();
        agenda.imprimePessoa(2);
        agenda.removePessoa("Anelyse");
        agenda.imprimeAgenda();
    }
}
