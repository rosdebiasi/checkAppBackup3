package com.checkapp.controle;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

@Named(value = "googleC")
@Scope("session")
public class GoogleControle implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome = "sem_usuario";
    private String urlImagem = "sem_imagem";
    private String email = "sem_email";

    @PostConstruct
    public void inicializar() {
        DefaultOidcUser user = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        Name: [109310311441636393484],
//        Granted Authorities: [
//          [ROLE_USER, SCOPE_https://www.googleapis.com/auth/userinfo.email, SCOPE_https://www.googleapis.com/auth/userinfo.profile, SCOPE_openid]
//        ],
//        User Attributes: [{
//          picture=https://lh3.googleusercontent.com/a/AItbvmlfJ0n_n5U1IVlsStu9ZloBSJoeI7XlThnVQBgo=s96-c,
//          name=Crineu Tres
//          email=crineu.tres@ufsc.br
//        }]
        nome = user.getAttribute("name");
        urlImagem = user.getAttribute("picture");
        email = user.getAttribute("email");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
