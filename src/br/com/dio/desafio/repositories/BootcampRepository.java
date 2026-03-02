package br.com.dio.desafio.repositories;

import br.com.dio.desafio.dominio.Bootcamp;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class BootcampRepository {

    private static final Set<Bootcamp> bootcamps = new HashSet<>();

    public static void save(Bootcamp bootcamp){
        bootcamps.add(bootcamp);
    }

    public static Set<Bootcamp> findAll(){
        return bootcamps;
    }

    public static Optional<Bootcamp> findByName(String name){

        return bootcamps.stream()
                .filter(b -> b.getNome().equals(name))
                .findFirst();
    }

    public static boolean delete(Bootcamp bootcamp){
        if (bootcamps.contains(bootcamp)){
            bootcamps.remove(bootcamp);
            return true;
        }else{
            return false;
        }
    }

}
