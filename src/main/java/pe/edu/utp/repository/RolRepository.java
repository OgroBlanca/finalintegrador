package pe.edu.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.utp.model.Rol;
import pe.edu.utp.model.Rol.RolEnum;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
   Rol findByNombreRol(RolEnum nombreRol);
}