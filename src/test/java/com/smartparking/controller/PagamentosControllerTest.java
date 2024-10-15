package com.smartparking.controller;

import com.smartparking.dto.PagamentoDTO;
import com.smartparking.entities.MessageErrorEntity;
import com.smartparking.service.PagamentosService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static com.smartparking.controller.utils.PagamentosControllerUtil.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;

// to using springs container to inject beans
@SpringBootTest
// Initiate Mock with spring
@AutoConfigureMockMvc
// Inject JSON for read and write
@AutoConfigureJsonTesters
class PagamentosControllerTest {

    private static final String BASE_PATH = "/v1/api/pagamentos";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PagamentosService service;

    @Autowired
    private JacksonTester<PagedModel<PagamentoDTO>> pagedModelJacksonTester;

    @Autowired
    private JacksonTester<PagamentoDTO> pagamentosDTOJacksonTester;

    @Autowired
    private JacksonTester<MessageErrorEntity> messageErrorEntityJacksonTester;

    @Test
    void shouldReturnStatusCode200ForPagebleData() throws Exception {

        var expected = getPageModelPagamentosDTO();

        when(service.getAllByPagination(0, 10)).thenReturn(expected);

        var response =
            mvc.perform(get(BASE_PATH).contentType(MediaType.APPLICATION_JSON))
                .andReturn()
                    .getResponse();

        assertEquals(200, response.getStatus());
        assertEquals(pagedModelJacksonTester.write(expected).getJson(), response.getContentAsString());
    }


    @ParameterizedTest
    @MethodSource
    void findingByIdOkResults(String objId, String stringId, int expectedStatusCode, PagamentoDTO expectedBodyResponse) throws Exception {

        var path = BASE_PATH + "/" + stringId;

        when(service.findById(objId)).thenReturn(expectedBodyResponse);

        var response =
                mvc.perform(get(path).contentType(MediaType.APPLICATION_JSON))
                        .andReturn()
                        .getResponse();

        System.out.println(response.getContentAsString());

        assertEquals(expectedStatusCode, response.getStatus());
        assertEquals(pagamentosDTOJacksonTester.write(expectedBodyResponse).getJson(), response.getContentAsString());
    }

    static Stream<Arguments> findingByIdOkResults() {
        return Stream.of (
            Arguments.arguments("64b7c3ecf2b3c82b8b4e91e8", "64b7c3ecf2b3c82b8b4e91e8", 200,  getPagamentosDTO( "1000")),
            Arguments.arguments("507f191e810c19729de860ea", "507f191e810c19729de860ea", 200,  getPagamentosDTO( "2000"))
        );
    }
}