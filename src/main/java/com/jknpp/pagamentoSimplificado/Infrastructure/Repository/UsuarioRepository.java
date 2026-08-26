package com.jknpp.pagamentoSimplificado.Infrastructure.Repository;

import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
