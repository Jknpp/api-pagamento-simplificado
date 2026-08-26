package com.jknpp.pagamentoSimplificado.Service;

import com.jknpp.pagamentoSimplificado.Infrastructure.Entity.Usuario;
import com.jknpp.pagamentoSimplificado.Infrastructure.Exceptions.UserNotFound;
import com.jknpp.pagamentoSimplificado.Infrastructure.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
    }
}
