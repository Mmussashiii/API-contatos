package api.contatos.contatos.service;
import api.contatos.contatos.domain.Contatos;

import java.util.List;
import java.util.UUID;

//Interface do serviço.
//Usado apenas para padronizar os métodos
//Não recomendo criar direto na ContatosServiceImpl
public interface ContatosService{

    Contatos save(Contatos contatos);
    void delete(Contatos contatos);
    Contatos findById(UUID id);
    Contatos update(UUID contatoId,Contatos contatos);
    List<Contatos> findbyname();


}
