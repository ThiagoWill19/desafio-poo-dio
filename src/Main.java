import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.repositories.BootcampRepository;
import br.com.dio.desafio.repositories.DevRepository;


public class Main {

    public static void main(String[] args) {


        Dev dev = new Dev();
        dev.setNome("Thiago");

        Conteudo conteudo = new Mentoria();
        conteudo.setTitulo("Mentoria Java");
        conteudo.setDescricao("Descrição Mentoria Java");


        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setNome("Bootcamp Java DIO");
        bootcamp.setDescricao("Descrição Bootcamp Java DIO");
        bootcamp.getConteudos().add(conteudo);

        bootcamp.getDevsInscritos().add(dev);
        dev.getConteudosInscritos(bootcamp.getConteudos());

        BootcampRepository.save(bootcamp);
        DevRepository.save(dev);

        System.out.println("===== Bootcamps =====");
        System.out.println(BootcampRepository.findAll());

        System.out.println("===== Devs =====");
        System.out.println(DevRepository.findAll());



    }

}
