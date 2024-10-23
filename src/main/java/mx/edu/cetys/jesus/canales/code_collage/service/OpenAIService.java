package mx.edu.cetys.jesus.canales.code_collage.service;

//import org.springframework.ai.openai.OpenAiService;
//import org.springframework.ai.openai.completion.CompletionRequest;
//import org.springframework.ai.openai.completion.CompletionResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.edu.cetys.jesus.canales.code_collage.model.Dog;

@Service
public class OpenAIService {

    private final ChatClient singularidad;

    public OpenAIService(ChatClient.Builder singularidad) {
        this.singularidad = singularidad.build();
    }


//
//
//    @Autowired
//    public OpenAIService(OpenAiService openAiService) {
//        this.openAiService = openAiService;
//    }

    public String getDogDescription(Dog dog) {

        var prompt = String.format("Describe un perro llamado %s, de raza %s y que tiene %d años y da una descrupcion muy bonita de perro.",
                dog.getName(), dog.getBreed(), dog.getAge());

        var response = this.singularidad
                .prompt()
                .user(prompt)
                .call()
                .content();

        return response;
//        // Crear el prompt para describir el perro
//        String prompt = String.format("Describe un perro llamado %s, de raza %s y que tiene %d años.",
//                dog.getName(), dog.getBreed(), dog.getAge());
//
//        // Crear la solicitud de completado
//        CompletionRequest request = CompletionRequest.builder()
//                .prompt(prompt)
//                .maxTokens(100)
//                .build();
//
//        // Llamar al servicio OpenAI para obtener la respuesta
//        CompletionResponse response = openAiService.createCompletion(request);
//
//        // Retornar la descripción del perro
//        return response.getChoices().get(0).getMessage().getContent();
    }
}
