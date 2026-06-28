package com.acme.ei;

import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tarefas")
@Singleton // Mantém o estado da lista na memória do WildFly
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarefaResource {

    private final List<Tarefa> lista = new ArrayList<>();
    private int contadorId = 1;

    public TarefaResource() {
        lista.add(new Tarefa(contadorId++, "Estudar o servidor WildFly"));
        lista.add(new Tarefa(contadorId++, "Gravar o vídeo para o Classroom"));
    }

    @GET
    public List<Tarefa> listar() {
        return lista;
    }
}