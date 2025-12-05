package api.contatos.contatos.controller;

import api.contatos.contatos.domain.Contatos;
import api.contatos.contatos.service.ContatoServiceImpl;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping()
public class ContatoController {
    private final ContatoServiceImpl contatoService;

    public ContatoController(ContatoServiceImpl contatoService) {
        this.contatoService = contatoService;
    }

    //1 - A, B, C
    @PostMapping("/contatos")
    public ResponseEntity<Contatos> save(@RequestBody Contatos contatos) {
        return ResponseEntity.status(201).body(contatoService.save(contatos));
    }

    //2 - A, B, C, D
    @PutMapping("/contatos/{contatoId}")
    public ResponseEntity<Contatos> atualizarContato(
            @PathVariable UUID contatoId,
            @RequestBody Contatos contatoAtualizado) {

        try {
            Contatos contatoSalvo = contatoService.update(contatoId, contatoAtualizado);

            if (contatoSalvo == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(contatoSalvo);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    //3 - A, B, C, D, E
    @GetMapping("/contatos")
    public List<Contatos> listarContatos() {
        List<Contatos> contatos = contatoService.findbyname();
        return contatos;
    }
    //4 - A, B, C
    @DeleteMapping("/contatos/{contatoId}")
    public ResponseEntity<Void> deleteContato(@PathVariable UUID contatoId) {

        Contatos contato = contatoService.findById(contatoId);

        if (contato == null) {
            return ResponseEntity.notFound().build();
        }

        contatoService.delete(contato);

        return ResponseEntity.noContent().build();
    }




}
