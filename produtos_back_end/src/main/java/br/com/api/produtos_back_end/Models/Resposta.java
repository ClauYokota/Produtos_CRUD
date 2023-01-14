package br.com.api.produtos_back_end.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Resposta {
    private String mensagem;
}
