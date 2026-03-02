import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.repositories.BootcampRepository;
import br.com.dio.desafio.repositories.DevRepository;
import br.com.dio.desafio.services.DevService;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        DevService devService = new DevService();

        Dev dev = new Dev();
        dev.setNome("João");

        Conteudo conteudo = new Mentoria();
        conteudo.setTitulo("Mentoria Java");
        conteudo.setDescricao("Descrição Mentoria Java");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java DIO");
        bootcamp.setDescricao("Descrição Bootcamp Java DIO");
        bootcamp.getConteudos().add(conteudo);


        try {
            dev = devService.newDev(dev);
            BootcampRepository.save(bootcamp);
            devService.subscribeBootcamp(1,1);

            devService.progress(dev.getId());


        }catch (Exception e){
            System.out.println("Exception --> "+ e.getMessage());
            return;
        }


        System.out.println("===== Devs =====");
        System.out.println(DevRepository.findAll());

        System.out.println("===== Bootcamps ====");
        System.out.println(BootcampRepository.findAll());


    }

}
