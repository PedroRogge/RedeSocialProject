package sp.senac.br.teste.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sp.senac.br.teste.entity.Usuario;
import sp.senac.br.teste.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);


    @GetMapping("/cadastroUsuario")
    public String usuario() {
        return "/cadastro_usuario";
    }

    @PostMapping("/salvar")
    public  String salvarUsuario(@RequestParam String nome,@RequestParam String email,@RequestParam String senha,@RequestParam String perfil){

        Usuario usuario = new Usuario(nome,email,senha,perfil);

        usuarioRepository.save(usuario);

        logger.info(usuario.toString());

        return "/cadastro_usuario";
    }
}
