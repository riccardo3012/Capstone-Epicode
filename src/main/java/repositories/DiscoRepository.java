package repositories;


import entities.Disco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscoRepository extends JpaRepository <Disco, Integer > {

    List<Disco> getAll();
    List<Disco> findDiscoById(int id);



}

