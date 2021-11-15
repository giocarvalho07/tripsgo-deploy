package com.tripsgov2manager.repository;

import com.tripsgov2manager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository< Usuario, Long> {

    @Query("select i from Usuario i where i.email = :email")
    public Usuario findByEmail(String email);

    @Query("select u from Usuario u where u.user = :user and u.senha = :senha")
    public Usuario findByLogin(String user, String senha);
}
