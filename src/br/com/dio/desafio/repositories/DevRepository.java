package br.com.dio.desafio.repositories;

import br.com.dio.desafio.dominio.Dev;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DevRepository {

    private static final Set<Dev> devs = new HashSet<>();

    public static void save(Dev dev){
        devs.add(dev);
    }

    public static Set<Dev> findAll(){
        return devs;
    }

    public static Optional<Dev> findByName(String name){
        return devs.stream()
                .filter(d -> d.getNome().equals(name) )
                .findFirst();
    }

    public static boolean delete(Dev dev){
        if(devs.contains(dev)){
            devs.remove(dev);
            return true;
        }
        return false;
    }
}
