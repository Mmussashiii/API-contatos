package api.contatos.contatos.service;

import api.contatos.contatos.domain.Contatos;
import api.contatos.contatos.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//Regras de negócio aqui e nada mais
@Service
public class ContatoServiceImpl implements ContatosService {

    private final ContatoRepository contatoRepository;

    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }


    @Override
    public Contatos save(Contatos contatos) {
        if (contatoRepository.findByEmail(contatos.getEmail()).isPresent()) {
            return null;
        }

        return contatoRepository.save(contatos);
    }

    @Override
    public void delete(Contatos contatos) {
        contatoRepository.delete(contatos);
    }

    @Override
    public Contatos findById(UUID id) {
        return contatoRepository.findById(id)
                .orElse(null);
    }


    @Override
    public Contatos update(UUID contatoId, Contatos contatoAtt) {
        Contatos contatoExistente = contatoRepository.findById(contatoId).orElse(null);

        if (contatoExistente == null) {
            return null;
        }

        if (contatoAtt.getNome() == null || contatoAtt.getNome().isEmpty()
                || contatoAtt.getDataNascimento() == null
                || contatoAtt.getEmail() == null || contatoAtt.getEmail().isEmpty()) {
            throw new IllegalArgumentException("itens obrigatorios");
        }

        contatoExistente.setNome(contatoAtt.getNome());
        contatoExistente.setDataNascimento(contatoAtt.getDataNascimento());
        contatoExistente.setEmail(contatoAtt.getEmail());
        contatoExistente.setTelefone(contatoAtt.getTelefone());
        contatoExistente.setEndereco(contatoAtt.getEndereco());

        return contatoRepository.save(contatoExistente);
    }
    @Override
    public List<Contatos> findbyname() {

        return contatoRepository.findAllByOrderByNomeAsc();
    }
    
}
